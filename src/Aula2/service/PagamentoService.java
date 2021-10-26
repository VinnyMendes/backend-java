package Aula2.service;

import Aula2.model.Funcionario;
import Aula2.model.Tipo;


public abstract class PagamentoService {

    public void pagar(Funcionario funcionario){

        funcionario.setSalarioFinal(calcularSalario(funcionario));
        Double salario = funcionario.getSalarioFinal();

        String resultado = String.format("%.2f", funcionario.getSalarioFinal());
        System.out.println(resultado);


        System.out.println(depositarSalario(funcionario.getContaBancaria(), salario));
        System.out.println(emitirComprovante(funcionario.getTipo()));
    }
    private String depositarSalario(String conta, Double salarioFinal){
        return "Deposito do salario " + salarioFinal + " efetuado na conta " + conta;
    }
    private String emitirComprovante(Tipo tipo){
        if(tipo == Tipo.CONTRATADO){
            return "Recibo enviado por Email";
        }else if(tipo == Tipo.EFETIVO){
            return "Recibo impresso com sucesso";
        }
        return "Erro ao emitir o recibo";
    }
    protected abstract Double calcularSalario(Funcionario funcionario);
}