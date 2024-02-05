package reviewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/NeedtoReview")
public class NeedtoReviewController {
	@GetMapping
    public String NeedtoReview(){
        return "NeedtoReview";
    }

	
}
