package Aula9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FabricaTest {

    FabricaRoupa fabricaRoupa = new FabricaRoupa();
    Roupa calca1 = fabricaRoupa.fabricarRoupa(TipoRoupa.CALCA, Tamanho.XS, true, true);
    Roupa calca2 = fabricaRoupa.fabricarRoupa(TipoRoupa.CALCA, Tamanho.S, true, false);
    Roupa calca3 = fabricaRoupa.fabricarRoupa(TipoRoupa.CALCA, Tamanho.M, false, true);
    Roupa camisa1 = fabricaRoupa.fabricarRoupa(TipoRoupa.CAMISA, Tamanho.L, false, false);
    Roupa camisa2 = fabricaRoupa.fabricarRoupa(TipoRoupa.CAMISA, Tamanho.XL, true, true);

    @Test
    void ProductionTest(){
        Assertions.assertEquals(TipoRoupa.CALCA, calca1.getTipoRoupa());
        Assertions.assertEquals(Tamanho.XS, calca1.getTamanho());
        Assertions.assertTrue(calca1.geteNovo());
        Assertions.assertTrue(calca1.getImportada());
    }
    @Test
    void ProductionTest2(){
        Assertions.assertTrue(
                camisa1.getTipoRoupa() == TipoRoupa.CAMISA &&
                        camisa1.getTamanho() == Tamanho.L &&
                        !camisa1.geteNovo() &&
                        !camisa1.getImportada());
    }
    @Test
    void TestandoTamanho(){
        Assertions.assertTrue(FabricaRoupa.getCounter() > fabricaRoupa.getFlyweightSize());
    }
}