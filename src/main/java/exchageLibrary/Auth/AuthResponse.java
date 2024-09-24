package exchageLibrary.Auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthResponse {
    private String username;
    private String token;

    public AuthResponse(String username, String token) {
        this.username = username;
        this.token = token;
    }


}
