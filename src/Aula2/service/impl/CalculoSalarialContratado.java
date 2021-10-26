package Aula2.service.impl;

import Aula2.model.Funcionario;
import Aula2.model.FuncionarioContratado;
import Aula2.service.PagamentoService;

public class CalculoSalarialContratado extends PagamentoService {
    @Override
    protected Double calcularSalario(Funcionario funcionario) {
        FuncionarioContratado contratado = ((FuncionarioContratado) funcionario);

        return contratado.getValorHora() * contratado.getNumHoras();
    }
}
