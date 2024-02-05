package reviewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/editProfile")
public class EditProfileController {
	@GetMapping
    public String EditProfile(){
		System.out.println("temp");
        return "editProfile";
    }
	@PostMapping
	public String Edit() {
		System.out.println("hello");
		return "redirect:/dashboard";
	}
}
