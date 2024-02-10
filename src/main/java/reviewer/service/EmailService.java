package reviewer.service;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

   // @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public  void sendResetEmail(String userEmail, String resetToken) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(userEmail);
        mailMessage.setSubject("Password Reset Link");
        mailMessage.setText("Click the link below to reset your password:\n"
                + "http://localhost:8080/resetpassword?token=" + resetToken);


        javaMailSender.send(mailMessage);
    }
}
