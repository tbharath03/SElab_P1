package reviewer.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import reviewer.model.User;

/**
 * Controller class for handling user login.
 *
 * This controller manages user login functionality, including password hashing for security.
 * The password provided during login will be hashed, and the hash value will be verified against
 * the stored hash in the database for authentication.
 *
 * @author Attanti
 * @version 1.0
 * @since 2024-02-05
 */
@Controller
@RequestMapping("/loginPage")
public class LoginController {

	/**
     * Handles HTTP GET requests for the "/loginPage" path.
     *
     * This method prepares a new User object and adds it to the model.
     * The User object is then used to capture user credentials during the login process.
     *
     * @param model The model to add attributes to the model
     * @return The logical view name "loginPage"
     *
     *
     *
     * See Also:
     *   - {@link User} For information about the User model.
     *   - /loginPage The login page endpoint.
     *    
     * @author Attanti
     * @version 1.0
     * @since 2024-02-05
     */
	@GetMapping
	public String login(Model model) 
	{
		User user = new User();
		model.addAttribute("user",user);
		return "loginPage";
	}
	
}
