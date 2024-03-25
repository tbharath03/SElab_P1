package reviewer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.server.ResponseStatusException;

import reviewer.model.User;
import reviewer.repository.PaperRepository;
import reviewer.repository.ReviewRepository;
import reviewer.repository.UserRepository;
import reviewer.rest.ApiEditProfileController;
import reviewer.util.EditProfileUtil;

@ExtendWith(MockitoExtension.class)
public class ApiEditProfileControllerTest {

    @Mock
    private UserRepository userRepository;
    
    @Mock
    private PaperRepository paperRepository;
    
    @Mock
    private ReviewRepository reviewRepository;
    
    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private ApiEditProfileController controller;

    @Test
    public void testEditProfileTrue() {
        // Arrange
        User user = new User();
       
        user.setEmailId("rohith@gmail.com");
        
  
        when(userRepository.findByEmailId("rohith@gmail.com")).thenReturn(user);

        // Act
        User result = controller.EditProfile(user.getEmailId());

        // TrueCase
        assertThat(result).isEqualTo(user);
        
    }
    

    @Test
    public void testEdit() {
        // Arrange
        EditProfileUtil util = new EditProfileUtil();
        util.setEmailId("rohith@gmail.com");
        util.setFirstName("Rohith");
        util.setLastName("Sai");
        util.setNumber("1234567890");
        util.setPaperlimit(5L);
        util.setOldPassword("oldPass");
        util.setNewPassword("newPass");
        util.setReEnterPassword("newPass");

        User existingUser = new User();
        existingUser.setEmailId("rohith@gmail.com");
        existingUser.setPassword("oldPass");


        when(userRepository.findByEmailId("rohith@gmail.com")).thenReturn(existingUser);
        //when(userRepository.findById("rohith1@gmail.com")).thenReturn(Optional.of(existingUser));
        when(passwordEncoder.matches("oldPass", "oldPass")).thenReturn(true);

        // Act
        User result = controller.Edit(util, "rohith@gmail.com");

        // Assert
        assertThat(result.getEmailId()).isEqualTo("rohith@gmail.com");
        assertThat(result.getFirstName()).isEqualTo("Rohith");
        assertThat(result.getLastName()).isEqualTo("Sai");
        assertThat(result.getNumber()).isEqualTo("1234567890");
        assertThat(result.getPaperlimit()).isEqualTo(5);
        verify(userRepository).save(any(User.class));
    }
    
    
    @Test
    public void testEditEmailTrueCase1() {
        
        EditProfileUtil util1 = new EditProfileUtil();
        util1.setEmailId("rohith@gmail.com");
        util1.setFirstName("Rohith");
        util1.setLastName("Sai");
        util1.setNumber("1234567890");
        util1.setPaperlimit(5L);
        util1.setOldPassword("oldPass");
        util1.setNewPassword("newPass");
        util1.setReEnterPassword("newPass");

        User existingUser = new User();
        existingUser.setEmailId("rohith1@gmail.com");
        existingUser.setFirstName("Rohith");
        existingUser.setPassword("oldPass");

        when(userRepository.findByEmailId("rohith1@gmail.com")).thenReturn(existingUser);
        when(passwordEncoder.matches("oldPass", "oldPass")).thenReturn(true);

        // Act
        User result = controller.Edit(util1, "rohith1@gmail.com");
          System.out.println(result);
        // Assert
        assertThat(result.getEmailId()).isEqualTo("rohith@gmail.com");
        assertThat(result.getFirstName()).isEqualTo("Rohith");
        assertThat(result.getLastName()).isEqualTo("Sai");
        assertThat(result.getNumber()).isEqualTo("1234567890");
        assertThat(result.getPaperlimit()).isEqualTo(5);
        verify(userRepository).save(any(User.class));
    }
    

    @Test
    public void testEditWithInvalidPassword() {
        // Arrange
        EditProfileUtil util = new EditProfileUtil();
        util.setEmailId("rohith@gmail.com");
        util.setOldPassword("oldPass1");
        util.setNewPassword("newPass");
        util.setReEnterPassword("newPass");

        User existingUser = new User();
        existingUser.setEmailId("rohith@gmail.com");
        existingUser.setPassword("oldPass");

         // checking wheather user is present or not
        when(userRepository.findByEmailId("rohith@gmail.com")).thenReturn(existingUser);
         // checking oldpassword and password stored in database
        when(passwordEncoder.matches("oldPass1", "oldPass")).thenReturn(false);

        ResponseStatusException exception = org.junit.jupiter.api.Assertions.assertThrows(ResponseStatusException.class,
                () -> controller.Edit(util, "rohith@gmail.com"));
       // assertThat(exception.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void testEditWithInvalidPasswordcheck1() {
        // Arrange
        EditProfileUtil util = new EditProfileUtil();
        util.setEmailId("rohith@gmail.com");
        util.setOldPassword("oldPass1");
        util.setNewPassword("");
        util.setReEnterPassword("newPass");

        User existingUser = new User();
        existingUser.setEmailId("rohith@gmail.com");
        existingUser.setPassword("oldPass");

         // checking wheather user is present or not
        when(userRepository.findByEmailId("rohith@gmail.com")).thenReturn(existingUser);
         // checking oldpassword and password stored in database
        //when(passwordEncoder.matches("oldPass1", "oldPass")).thenReturn(false);

        ResponseStatusException exception = org.junit.jupiter.api.Assertions.assertThrows(ResponseStatusException.class,
                () -> controller.Edit(util, "rohith@gmail.com"));
       // assertThat(exception.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
   
    @Test
    public void testEditWithInvalidPasswordcheck() {
        // Arrange
        EditProfileUtil util = new EditProfileUtil();
        util.setEmailId("rohith@gmail.com");
        util.setOldPassword("oldPass1");
        util.setNewPassword("newPass");
        util.setReEnterPassword("");

        User existingUser = new User();
        existingUser.setEmailId("rohith@gmail.com");
        existingUser.setPassword("oldPass");

         // checking wheather user is present or not
        when(userRepository.findByEmailId("rohith@gmail.com")).thenReturn(existingUser);
         // checking oldpassword and password stored in database
        //when(passwordEncoder.matches("oldPass1", "oldPass")).thenReturn(false);

        ResponseStatusException exception = org.junit.jupiter.api.Assertions.assertThrows(ResponseStatusException.class,
                () -> controller.Edit(util, "rohith@gmail.com"));
       // assertThat(exception.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
   
 
    @Test
    public void testEditWithMismatchedPasswords() {
        // Arrange
        EditProfileUtil util = new EditProfileUtil();
        util.setEmailId("rohith@gmail.com");
        util.setOldPassword("oldPass");
        util.setNewPassword("newPass1");
        util.setReEnterPassword("newpass");
        // checking condition that newpassword and reententred password equal or not

        User existingUser = new User();
        existingUser.setEmailId("rohith@gmail.com");
        existingUser.setPassword("oldPass");

        when(userRepository.findByEmailId("rohith@gmail.com")).thenReturn(existingUser);
        when(passwordEncoder.matches("oldPass", "oldPass")).thenReturn(true);

        // Act & Assert
        ResponseStatusException exception = org.junit.jupiter.api.Assertions.assertThrows(ResponseStatusException.class,
                () -> controller.Edit(util, "rohith@gmail.com"));
        //assertThat(exception.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
}