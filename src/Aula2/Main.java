package Aula2;

import Aula2.model.Funcionario;
import Aula2.model.FuncionarioContratado;
import Aula2.model.FuncionarioEfetivo;
import Aula2.model.Tipo;
import Aula2.service.PagamentoService;
import Aula2.service.impl.CalculoSalarialContratado;
import Aula2.service.impl.CalculoSalarialEfetivo;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, PagamentoService> serviceMap = Map.of("Contratado", new CalculoSalarialContratado(), "Efetivo", new CalculoSalarialEfetivo());

        Funcionario efetivo = new FuncionarioEfetivo("Vinny","Mendes","123", Tipo.EFETIVO, 2400.35);

        Funcionario contratado = new FuncionarioContratado("Raffa", "Mendes", "321",Tipo.CONTRATADO,175, 35.00);

        PagamentoService service = serviceMap.get("Efetivo");
        service.pagar(efetivo);

        PagamentoService service2 = serviceMap.get("Contratado");
        service2.pagar(contratado);
    }
}
