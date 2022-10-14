package wjdghks95.project.rol.security.oauth;

public interface OAuth2UserInfo {
    String getProviderId();
    String getProvider();
    String getEmail();
    String getName();

    String getPicture();
}
