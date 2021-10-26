package Aula6.service.impl;


import Aula6.service.ISerie;

public class Serie implements ISerie {

    @Override
    public String getSerie(String nome) {
        return "www.vinnyflix.com.br/series/"+nome;
    }
}
