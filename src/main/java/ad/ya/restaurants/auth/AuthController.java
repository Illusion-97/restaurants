package ad.ya.restaurants.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping("login")
    public AuthResponse login(@RequestBody Credentials credentials) {
        return service.login(credentials);
    }


    @PostMapping("register")
    public void register(@RequestBody RegisterDto user) {
        service.register(user);
    }
}
