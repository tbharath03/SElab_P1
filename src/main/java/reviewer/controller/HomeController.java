package reviewer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import reviewer.service.AppNameConfig;

/**
 * Controller class for handling home-related requests.
 */
@Controller
public class HomeController 
{
    @Autowired
    private AppNameConfig appNameConfig;
	/**
     * Handles HTTP GET requests for the home page.
     *
     * @return The view name "home".
     */
    @GetMapping("/")
    public String home(){
    	System.out.println(appNameConfig.getAppName());
        return "home";
    }
}