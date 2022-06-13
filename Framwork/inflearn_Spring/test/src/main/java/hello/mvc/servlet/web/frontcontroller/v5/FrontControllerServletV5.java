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

@WebServlet(name = "frontControllerServletV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerServletV5 extends HttpServlet {

    private final Map<String, Object> handlerMappingMap = new HashMap<>();
    private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

    public FrontControllerServletV5() {
        initHandlerMappingMap();
        initHandlerAdapters();
    }

    private void initHandlerMappingMap() {
        handlerMappingMap.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members", new MemberListControllerV3());

        handlerMappingMap.put("/front-controller/v5/v4/members/new-form", new MemberFormControllerV4());
        handlerMappingMap.put("/front-controller/v5/v4/members/save", new MemberSaveControllerV4());
        handlerMappingMap.put("/front-controller/v5/v4/members", new MemberListControllerV4());
    }
    private void initHandlerAdapters() {
        handlerAdapters.add(new ControllerV3HandlerAdapter());
        handlerAdapters.add(new ControllerV4HandlerAdapter());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 핸들러 조회
        Object handler = getHandler(request);
        if (handler == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // 핸들러 어댑터 조회
        MyHandlerAdapter adapter = getHandlerAdapter(handler);
        // 핸들러 어댑터 실행 -> 핸들러(컨트롤러) 실행 -> 모델뷰 반환
        ModelView mv = adapter.handle(request, response, handler);
        // 뷰 리졸버 실행 -> 뷰의 논리 이름을 물리 이름으로 변환 -> 뷰 객체 반한
        MyView view = viewResolver(mv.getViewName());
        // 뷰 실행
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
        throw new IllegalArgumentException("handler adapter 를 찾을 수 없습니다. handler=" + handler);
    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }
}
