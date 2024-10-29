package BookSwap.auth;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import BookSwap.model.entity.User;
import BookSwap.service.IUser;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final IUser userService;

    public CustomOAuth2UserService(IUser userService) {
        this.userService = userService;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        String email = oAuth2User.getAttribute("email");
        User user = userService.findByEmail(email);

        if (user == null) {
            user = new User();
            user.setId(oAuth2User.getAttribute("sub"));
            user.setEmail(email);
            user.setUsername(oAuth2User.getAttribute("name"));
            user.setPicture(oAuth2User.getAttribute("picture"));
            userService.save(user);
        }

        return oAuth2User;
    }
}
