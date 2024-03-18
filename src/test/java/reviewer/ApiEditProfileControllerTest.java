package reviewer;

//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//import java.security.Principal;
//import java.util.ArrayList;
//import java.util.Optional;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import reviewer.controller.EditProfileController;
//import reviewer.model.User;
//import reviewer.repository.PaperRepository;
//import reviewer.repository.ReviewRepository;
//import reviewer.repository.UserRepository;
//import reviewer.rest.ApiEditProfileController;
//
//@ExtendWith(MockitoExtension.class)
//class ApiEditProfileControllerTest {
//
//    @Mock
//    private UserRepository userRepository;
//
//    @Mock
//    private PaperRepository paperRepository;
//
//    @Mock
//    private ReviewRepository reviewRepository;
//
//    @Mock
//    private PasswordEncoder passwordEncoder;
//
//    @InjectMocks
//    private EditProfileController editProfileController;
//    @InjectMocks
//    public ApiEditProfileController ApieditProfileController;
//    
//    User user1= new User("rohithmuthavarapu@gmail.com","BHU","A","07887788888","$2a$10$55lhjeH1bsz6ykzIPwROQOy/yVOMiZN2k1q56Hsk9p2sCi5/fSgFi",9L,",DBMS,SPRING,JAVA,HTML,CSS,JS");
//    		
//  public  Principal principal ;
//    public void beforeeach(User user) {
//    	principal=()-> user.getEmailId();
//    }
//
//    @Test
//    void testEditProfile() throws Exception {
////    	  beforeeach(user1);
//    	  Optional<User> mockResult=Optional.empty();
//    	  System.out.println(user1);
//    	  System.out.println(userRepository.findByEmailId(user1.getEmailId()));
//          Mockito.when(userRepository.findById(user1.getEmailId())).thenReturn(mockResult);
//          System.out.println(mockResult);
//    	  //user3 = ApiEditProfileController.EditProfile(principal);
//    	  
//    	  
////        String username = "rohith@gmail.com";
////        User user = new User();
////        user.setEmailId(username);
////
////        when(userRepository.findByEmailId(username)).thenReturn(user);
////
////        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(editProfileController).build();
////
////        mockMvc.perform(get("/editProfile").principal(() -> username))
////                .andExpect(status().isOk())
////                .andExpect(model().attributeExists("user"))
////                .andExpect(model().attribute("user", user));
//    }
//    
//  
//
//    @Test
//    void testEditProfilePost() throws Exception {
//        User user = new User();
//        user.setEmailId("test@example.com");
//        user.setPassword("oldPassword");
//        when(userRepository.findByEmailId("test@example.com")).thenReturn(user);
//        when(passwordEncoder.matches("oldPassword", "oldPassword")).thenReturn(true);
//
//        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(editProfileController).build();
//
//        mockMvc.perform(post("/editProfile")
//                .param("password", "oldPassword")
//                .param("newPassword", "newPassword")
//                .param("reEnterPassword", "newPassword")
//                .principal(() -> "test@example.com"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("dashboard"));
//
//        verify(userRepository).save(user);
//    }
//
//    @Test
//    void testEditProfilePostInvalidPasswords() throws Exception {
//        User user = new User();
//        user.setEmailId("test@example.com");
//        user.setPassword("oldPassword");
//
//        when(userRepository.findByEmailId("test@example.com")).thenReturn(user);
//        when(passwordEncoder.matches("oldPassword", "oldPassword")).thenReturn(true);
//
//        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(editProfileController).build();
//
////        mockMvc.perform(post("/editProfile")
////                .param("password", "oldPassword")
////                .param("newPassword", "newPassword1")
////                .param("reEnterPassword", "newPassword2")
////                .principal(() -> "test@example.com"))
////                .andExpect(status().isBadRequest())
////                .andExpect(result -> assertTrue(result.getResolvedException() instanceof ResponseStatusException))
////                .andExpect(result -> assertEquals("newpasswords didnt matched", result.getResolvedException().getMessage()));
////
////        verify(userRepository, never()).save(user);
//    }
//}

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.security.Principal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
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
        Principal principal = () -> "rohith@gmail.com";
        User user = new User();
       
        user.setEmailId("rohith@gmail.com");
        
  
        when(userRepository.findByEmailId("rohith@gmail.com")).thenReturn(user);

        // Act
        User result = controller.EditProfile(principal);

        // TrueCase
        assertThat(result).isEqualTo(user);
        
    }
    
    
//    @Test
//    public void testEditProfileFalse() {
//        // Arrange
//        Principal principal = () -> "rohith@gmail.com";
//        User user = new User();
//       
//        user.setEmailId("rohith1@gmail.com");
//        
//  
//        when(userRepository.findByEmailId("rohith@gmail.com")).thenReturn(user);
//
//        // Act
//        User result = controller.EditProfile(principal);
//
//        // TrueCase
//        assertThat(result).isEqualTo(user);
//        
//    }

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

        Principal principal = () -> "rohith@gmail.com";

        when(userRepository.findByEmailId("rohith@gmail.com")).thenReturn(existingUser);
        when(passwordEncoder.matches("oldPass", "oldPass")).thenReturn(true);

        // Act
        User result = controller.Edit(util, principal);

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

        Principal principal = () -> "rohith@gmail.com";

         // checking wheather user is present or not
        when(userRepository.findByEmailId("rohith@gmail.com")).thenReturn(existingUser);
        // checking oldpassword and password stored in database
        when(passwordEncoder.matches("oldPass1", "oldPass")).thenReturn(false);

        ResponseStatusException exception = org.junit.jupiter.api.Assertions.assertThrows(ResponseStatusException.class,
                () -> controller.Edit(util, principal));
       // assertThat(exception.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void testEditWithMismatchedPasswords() {
        // Arrange
        EditProfileUtil util = new EditProfileUtil();
        util.setEmailId("rohith@gmail.com");
        util.setOldPassword("oldPass");
        util.setNewPassword("newPass");
        util.setReEnterPassword("newpass");
        // checking condition that newpassword and reententred password equal or not

        User existingUser = new User();
        existingUser.setEmailId("rohith@gmail.com");
        existingUser.setPassword("oldPass");

        Principal principal = () -> "rohith@gmail.com";

        when(userRepository.findByEmailId("rohith@gmail.com")).thenReturn(existingUser);
        when(passwordEncoder.matches("oldPass", "oldPass")).thenReturn(true);

        // Act & Assert
        ResponseStatusException exception = org.junit.jupiter.api.Assertions.assertThrows(ResponseStatusException.class,
                () -> controller.Edit(util, principal));
        //assertThat(exception.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
}

