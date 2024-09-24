package exchageLibrary.Auth;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private GoogleAuthService googleAuthService;

    @PostMapping("/google")
    public ResponseEntity<?> googleLogin(@RequestBody String idTokenString) {
        try {
            // Verifica el token enviado desde el frontend
            GoogleIdToken.Payload payload = googleAuthService.verifyToken(idTokenString);

            // Extraer datos útiles del payload (e.g. email, nombre, foto)
            String userId = payload.getSubject();
            String email = payload.getEmail();
            String name = (String) payload.get("name");
            String pictureUrl = (String) payload.get("picture");

            // Aquí puedes crear/actualizar al usuario en tu base de datos si es necesario
            // y devolver un JWT u otra respuesta
            return ResponseEntity.ok("Usuario verificado: " + name + " (" + email + ")");
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Error al verificar el ID token.");
        }
    }
}
