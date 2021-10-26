package Aula7.ex1;


import Aula7.ex1.model.Computador;

import java.util.HashMap;
import java.util.Map;

public class ComputadorFactory {

    private static Map<String, Computador> flyweight = new HashMap<>();

    public Computador buscarComputador(Integer ram, Integer hd){

        String id = "ram:" + ram + "hd:"+ hd;

        if (!flyweight.containsKey(id)){
            flyweight.put(id, new Computador(ram, hd));
            System.out.println("Computador criado!");
        }else{
            System.out.println("Computador existente");
        }

        return flyweight.get(id);
    }
}
