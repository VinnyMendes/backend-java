package Aula8.mesa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FigurasTest {
    @Test
    void testaPerimetro(){
        Quadrado quadrado = new Quadrado(4);
        double resultado = quadrado.calcularPerimetro();
        Assertions.assertEquals(4*quadrado.getComprimento(), resultado);
    }
    @Test
    void testaPerimetroDeNovo(){
        Circulo circulo = new Circulo(4);
        double resultado = circulo.calcularPerimetro();
        Assertions.assertEquals(2 * Math.PI * circulo.getRaio(), resultado);
    }
}