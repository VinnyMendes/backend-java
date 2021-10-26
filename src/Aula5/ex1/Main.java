package Aula5.ex1;

import Aula5.ex1.model.Pessoa;
import Aula5.ex1.service.IVacinacao;
import Aula5.ex1.service.impl.VacinacaoProxy;
import Aula5.ex1.service.impl.VacinacaoService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yy");
        Date data = formatoData.parse("14/10/21");

        Pessoa pessoa = new Pessoa("Vinny","Mendes","123123","Pfizer",data);

        IVacinacao proxy = new VacinacaoProxy(new VacinacaoService());

        proxy.vacinar(pessoa);


    }
}