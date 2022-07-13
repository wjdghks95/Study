package hello.mvc.servlet.web.frontcontroller.v2;

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
 * View 분류
 * 단순 반복 되는 뷰 로직 분리
 */
/**
 * urlPatterns: /front-controller/v2 를 포함한 하위 모든 요청을 받음
 * requestURI 를 조회해서 controllerMap 에서 찾아 Controller 반환
 * Controller 가 null 이 아니면 로직 실행해서 MyView 반환 (null 인 경우 404 에러)
 * myView.render -> dispatcher.forward: 다른 서블릿이나 JSP로 이동하는 기능, 서버 내부에서 다시 호출이 발생
 */
@WebServlet(name = "frontControllerServletV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {

    private Map<String, ControllerV2> controllerMap = new HashMap<>();

    public FrontControllerServletV2() {
        controllerMap.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
        controllerMap.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
        controllerMap.put("/front-controller/v2/members", new MemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("FrontControllerServletV2.service");
        String requestURI = request.getRequestURI();

        ControllerV2 controller = controllerMap.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyView myView = controller.process(request, response);
        myView.render(request, response);
    }
}
