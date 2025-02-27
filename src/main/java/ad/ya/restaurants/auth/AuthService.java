package ad.ya.restaurants.auth;

import ad.ya.restaurants.users.Role;
import ad.ya.restaurants.users.User;
import ad.ya.restaurants.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager manager;
    private final AuthMapper mapper;
    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public AuthResponse login(Credentials credentials) {
        Authentication auth = manager.authenticate(new UsernamePasswordAuthenticationToken(credentials.email(),credentials.password(), List.of()));
        if (auth.isAuthenticated()) {
            User principal = (User) auth.getPrincipal();
            return mapper.toResponse(principal);
        }
        throw new SecurityException("Invalid Credentials");
    }

    public void register(RegisterDto user) {
        repository.save(
                mapper.toUser(
                        user.setPassword(encoder.encode(user.getPassword()))
                ).setRole(Role.PUBLIC)
        );
    }
}
