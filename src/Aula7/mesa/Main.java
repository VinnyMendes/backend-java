package Aula7.mesa;


import Aula7.mesa.model.Arvore;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArvoreFactory factory = new ArvoreFactory();

        List<Arvore> ornamentais = new ArrayList<>();
        List<Arvore> frutiferas = new ArrayList<>();

        for (int i=0; i<500000; i++){
            ornamentais.add(factory.buscarArvore(200,400,"verde"));
            frutiferas.add(factory.buscarArvore(500,300,"vermelho"));
        }

        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memória utilizada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));
    }
}