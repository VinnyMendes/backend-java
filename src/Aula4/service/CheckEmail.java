package Aula4.service;


import Aula4.model.Mail;

public abstract class CheckEmail {
    protected CheckEmail proximoDestinatario;

    public CheckEmail setProximoDestinatario(CheckEmail proximoDestinatario) {
        this.proximoDestinatario = proximoDestinatario;
        return this;
    }

    public abstract void processarEmail(Mail mail, String nomeDestinatario);

}
