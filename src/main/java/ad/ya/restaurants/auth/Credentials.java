package ad.ya.restaurants.auth;


public record Credentials(String email, String password) {
}

/*
public class Credentials {
    private final String email;
    private final String password;

    public Credentials(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String email() {return email;}
    public String password() {return password;}
}*/
