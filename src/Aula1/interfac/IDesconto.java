package Aula1.interfac;

import Aula1.model.Cartao;
import Aula1.model.Produto;

public interface IDesconto {
    public Double calcularDesconto(Cartao cartao, Produto produto, Integer quantidade);
}