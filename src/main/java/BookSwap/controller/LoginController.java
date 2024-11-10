package BookSwap.controller;

import BookSwap.model.entity.User;
//import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping(path = "/")
public class LoginController {

    @RequestMapping("/")
    public String home() {
        return "welcome";
    }

    @RequestMapping("/user")
    public Principal user(Principal user){
        return user;
    }

    //@GetMapping("/profile")
    //public User profile(OAuth2AuthenticationToken token, User user) {
    //    user.setId(token.getPrincipal().getAttribute("sub"));
    //    user.setUsername(token.getPrincipal().getAttribute("name"));
    //    user.setEmail(token.getPrincipal().getAttribute("email"));
    //    user.setPicture(token.getPrincipal().getAttribute("picture"));

    //    return user;
    //}
}
