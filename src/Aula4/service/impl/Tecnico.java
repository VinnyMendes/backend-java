package Aula4.service.impl;


import Aula4.model.Mail;
import Aula4.service.CheckEmail;

public class Tecnico extends CheckEmail {

    @Override
    public void processarEmail(Mail mail, String nomeDestinatario) {
        String[] arrayMail = mail.getDestino().split("@");

        if (nomeDestinatario.equals("tecnico") && arrayMail[1].equals("colmeia.com")){
            System.out.println("------------------------------------------------------------");
            System.out.println("Email recebido pelo Técnico. Obrigado por entrar em contato!");
            System.out.println("------------------------------------------------------------");

        }else{
            System.out.println("-----------------------");
            System.out.println("Esse Email é um SPAM!!!");
            System.out.println("-----------------------");
        }
    }
}