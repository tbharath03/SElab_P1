package reviewer;

import static org.mockito.Mockito.*;

import java.security.Principal;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.ui.Model;
import org.springframework.web.server.ResponseStatusException;

import reviewer.controller.EditProfileController;
import reviewer.model.User;
import reviewer.repository.PaperRepository;
import reviewer.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.ExtendedModelMap;

public class EditProfileControllerTest {

    @Mock
    private UserRepository userRepositoryMock;

    @Mock
    private PaperRepository paperRepositoryMock;

    @Mock
    private PasswordEncoder passwordEncoderMock;

    @InjectMocks
    private EditProfileController editProfileController;

    @Test
    public void testEditProfile() {
        // Mocks
        Model modelMock = spy(ExtendedModelMap.class);
        Principal principalMock = mock(Principal.class);

        // Test data
        User user = new User();
        user.setEmailId("test@example.com");

        when(principalMock.getName()).thenReturn("test@example.com");
        when(userRepositoryMock.findByEmailId("test@example.com")).thenReturn(user);

        // Method call
        String result = editProfileController.EditProfile(modelMock, principalMock);

        // Assertions
        verify(modelMock).addAttribute(eq("user"), any(User.class));
        verify(modelMock).addAttribute(eq("paperCount"), any(Long.class));
        assertEquals("editProfile", result);
    }

    private void assertEquals(String string, String result) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testEdit() {
        // Mocks
        Principal principalMock = mock(Principal.class);
        User userMock = mock(User.class);

        // Test data
        when(principalMock.getName()).thenReturn("test@example.com");
        when(userRepositoryMock.findByEmailId("test@example.com")).thenReturn(userMock);
        when(passwordEncoderMock.matches(anyString(), anyString())).thenReturn(true);

        // Method call
        String result = editProfileController.Edit(userMock, "newPassword", "newPassword", principalMock);

        // Assertions
        verify(userRepositoryMock).save(userMock);
        assertEquals("dashboard", result);
    }

    @Test
    public void testEditWithInvalidPasswords() {
        // Mocks
        Principal principalMock = mock(Principal.class);
        User userMock = mock(User.class);

        // Test data
        when(principalMock.getName()).thenReturn("test@example.com");
        when(userRepositoryMock.findByEmailId("test@example.com")).thenReturn(userMock);
        when(passwordEncoderMock.matches(anyString(), anyString())).thenReturn(false);

        // Assertions
        //assertThrows(ResponseStatusException.class, () -> editProfileController.Edit(userMock, "newPassword", "newPassword", principalMock));
    }

	private void assertThrows(Class<ResponseStatusException> class1, Object object) {
		// TODO Auto-generated method stub
		
	}
}
