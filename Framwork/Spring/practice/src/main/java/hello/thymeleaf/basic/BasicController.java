package hello.thymeleaf.basic;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/basic")
public class BasicController {

    /**
     * 텍스트
     * th:text="${data}"
     * [[${data}]]
     */
    @GetMapping("/text-basic")
    public String textBasic(Model model) {
        model.addAttribute("data", "hello spring!!");
        return "basic/text-basic";
    }

    /**
     * unescape 텍스트
     * th:utext="${data}"
     * [(${data})]
     */
    @GetMapping("/text-unescaped")
    public String textUnescaped(Model model) {
        model.addAttribute("data", "Hello <b>Spring!</b>");
        return "basic/text-unescaped";
    }

    /**
     * 변수
     * Object - th:text="${user.username}", th:text="${user['username']}", th:text="${user.getUsername()}"
     * List - th:text="${users[0].username}", th:text="${users[0]['username']}", th:text="${users[0].getUsername()}"
     * Map - th:text="${userMap['userA'].username}", th:text="${userMap['userA']['username']}", th:text="${userMap['userA'].getUsername()}"
     *
     * 지역 변수
     * th:with="first=${users[0]}" th:text="${first.username}"
     */
    @GetMapping("/variable")
    public String variable(Model model) {
        User userA = new User("userA", 10);
        User userB = new User("userB", 20);

        List<User> list = new ArrayList<>();
        list.add(userA);
        list.add(userB);

        Map<String, User> map = new HashMap<>();
        map.put("userA", userA);
        map.put("userB", userB);

        model.addAttribute("user", userA);
        model.addAttribute("users", list);
        model.addAttribute("userMap", map);
        return "basic/variable";
    }

    @Data
    static class User {

        private String username;
        private int age;

        public User(String username, int age) {
            this.username = username;
            this.age = age;
        }
    }

    /**
     * 기본 객체
     * ${#request}, ${#response}, ${#session}, ${#servletContext}, ${#locale}
     *
     * 편의 객체
     * HTTP 요청 파라미터 접근: param -> ${param.paramData}
     * HTTP 세션 접근: session -> ${session.sessionData}
     * 스프링 빈 접근: @ -> ${@helloBean.hello('Spring!')}
     */
    @GetMapping("/basic-objects")
    public String basicObjects(HttpSession session) {
        session.setAttribute("sessionData", "Hello Session");
        return "basic/basic-objects";
    }

    @Component("helloBean")
    static class HelloBean {
        public String hello(String data) {
            return "Hello " + data;
        }
    }

    /**
     * 날짜용 유틸리티 객체 #temporals
     * th:text="${#temporals.???(localDateTime)}">
     */
    @GetMapping("/date")
    public String date(Model model) {
        model.addAttribute("localDateTime", LocalDateTime.now());
        return "basic/date";
    }

    /**
     * URL 링크
     * 단순한 URL: @{/hello} -> /hello
     * 쿼리 파라미터: @{/hello(param1=${param1}, param2=${param2})} -> /hello?param1=data1&param2=data2
     * 경로 변수: @{/hello/{param1}/{param2}(param1=${param1}, param2=${param2})} -> /hello/data1/data2
     * 경로 변수 + 쿼리 파라미터: @{/hello/{param1}(param1=${param1}, param2=${param2})} -> /hello/data1?param2=data2
     */
    @GetMapping("/link")
    public String link(Model model) {
        model.addAttribute("param1", "data1");
        model.addAttribute("param2", "data2");
        return "basic/link";
    }

    /**
     * 리터럴
     * 문자: 'hello' 작은 따옴표 생략 가능, 공백이 있는 경우 생략 X
     * 숫자: 10
     * 불린: true , false
     * null: null
     */
    @GetMapping("/literal")
    public String literal(Model model) {
        model.addAttribute("data", "Spring!");
        return "basic/literal";
    }

    /**
     * 연산
     * 산술: +, -, *, /, %
     * 비교: > (gt), < (lt), >= (ge), <= (le), ! (not), == (eq), != (neq, ne)
     * 조건식: 조건식 ? true : false
     * Elvis 연산자: 조건식(true) ?: false
     * No-Operation: 조건식(true) ?: _(false) false 인 경우 타임리프 동작 X
     */
    @GetMapping("/operation")
    public String operation(Model model) {
        model.addAttribute("nullData", null);
        model.addAttribute("data", "Spring!");
        return "basic/operation";
    }

    /**
     * 속성 설정 th:*
     *
     * 속성 추가
     *  - th:attrappend: 속성 값의 뒤에 값을 추가
     *  - th:attrprepend: 속성 값의 앞에 값을 추가
     *  - th:classappend: class 속성에 자연스럽게 추가
     *
     * checked 처리 true, false
     */
    @GetMapping("/attribute")
    public String attribute() {
        return "basic/attribute";
    }

    /**
     * 반복
     * th:each="user : ${users}"
     * th:text="${user.username}"
     *
     * 반복 상태 유지
     * user + Stat = userStat 이므로 생략 가능
     *
     * 반복 상태 유지 기능
     *  - index: 0부터 시작하는 값
     *  - count: 1부터 시작하는 값
     *  - size: 전체 사이즈
     *  - even, odd: 홀수, 짝수 여부( boolean )
     *  - first, last:처음, 마지막 여부( boolean )
     *  - current: 현재 객체
     */
    @GetMapping("/each")
    public String each(Model model) {
        addUsers(model);
        return "basic/each";
    }

    /**
     * 조건부 평가
     * if, unless: false 인 경우 랜더링 X
     * switch case: case="*" 디폴트
     */
    @GetMapping("/condition")
    public String condition(Model model) {
        addUsers(model);
        return "basic/condition";
    }

    /**
     * 주석
     * 표준 HTML 주석: 타임리프가 렌더링 하지 않고, 그대로 남김
     * 타임리프 파서 주석: 렌더링에서 주석부분을 제거
     * 타임리프 프로토타입 주석: HTML 파일을 열면 주석처리, 타임리프를 렌더링 한 경우 보이는 기능
     */
    @GetMapping("/comments")
    public String comments(Model model) {
        model.addAttribute("data", "Spring!");
        return "basic/comments";
    }

    /**
     * 블록
     * <th:block> 은 HTML 태그가 아닌 타임리프의 유일한 자체 태그
     */
    @GetMapping("/block")
    public String block(Model model) {
        addUsers(model);
        return "basic/block";
    }

    /**
     * 자바스크립트 인라인
     * 텍스트 렌더링
     * 자바스크립트 내추럴 템플릿: 주석 활용
     * 객체: 객체를 JSON으로 자동으로 변환
     */
    @GetMapping("/javascript")
    public String javascript(Model model) {
        model.addAttribute("user", new User("userA", 10));
        addUsers(model);
        return "basic/javascript";
    }

    private void addUsers(Model model) {
        List<User> list = new ArrayList<>();
        list.add(new User("userA", 10));
        list.add(new User("userB", 20));
        list.add(new User("userC", 30));

        model.addAttribute("users", list);
    }
}
