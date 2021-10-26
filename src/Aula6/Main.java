package Aula6;


import Aula6.service.ISerie;
import Aula6.service.SerieNaoHabilitadaException;
import Aula6.service.impl.Serie;
import Aula6.service.impl.SerieProxy;

public class Main {

    public static void main(String[] args) throws SerieNaoHabilitadaException {

        ISerie serie = new SerieProxy(new Serie());

        System.out.println(serie.getSerie("A_volta_dos_que_nao_foram"));
        System.out.println(serie.getSerie("Game_Of_Thrones"));
        System.out.println(serie.getSerie("Supernatural"));
        System.out.println(serie.getSerie("Os_Simpsons"));
        System.out.println(serie.getSerie("ICarly"));
        System.out.println(serie.getSerie("The_100"));
    }
}