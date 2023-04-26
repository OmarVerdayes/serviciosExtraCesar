package extra.demo.services;

import extra.demo.controllers.email.dtos.EmailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class EmailService {
    //Importante hacer la inyección de dependencia de JavaMailSender:
    @Autowired
    private JavaMailSender sender;

    public boolean sendMail(EmailDto email){
        try{
            MimeMessage message = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(email.getEmail());//correo al cual se enviará el mensaje
            helper.setSubject(email.getAsunto());//asunto del correo
            helper.setText(email.getCuerpo());//cuerpo del correo
            sender.send(message);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


}

