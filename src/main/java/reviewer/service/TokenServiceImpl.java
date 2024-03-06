package reviewer.service;

import org.springframework.stereotype.Service;

import reviewer.model.Token;
import reviewer.model.User;
import reviewer.repository.TokenRepository;
import reviewer.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class TokenServiceImpl implements TokenService {

	 private UserRepository userRepository;
    private TokenRepository tokenRepository; // Inject TokenRepository
    private
    
 
    TokenServiceImpl(TokenRepository tokenRepository,UserRepository userRepository) 
    {
        this.tokenRepository = tokenRepository;
        this.userRepository=userRepository;
    }
    @Override
    public String generateToken() {
        return UUID.randomUUID().toString();
    }

    @Override
    public void saveToken(User user, String token) {
        // Save the token and its expiration time in the database
        LocalDateTime expirationTime = LocalDateTime.now().plusMinutes(30);
        Token token1 = new Token();
        token1.setToken(token);
        token1.setExpirationTime(expirationTime);
        token1.setUser(user);
        tokenRepository.save(token1);
    }

    @Override
    public boolean isValidToken(User user, String token) {
        Token token1 = tokenRepository.findByUserAndToken(user,token);
        return token1 != null && token1.getExpirationTime().isAfter(LocalDateTime.now());
    }

    @Override
    public void invalidateToken(User user, String token) {
      
        Token token1 = tokenRepository.findByUserAndToken(user,token);
        if (token1 != null) 
        {
            tokenRepository.delete(token1);
        }
    }
	@Override
	public User getUserByToken(String token) {
		  Token tokenEntity = tokenRepository.findByToken(token);

	        if (tokenEntity != null && !tokenEntity.isExpired(tokenEntity.getExpirationTime())) 
	        {
	            
	            return userRepository.findByEmailId(tokenEntity.getUser().getEmailId());
	        }

	        return null;
		
	}
}
