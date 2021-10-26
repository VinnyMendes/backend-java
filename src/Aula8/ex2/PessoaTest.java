package Aula8.ex2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class PessoaTest {
    Pessoa pessoa1;
    Pessoa pessoa2;
    Pessoa pessoa3;
    @BeforeEach
    void doBefore(){
        pessoa1 = new Pessoa("Vinny","Mendes");
        pessoa2 = new Pessoa("Raffa","Mendes");
        pessoa3 = new Pessoa("Luísa","Mendes");

        pessoa1.setIdade(LocalDate.of(2003,6,20));
        pessoa2.setIdade(LocalDate.of(1990,1,24));
        pessoa3.setIdade(LocalDate.of(2005,10,25));
    }
    @Test
    void getNomeCompleto(){
        Assertions.assertEquals("Vinny Mendes", pessoa1.calcularNomeCompleto());
    }
    @Test
    void isNotMinor(){
        Assertions.assertTrue(pessoa1.ehMaiorDeIdade());
    }
}
