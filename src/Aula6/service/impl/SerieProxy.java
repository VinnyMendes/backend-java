package Aula6.service.impl;


import Aula6.service.ISerie;
import Aula6.service.SerieNaoHabilitadaException;

public class SerieProxy implements ISerie {
    private int qtdViews;
    private Serie serie = new Serie();

    public SerieProxy(Serie serie) {
        this.serie = serie;
    }

    @Override
    public String getSerie(String nome) throws SerieNaoHabilitadaException {
        if (qtdViews<5){
            qtdViews++;
            return serie.getSerie(nome);
        }else{
            throw new SerieNaoHabilitadaException("Limite de Séries por semana Atingido");
        }
    }
}