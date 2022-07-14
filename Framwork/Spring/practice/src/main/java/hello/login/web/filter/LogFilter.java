package hello.login.web.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

/**
 * Filter 인터페이스 구현
 *  - init(): 필터 초기화 메서드, 서블릿 컨테이너가 생성될 때 호출
 *  - doFilter(): 고객의 요청이 올 때 마다 해당 메서드가 호출, 필터의 로직을 구현
 *      - chain.doFilter(request, response): 다음 필터가 있으면 필터를 호출하고, 필터가 없으면 서블릿을 호출
 *  - destroy(): 필터 종료 메서드, 서블릿 컨테이너가 종료될 때 호출
 */
@Slf4j
public class LogFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("log filter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request; // 다운 캐스팅
        String requestURI = httpRequest.getRequestURI();

        String uuid = UUID.randomUUID().toString();
        try {
            log.info("REQUEST [{}][{}]", uuid, requestURI);
            chain.doFilter(request, response);
        } catch (Exception e) {
            throw e;
        } finally {
            log.info("RESPONSE [{}][{}]", uuid, requestURI);
        }
    }

    @Override
    public void destroy() {
        log.info("log filter destroy");
    }
}
