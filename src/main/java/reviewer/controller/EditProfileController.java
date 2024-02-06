package reviewer.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import reviewer.model.User;
import reviewer.repository.UserRepository;

@Controller
@RequestMapping("/editProfile")
public class EditProfileController {

    private UserRepository repo;

    /**
     * Constructor for EditProfileController.
     * 
     * @param repo The UserRepository for interacting with user data.
     */
    public EditProfileController(UserRepository repo) {
        this.repo = repo;
    }

    /**
     * Handles HTTP GET requests for the edit profile page.
     * Retrieves the user details using the principal's username and adds them to the model.
     * 
     * @param model     The Spring Model object to add attributes.
     * @param principal The Principal object representing the current logged-in user.
     * @return The view name "editProfile".
     */
    @GetMapping
    public String EditProfile(Model model, Principal principal) {
        String username = principal.getName(); // Get the username of the currently logged-in user
        User user = repo.findByEmailId(username); // Retrieve the user details from the repository using the username
        model.addAttribute("user", user); // Add the user details to the model
        return "editProfile"; // Return the view name for displaying the edit profile page
    }

    /**
     * Handles HTTP POST requests for submitting edited profile data.
     * Saves the updated user details to the repository.
     * 
     * @param user The User object populated with form data using @ModelAttribute.
     * @return Redirects to the "/dashboard" page after successful profile edit.
     */
    @PostMapping
    public String Edit(@ModelAttribute User user) {
        repo.save(user); // Save the updated user details to the repository
        return "redirect:/dashboard"; // Redirect the user to the dashboard page
    }
}