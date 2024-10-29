package BookSwap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/api/oauth")
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login"; // Devuelve una página de login
    }

    @GetMapping("/home")
    public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
        model.addAttribute("name", principal.getAttribute("name"));
        return "home"; // Página de bienvenida después del login
    }
}
