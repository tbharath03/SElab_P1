package reviewer.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ErorrController implements ErrorController {
	@RequestMapping("/error")
	public String handleError(HttpServletRequest request) {
	    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
	    Object message = request.getAttribute(RequestDispatcher.ERROR_MESSAGE);
	    if (status != null) {
	        Integer statusCode = Integer.valueOf(status.toString());
	        String messageCode = message.toString();
	    
	        if(statusCode == HttpStatus.BAD_REQUEST.value()) {
	        	if(messageCode.equals("newpasswords didnt matched")) {
	        		return "newPasswordsDidntMatch";
	        	}
	        	if(messageCode.equals("old password didnt matched")) {
	        		return "oldPasswordDidntMatch";
	        	}
	        	if(messageCode.equals("Email already exists!")) {
	        		return "emailAlreadyExists";
	        	}
	        }
	    }
	    return "error";
	}
}
