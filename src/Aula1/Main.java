package Aula1;


import Aula1.impl.ServiceDesconto;
import Aula1.model.Cartao;
import Aula1.model.Produto;

public class Main {
    public static void main(String[] args) {
        Cartao cartao = new Cartao("1321312", "Star Bank");
        Produto produto = new Produto("Leite", "latas");

        ServiceDesconto service = new ServiceDesconto();

        System.out.println(service.calcularDesconto(cartao, produto, 13));
    }
}
