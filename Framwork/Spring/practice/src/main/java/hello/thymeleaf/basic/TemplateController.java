package hello.thymeleaf.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/template")
public class TemplateController {

    /**
     * 템플릿 조각
     * th:fragment="copy"
     * th:fragment="copyParam (param1, param2)"
     *
     * 부분 포함 insert: th:insert="~{template/fragment/footer :: copy}"
     * 부분 포함 replace: th:replace="~{template/fragment/footer :: copy}"
     * 부분 포함 단순 표현식: th:replace="template/fragment/footer :: copy"
     * 파라미터 사용: th:replace="~{template/fragment/footer :: copyParam ('데이터1', '데이터2')}"
     */
    @GetMapping("/fragment")
    public String template() {
        return "template/fragment/fragmentMain";
    }

    /**
     * 템플릿 레이아웃
     * <head th:replace="template/layout/base :: common_header(~{::title},~{::link})"> title, link 를 전달하고 템플릿 조각 사용
     * <head th:fragment="common_header(title,links)"> title, link 대체
     *      <title th:replace="${title}">
     *      <th:block th:replace="${links}"/>
     */
    @GetMapping("/layout")
    public String layout() {
        return "template/layout/layoutMain";
    }

    /**
     * 템플릿 레이아웃
     * <html th:replace="~{template/layoutExtend/layoutFile :: layout(~{::title}, ~{::section})}" title, section 을 전달하고 템플릿 조각 사용
     * <html th:fragment="layout (title, content)"> title, section 대체
     *      <title th:replace="${title}">
     *      <div th:replace="${content}"></div>
     */
    @GetMapping("/layoutExtend")
    public String layoutExtends() {
        return "template/layoutExtend/layoutExtendMain";
    }
}
