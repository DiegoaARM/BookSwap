package BookSwap.security;

import BookSwap.model.entity.User;
import BookSwap.service.IUser;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.io.IOException;
import java.util.Arrays;

@Configuration
@EnableWebSecurity

public class SecurityConfig {

    @Autowired
    private IUser userService; // Inyectamos el servicio de usuario


    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:5173"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .authorizeHttpRequests(registry ->{
                    registry.requestMatchers("/api/**").permitAll();
                    registry.anyRequest().authenticated();
                })
                .oauth2Login(oauth2login -> {
                    oauth2login
                            .loginPage("http://localhost:5173/")
                            .successHandler(new AuthenticationSuccessHandler() {
                        @Override
                        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                            // Este bloque se ejecuta cuando el login es exitoso
                            OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;

                            String userId = token.getPrincipal().getAttribute("sub");
                            String username = token.getPrincipal().getAttribute("name");
                            String email = token.getPrincipal().getAttribute("email");
                            String picture = token.getPrincipal().getAttribute("picture");

                            // Verificar si el usuario ya existe
                            User existingUser = userService.findById(userId);
                            if (existingUser == null) {
                                // Si no existe, crear un nuevo usuario
                                User newUser = new User();
                                newUser.setId(userId);
                                newUser.setUsername(username);
                                newUser.setEmail(email);
                                newUser.setPicture(picture);
                                userService.save(newUser); // Guardar el nuevo usuario
                            } else {
                                // Si ya existe, actualizar la información si es necesario
                                existingUser.setUsername(username);
                                existingUser.setEmail(email);
                                existingUser.setPicture(picture);
                                userService.save(existingUser); // Actualizar el usuario
                            }
                            response.sendRedirect("http://localhost:5173/homeLogged");
                        }

                    });
                })
                .build();
    }


}
