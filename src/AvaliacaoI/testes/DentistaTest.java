package AvaliacaoI.testes;

import AvaliacaoI.config.ConfigJDBC;
import AvaliacaoI.dao.ServidorH2;
import AvaliacaoI.model.Dentista;
import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DentistaTest {

    @BeforeAll
    static void antes(){
        PropertyConfigurator.configure("log4j.properties");
    }

    @Test
    void testeDoSelect(){

        ConfigJDBC config = new ConfigJDBC();

        Dentista dentista1 = new Dentista("123", "Vinny", "Mendes");
        Dentista dentista2 = new Dentista("321", "Bruno", "Novo");
        Dentista dentista3 = new Dentista("132", "Volpi", "Volpi");
        ServidorH2 servidor = new ServidorH2();

        servidor.dropTable();
        servidor.createTable();
        servidor.insert(dentista1);
        servidor.insert(dentista2);
        servidor.insert(dentista3);
        servidor.selectAll();

        String resultado = servidor.select(1);
        String resultado2 = servidor.select(2);
        String resultado3 = servidor.select(3);

        Assertions.assertEquals(resultado, dentista1.getNome());
        Assertions.assertEquals(resultado2, dentista2.getNome());
        Assertions.assertEquals(resultado3, dentista3.getNome());

    }
}
