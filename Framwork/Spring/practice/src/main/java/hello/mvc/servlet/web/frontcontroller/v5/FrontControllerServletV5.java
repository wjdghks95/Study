package hello.mvc.servlet.web.frontcontroller.v5;

import hello.mvc.servlet.web.frontcontroller.ModelView;
import hello.mvc.servlet.web.frontcontroller.MyView;
import hello.mvc.servlet.web.frontcontroller.v3.MemberFormControllerV3;
import hello.mvc.servlet.web.frontcontroller.v3.MemberListControllerV3;
import hello.mvc.servlet.web.frontcontroller.v3.MemberSaveControllerV3;
import hello.mvc.servlet.web.frontcontroller.v4.MemberFormControllerV4;
import hello.mvc.servlet.web.frontcontroller.v4.MemberListControllerV4;
import hello.mvc.servlet.web.frontcontroller.v4.MemberSaveControllerV4;
import hello.mvc.servlet.web.frontcontroller.v5.adapter.ControllerV3HandlerAdapter;
import hello.mvc.servlet.web.frontcontroller.v5.adapter.ControllerV4HandlerAdapter;
import hello.mvc.servlet.web.frontcontroller.v5.adapter.MyHandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 유연한 컨트롤러
 * 어댑터 도입
 * 어댑터를 추가해서 프레임워크를 유연하고 확장성 있게 설계
 */
/**
 * urlPatterns: /front-controller/v5 를 포함한 하위 모든 요청을 받음
 * requestURI 를 조회해서 controllerMap 에서 찾아 handler 반환 (handler 가 null 인 경우 404 에러)
 * handlerAdapters 에서 handler 를 지원하는 adapter 반환
 * adapter 를 해당 controller 로 변환하여 로직을 수행하고 ModelView 반환
 * ModelView 에서 viewName 을 꺼내 viewResolver 를 통해서 MyView(실제 View 주소) 반환
 * myView.render -> dispatcher.forward: 다른 서블릿이나 JSP로 이동하는 기능, 서버 내부에서 다시 호출이 발생
 * myView.render 에 model 을 추가로 넘겨 request.setAttribute 로 매핑
 */
@WebServlet(name = "frontControllerServletV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerServletV5 extends HttpServlet {

    private final Map<String, Object> handlerMappingMap = new HashMap<>();
    private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

    public FrontControllerServletV5() {
        initHandlerMappingMap(); // 핸들러 매핑 초기화
        initHandlerAdapters(); // 어댑터 초기화
    }

    private void initHandlerMappingMap() {
        handlerMappingMap.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members", new MemberListControllerV3());

        //V4 추가
        handlerMappingMap.put("/front-controller/v5/v4/members/new-form", new MemberFormControllerV4());
        handlerMappingMap.put("/front-controller/v5/v4/members/save", new MemberSaveControllerV4());
        handlerMappingMap.put("/front-controller/v5/v4/members", new MemberListControllerV4());
    }

    private void initHandlerAdapters() {
        handlerAdapters.add(new ControllerV3HandlerAdapter());
        handlerAdapters.add(new ControllerV4HandlerAdapter()); //V4 추가
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object handler = getHandler(request);
        if (handler == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyHandlerAdapter adapter = getHandlerAdapter(handler);
        ModelView mv = adapter.handle(request, response, handler);
        MyView view = viewResolver(mv.getViewName());
        view.render(mv.getModel(), request, response);
    }

    private Object getHandler(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        return handlerMappingMap.get(requestURI);
    }

    private MyHandlerAdapter getHandlerAdapter(Object handler) {
        for (MyHandlerAdapter adapter : handlerAdapters) {
            if (adapter.supports(handler)) {
                return adapter;
            }
        }
        throw new IllegalArgumentException("handler adapter를 찾을 수 없습니다. handler=" + handler);
    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }
}
