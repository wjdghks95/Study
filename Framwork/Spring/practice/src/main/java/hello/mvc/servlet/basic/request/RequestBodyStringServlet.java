package hello.mvc.servlet.basic.request;

import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * http://localhost:8080/request-body-string
 * string 형식 전송
 * content-type: text/plain
 * message body: hello
 */
@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletInputStream inputStream = request.getInputStream(); // byte 코드 반환
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8); // 문자형식으로 변환

        System.out.println("messageBody = " + messageBody);

        response.getWriter().write("ok");
    }
}
