package hello.mvc.servlet.web.frontcontroller.v3;

import hello.mvc.servlet.web.frontcontroller.ModelView;
import hello.mvc.servlet.web.frontcontroller.MyView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Model 추가
 * 서블릿 종속성 제거
 * 뷰 이름 중복 제거
 */
/**
 * urlPatterns: /front-controller/v3 를 포함한 하위 모든 요청을 받음
 * requestURI 를 조회해서 controllerMap 에서 찾아 Controller 반환
 * Controller 에 ParamMap 을 넘김
 * Controller 가 null 이 아니면 로직 실행해서 ModelView 반환 (null 인 경우 404 에러), 이때 논리 View 주소 지정
 * ModelView 에서 viewName 을 꺼내 viewResolver 를 통해서 MyView(실제 View 주소) 반환
 * myView.render -> dispatcher.forward: 다른 서블릿이나 JSP로 이동하는 기능, 서버 내부에서 다시 호출이 발생
 * myView.render 에 model 을 추가로 넘겨 request.setAttribute 로 매핑
 */
@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {

    private Map<String, ControllerV3> controllerMap = new HashMap<>();

    public FrontControllerServletV3() {
        controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("FrontControllerServletV3.service");
        String requestURI = request.getRequestURI();

        ControllerV3 controller = controllerMap.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String, String> paramMap = createParamMap(request);
        ModelView mv = controller.process(paramMap);

        String viewName = mv.getViewName();
        MyView view = viewResolver(viewName);
        view.render(mv.getModel(), request, response);
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();

        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }
}
