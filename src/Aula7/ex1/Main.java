package Aula7.ex1;

import Aula7.ex1.model.Computador;

public class Main {

    public static void main(String[] args) {

        ComputadorFactory factory = new ComputadorFactory();
        Computador computador1= factory.buscarComputador(8,500);
        Computador computador2= factory.buscarComputador(16,128);

        Computador computador3= factory.buscarComputador(8,500);

        System.out.println(computador1.toString());
        System.out.println(computador2.toString());
        System.out.println(computador3.toString());

    }
}