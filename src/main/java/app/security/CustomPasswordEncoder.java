package app.security;

import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (rawPassword == null) {
            throw new IllegalArgumentException("can't be null");
        } else if (encodedPassword != null && encodedPassword.length() != 0) {
            return rawPassword.toString().equals(encodedPassword);
        } else {
            return false;
        }
    }
}
