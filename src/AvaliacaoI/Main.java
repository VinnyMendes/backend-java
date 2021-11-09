package AvaliacaoI;

import AvaliacaoI.dao.ServidorH2;
import AvaliacaoI.model.Dentista;
import org.apache.log4j.PropertyConfigurator;

public class Main {

    public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");

        Dentista dentista1 = new Dentista("123", "Vinny", "Mendes");
        Dentista dentista2 = new Dentista("321", "Bruno", "Novo");
        Dentista dentista3 = new Dentista("132", "Tiago", "Mathias");

        ServidorH2 servidor = new ServidorH2();
        servidor.dropTable();
        servidor.createTable();

        servidor.insert(dentista1);
        servidor.insert(dentista2);
        servidor.insert(dentista3);

        servidor.selectAll();

    }
}
