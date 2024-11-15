package BookSwap.security;

import BookSwap.model.entity.User;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class LoginController {

    @RequestMapping("/user")
    @CrossOrigin(origins = "http://localhost:5173")
    public Principal user(Principal user){
        return user;
    }

    @GetMapping("/profile")
    @CrossOrigin(origins = "http://localhost:5173")
    public User profile(OAuth2AuthenticationToken token, User user) {
        user.setId(token.getPrincipal().getAttribute("sub"));
        user.setUsername(token.getPrincipal().getAttribute("name"));
        user.setEmail(token.getPrincipal().getAttribute("email"));
        user.setPicture(token.getPrincipal().getAttribute("picture"));

        return user;
    }

}
