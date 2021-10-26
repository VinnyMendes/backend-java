package Aula1.impl;

import Aula1.exapi.ApiCartao;
import Aula1.exapi.ApiProduto;
import Aula1.exapi.ApiQuantidade;
import Aula1.interfac.IDesconto;
import Aula1.model.Cartao;
import Aula1.model.Produto;


public class ServiceDesconto implements IDesconto {

    private final ApiCartao apiCartao = new ApiCartao();
    private final ApiProduto apiProduto = new ApiProduto();
    private final ApiQuantidade apiQuantidade = new ApiQuantidade();

    @Override
    public Double calcularDesconto(Cartao cartao, Produto produto, Integer quantidade) {
        Double desconto = 0.00;

        desconto = desconto + apiCartao.checkDesconto(cartao.getBanco());
        desconto += apiProduto.checkDesconto(produto.getTipo());
        desconto += apiQuantidade.checkDesconto(quantidade);

        return desconto;
    }

}
