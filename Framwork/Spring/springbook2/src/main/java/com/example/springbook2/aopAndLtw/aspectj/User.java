package com.example.springbook2.aopAndLtw.aspectj;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable(autowire = Autowire.BY_NAME)
public class User {
    private UserPolicyDao userPolicyDao;
    private EmailService emailService;
    private String email = "";
    private String upgradeMessage = "";

    public void setUserPolicyDao(UserPolicyDao userPolicyDao) {
        this.userPolicyDao = userPolicyDao;
    }

    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void upgradeToNextLevel() {
        UserPolicy userPolicy = userPolicyDao.get(PolicyType.UPGRADE);
        emailService.sendEmail(this.email, upgradeMessage);
    }
}
