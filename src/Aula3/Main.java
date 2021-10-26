package Aula3;


import Aula3.model.Afiliado;
import Aula3.model.Funcionario;

public class Main {

    public static void main(String[] args) {
        Funcionario vinny = new Funcionario("Vinicius Mendes", 15);

        Afiliado jorge = new Afiliado("Jorge", 1);
        Afiliado raffa = new Afiliado("Raffa", 2);
        Afiliado monica = new Afiliado("Monica", 3);

        vinny.obterAfiliado(jorge);
        vinny.obterAfiliado(raffa);
        vinny.obterAfiliado(monica);

        vinny.vender();
        vinny.vender();
        vinny.vender();
        vinny.vender();
        vinny.vender();
        vinny.vender();
        vinny.vender();
        vinny.vender();

        System.out.println(vinny.getNome() +" tem um total de: "+ vinny.getPontos()+ " pontos e categoriza como vendedor " + vinny.mostrarCategoria());
        System.out.println(jorge.getNome() + " tem um total de: " + jorge.getPontos()+ " pontos e categoriza como afiliado "+ jorge.mostrarCategoria());
    }
}
