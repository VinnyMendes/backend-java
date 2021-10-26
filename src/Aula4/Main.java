package Aula4;


import Aula4.model.Mail;
import Aula4.service.CheckEmail;
import Aula4.service.impl.Comercial;
import Aula4.service.impl.Gerente;
import Aula4.service.impl.Tecnico;

public class Main {

    public static void main(String[] args) {
        Mail mail = new Mail("vinny@gmail.com","tecnico@colmeia.com","Spring Boot");

        String[] emailValidado = mail.getDestino().split("@");

        CheckEmail checkEmail;

        if(emailValidado[1].equals("colmeia.com")){
            checkEmail = new Gerente()
                    .setProximoDestinatario(new Comercial()
                            .setProximoDestinatario(new Tecnico()));
        }else{
            checkEmail = new Tecnico();
        }

        checkEmail.processarEmail(mail, emailValidado[0]);


        // CheckEmail checkEmail = new Gerente()
        //         .setProximoDestinatario(new Comercial()
        //                .setProximoDestinatario(new Tecnico()));

        // Mail mail2 = new Mail("vinny@gmail.com","comercial@colmeia.com","Spring Boot");
        // Mail[] arrayTeste = {mail, mail2};
        //for (Mail a: arrayTeste){
        //    checkEmail.processarEmail(a);
        //}
    }
}
