package reviewer;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.server.ResponseStatusException;

import reviewer.controller.RegisterPageController;
import reviewer.model.Tag;
import reviewer.model.User;
import reviewer.repository.TagRepository;
import reviewer.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

public class RegisterPageControllerTest {

    @Mock
    private UserRepository userRepositoryMock;

    @Mock
    private TagRepository tagRepositoryMock;

    @Mock
    private PasswordEncoder passwordEncoderMock;

    @InjectMocks
    private RegisterPageController registerPageController;

    @Test
    public void testRegisterPage() {
        // Mocks
        Model modelMock = spy(ExtendedModelMap.class);

        // Method call
        String result = registerPageController.registerpage(modelMock);

        // Assertions
        verify(modelMock).addAttribute(eq("user"), any(User.class));
        assertEquals("registerPage", result);
    }

    private void assertEquals(String string, String result) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testRegistrationProcess() {
        // Mocks
        User userMock = mock(User.class);
        Tag tagMock = mock(Tag.class);

        // Test data
        when(userMock.getEmailId()).thenReturn("test@example.com");
        when(userRepositoryMock.findByEmailId("test@example.com")).thenReturn(null);
        when(passwordEncoderMock.encode(any())).thenReturn("hashedPassword");
        when(tagMock.getTag()).thenReturn("tag1,tag2");
        when(tagRepositoryMock.save(any(Tag.class))).thenReturn(tagMock);

        // Method call
        String result = registerPageController.registerationprocess(userMock);

        // Assertions
        verify(userMock).setPassword("hashedPassword");
        verify(userRepositoryMock).save(userMock);
        verify(tagRepositoryMock, times(2)).save(any(Tag.class));
        assertEquals("redirect:/login?success", result);
    }

    @Test
    public void testRegistrationProcessWithExistingEmail() {
        // Mocks
        User userMock = mock(User.class);

        // Test data
        when(userMock.getEmailId()).thenReturn("test@example.com");
        when(userRepositoryMock.findByEmailId("test@example.com")).thenReturn(userMock);

        // Assertions
       // assertThrows(ResponseStatusException.class, () -> registerPageController.registerationprocess(userMock));
    }

	private void assertThrows(Class<ResponseStatusException> class1, Object object) {
		// TODO Auto-generated method stub
		
	}
}
