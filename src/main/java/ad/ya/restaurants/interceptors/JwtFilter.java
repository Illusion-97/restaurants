package ad.ya.restaurants.interceptors;

import ad.ya.restaurants.tools.JwtUtils;
import ad.ya.restaurants.users.User;
import ad.ya.restaurants.users.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final UserDetailsService service;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(authorization != null && authorization.startsWith("Bearer ")) {
            String token = authorization.substring(7);
            String email = JwtUtils.extractUsername(token);
            UserDetails user = service.loadUserByUsername(email);
            // Doit contenir : l'objet identifié (principal), le token ayant servi à l'identification, liste des accès de l'objet (rôles)
            Authentication auth = new UsernamePasswordAuthenticationToken(user,token, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        // Laisse SpringSecurity terminer la gestion de l'authentification
        filterChain.doFilter(request,response);
    }
}
