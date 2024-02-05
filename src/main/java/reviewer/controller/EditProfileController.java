package reviewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller class for handling requests related to editing user profiles.
 */
@Controller
@RequestMapping("/editProfile")
public class EditProfileController {
	/**
     * Handles HTTP GET requests for the edit profile page.
     * Prints "temp" to the console for temporary debugging.
     *
     * @return The view name "editProfile".
     */
	@GetMapping
    public String EditProfile(){
		System.out.println("temp");
        return "editProfile";
    }
	/**
     * Handles HTTP POST requests for submitting edited profile data.
     * Prints "hello" to the console for temporary debugging.
     *
     * @return Redirects to the "/dashboard" page after successful profile edit.
     */
	@PostMapping
	public String Edit() {
		System.out.println("hello");
		return "redirect:/dashboard";
	}
}