package Aula14.ex1;

import Aula14.ex1.model.Cachorro;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Cachorro> cachorros = new ArrayList<>();

        Cachorro cachorro1 = new Cachorro("Bob", 3);
        Cachorro cachorro2 = new Cachorro("Rex", 5);
        Cachorro cachorro3 = new Cachorro("Mel", 2);

        cachorros.add(cachorro1);
        cachorros.add(cachorro2);
        cachorros.add(cachorro3);

        //Criar o arquivo
        FileOutputStream fileOut;

        try {
            fileOut = new FileOutputStream("ListaCachorros.txt");
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);

            objOut.writeObject(cachorros);

        }catch (Exception e){
            e.printStackTrace();
        }


        //Ler o arquivo
        List<Cachorro> cachorros2 = null;
        FileInputStream fileInput;
        try {
            fileInput = new FileInputStream("ListaCachorros.txt");
            ObjectInputStream objInput = new ObjectInputStream(fileInput);

            cachorros2 = (ArrayList) objInput.readObject();

        }catch (Exception e){
            e.printStackTrace();
        }

        for(Cachorro c: cachorros2){
            System.out.println("Nome: "+ c.getNome() + " Idade: " + c.getIdade());
        }


    }



}
