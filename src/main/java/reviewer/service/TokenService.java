package reviewer.service;

import reviewer.model.User;

public interface TokenService {
    String generateToken();
    void saveToken(User user, String token);
    boolean isValidToken(User user, String token);
    void invalidateToken(User user, String token);
	User getUserByToken(String token);
}
