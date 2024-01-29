package reviewer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {

  @GetMapping("/registerpage.html")
  public String home() {
    return "home";
  }
}