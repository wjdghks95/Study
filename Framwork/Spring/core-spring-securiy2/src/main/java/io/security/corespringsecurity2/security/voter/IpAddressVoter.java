package io.security.corespringsecurity2.security.voter;

import io.security.corespringsecurity2.repository.AccessIpRepository;
import io.security.corespringsecurity2.service.SecurityResourceService;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import java.util.Collection;
import java.util.List;

/**
 * IpAddressVoter
 *  - IP 주소를 검사하는 Voter
 */
public class IpAddressVoter implements AccessDecisionVoter<Object> {

    private SecurityResourceService securityResourceService;

    public IpAddressVoter(SecurityResourceService securityResourceService) {

        this.securityResourceService = securityResourceService;
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    @Override
    public int vote(Authentication authentication, Object object, Collection<ConfigAttribute> attributes) {

        // 인증객체에서 getDetails()를 통해 얻은 Object를 WebAuthenticationDetails 타입으로 캐스팅해서 remoteAddress를 조회
        WebAuthenticationDetails details = (WebAuthenticationDetails) authentication.getDetails();
        String remoteAddress = details.getRemoteAddress();

        List<String> accessIpList = securityResourceService.getAccessIpList();

        int result = ACCESS_DENIED;

        // securityResourceService에서 허용가능한 IP 리스트를 가져와서 비교
        for (String ipAddress : accessIpList) {
            if (remoteAddress.equals(ipAddress)) {
                return ACCESS_ABSTAIN; // 비교결과 허용되는 값이 있을경우 보류(ACCESS_ABSTAIN) 를 반환
                // (ACCESS_GRANTED) 를 반환하면 즉시 심사 종료 후 인가가 허가됨
            }
        }

        if (result == ACCESS_DENIED) {
            throw new AccessDeniedException("Invalid IpAddress");
        }

        return result;
    }
}
