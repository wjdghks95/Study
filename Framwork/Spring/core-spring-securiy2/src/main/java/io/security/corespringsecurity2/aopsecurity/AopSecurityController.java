package io.security.corespringsecurity2.aopsecurity;

import io.security.corespringsecurity2.domain.dto.AccountDto;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

/**
 * 어노테이션 권한 설정
 *  - @PreAuthorize("hasRole('USER')")
 *  - @PostAuthorize("hasRole('USER')")
 *  - @Secured("ROLE_USER")
 */
@Controller
public class AopSecurityController {

    @GetMapping("/preAuthorize")
    @PreAuthorize("hasRole('ROLE_USER') and #account.username == principal.username")
    public String preAuthorize(AccountDto account, Model model, Principal principal) {
        model.addAttribute("method", "Success @PreAuthorize");

        return "aop/method";
    }
}
