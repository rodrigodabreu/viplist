package br.com.alura.vipList.service;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class EmailService {


    public static final String HOST_NAME = "smtp.gmail.com";
    public static final int PORT_NUMBER = 465;
    public static final String USER_NAME = "rodrigodiasdeabreu";
    public static final String PASSWORD = "Cmp@2139";
    public static final String EMAIL = "rodrigodiasdeabreu@gmail.com";
    public static final String SUBJECT = "Você foi convidado pelo ListaVIP";

    public void enviar(String nome, String emailDestinatario) {

        try {
            Email email = new SimpleEmail();
            email.setHostName(HOST_NAME);
            email.setSmtpPort(PORT_NUMBER);
            email.setAuthenticator(new DefaultAuthenticator(USER_NAME, PASSWORD));
            email.setSSLOnConnect(true);
            email.setFrom(EMAIL);
            email.setSubject(SUBJECT);
            email.setMsg("Olá " + nome + " , parabéns!!! Você acaba de ser convidado pelo ListaVIP.");
            email.addTo(emailDestinatario);
            email.send();

        } catch (EmailException e) {
            e.printStackTrace();
        }

    }


}
