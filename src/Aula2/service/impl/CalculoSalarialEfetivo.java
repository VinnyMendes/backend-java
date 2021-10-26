package Aula2.service.impl;

import Aula2.model.Funcionario;
import Aula2.model.FuncionarioEfetivo;
import Aula2.service.PagamentoService;

public class CalculoSalarialEfetivo extends PagamentoService {
    @Override
    protected Double calcularSalario(Funcionario funcionario) {
        FuncionarioEfetivo efetivo = ((FuncionarioEfetivo) funcionario);
        Double salario = efetivo.getSalarioBase();
        salario -= (efetivo.getSalarioBase() * efetivo.getDesconto()/100);
        salario += (salario * efetivo.getBeneficio()/100);

        return salario;
    }
}
