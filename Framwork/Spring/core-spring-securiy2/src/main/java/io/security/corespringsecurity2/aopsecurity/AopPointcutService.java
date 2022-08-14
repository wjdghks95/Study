package io.security.corespringsecurity2.aopsecurity;

import org.springframework.stereotype.Service;

@Service
public class AopPointcutService {

    public void pointcutSecured() {
        System.out.println("pointcutSecured");
    }

    public void notSecured() {
        System.out.println("notSecured");
    }
}
