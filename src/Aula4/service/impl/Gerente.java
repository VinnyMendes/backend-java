package Aula4.service.impl;


import Aula4.model.Mail;
import Aula4.service.CheckEmail;

public class Gerente extends CheckEmail {


    @Override
    public void processarEmail(Mail mail, String nomeDestinatario) {

        if (nomeDestinatario.equals("gerente")){
            System.out.println("------------------------------------------------------------");
            System.out.println("Email recebido pelo Gerente. Obrigado por entrar em contato!");
            System.out.println("------------------------------------------------------------");
        }else{
            this.proximoDestinatario.processarEmail(mail, nomeDestinatario);
        }
    }
}
