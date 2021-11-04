package Aula14.mesa;

import Aula14.ex1.model.Cachorro;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Contato contato1 = new Contato("Vinny",18, "21381273");
        Contato contato2 = new Contato("Tuts",23, "412421213");
        Contato contato3 = new Contato("Raffa",31, "1231234");

        List<Contato> contatos = new ArrayList<>();

        contatos.add(contato1);
        contatos.add(contato2);
        contatos.add(contato3);

        //Criar o arquivo
        FileOutputStream fileOut;

        try {
            fileOut = new FileOutputStream("ListaContatos.txt");
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);

            objOut.writeObject(contatos);

        }catch (Exception e){
            e.printStackTrace();
        }

        //Ler o arquivo
        List<Contato> contatos2 = null;
        FileInputStream fileInput;
        try {
            fileInput = new FileInputStream("ListaContatos.txt");
            ObjectInputStream objInput = new ObjectInputStream(fileInput);

            contatos2 = (ArrayList) objInput.readObject();

        }catch (Exception e){
            e.printStackTrace();
        }


        for(Contato contato: contatos2){
            System.out.println("Nome: "+ contato.getNome() + " CPF: " + contato.getCpf() + " Idade: " + contato.getIdade());
        }

    }
}
