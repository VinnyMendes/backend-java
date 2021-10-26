package Aula8.ex1.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {
    @Test
    public void retornarZero(){
        Calculadora calculadora = new Calculadora();
        double soma = calculadora.sum();
        Assertions.assertEquals(0, soma);
    }
    @Test
    public void retornarSoma(){
        Calculadora calculadora = new Calculadora();
        double soma = calculadora.sum(5,4,3,2,1);
        Assertions.assertEquals(15, soma);
    }
}