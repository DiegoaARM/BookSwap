package exchageLibrary.Auth;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import exchageLibrary.model.entity.User;
import exchageLibrary.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private GoogleAuthService googleAuthService;

    @Autowired
    private JwtUtil jwtUtil; // Inyecta el JwtUtil

    @Autowired
    private IUser userService;

    @PostMapping("/google")
    public ResponseEntity<?> googleLogin(@RequestBody String idTokenString) {
        try {
            // Verifica el token enviado desde el frontend
            GoogleIdToken.Payload payload = googleAuthService.verifyToken(idTokenString);

            // Extraer datos útiles del payload
            String email = payload.getEmail();
            String name = (String) payload.get("name");
            String pictureUrl = (String) payload.get("picture");

            // Buscar si el usuario ya existe en la base de datos
            User user = userService.findByEmail(email);

            if (user == null) {
                // Si el usuario no existe, crearlo
                user = new User();
                user.setEmail(email);
                user.setUsername(name);
                user.setPicture(pictureUrl);
                user.setCreated_at(new Date());
                userService.save(user);
            }

            // Generar un JWT para el usuario
            String jwtToken = jwtUtil.generateJwtToken(user);

            return ResponseEntity.ok(new AuthResponse(user.getUsername(), jwtToken));
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Error al verificar el ID token.");
        }
    }
}
