package hello.mvc.servlet.web.frontcontroller.v4;

import hello.mvc.servlet.web.frontcontroller.ModelView;
import hello.mvc.servlet.web.frontcontroller.MyView;
import hello.mvc.servlet.web.frontcontroller.v3.ControllerV3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 단순하고 실용적인 컨트롤러
 * v3와 거의 비슷
 * 구현 입장에서 ModelView를 직접 생성해서 반환하지 않도록 편리한 인터페이스 제공
 */
/**
 * urlPatterns: /front-controller/v4 를 포함한 하위 모든 요청을 받음
 * requestURI 를 조회해서 controllerMap 에서 찾아 Controller 반환
 * Controller 에 ParamMap 과 Model 을 넘김
 * Controller 가 null 이 아니면 로직 실행해서 논리 View 반환 (null 인 경우 404 에러)
 * viewResolver 를 통해서 MyView(실제 View 주소) 반환
 * myView.render -> dispatcher.forward: 다른 서블릿이나 JSP로 이동하는 기능, 서버 내부에서 다시 호출이 발생
 * myView.render 에 model 을 추가로 넘겨 request.setAttribute 로 매핑
 */
@WebServlet(name = "frontControllerServletV4", urlPatterns = "/front-controller/v4/*")
public class FrontControllerServletV4 extends HttpServlet {

    private Map<String, ControllerV4> controllerMap = new HashMap<>();

    public FrontControllerServletV4() {
        controllerMap.put("/front-controller/v4/members/new-form", new MemberFormControllerV4());
        controllerMap.put("/front-controller/v4/members/save", new MemberSaveControllerV4());
        controllerMap.put("/front-controller/v4/members", new MemberListControllerV4());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("FrontControllerServletV4.service");
        String requestURI = request.getRequestURI();

        ControllerV4 controller = controllerMap.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String, String> paramMap = createParamMap(request);
        Map<String, Object> model = new HashMap<>(); // 추가

        String viewName = controller.process(paramMap, model);

        MyView view = viewResolver(viewName);
        view.render(model, request, response);
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
