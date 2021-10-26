package Aula5.ex1.service.impl;


import Aula5.ex1.model.Pessoa;
import Aula5.ex1.service.IVacinacao;

import java.util.Date;

public class VacinacaoProxy implements IVacinacao {
    private final VacinacaoService vacinacaoService;

    public VacinacaoProxy(VacinacaoService vacinacaoService) {
        this.vacinacaoService = vacinacaoService;
    }

    @Override
    public void vacinar(Pessoa pessoa) {

        Date dataAtual = new Date();

        if(pessoa.getDataVacina().before(dataAtual) || pessoa.getDataVacina().equals(dataAtual)){
            vacinacaoService.vacinar(pessoa);
        }else{
            System.out.println("Ainda não chegou a sua vez!!");
        }
    }
}