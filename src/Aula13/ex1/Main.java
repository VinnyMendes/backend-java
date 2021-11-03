package Aula13.ex1;

import Aula13.ex1.dao.ServidorH2;
import Aula13.ex1.model.Medicamento;


public class Main {
    public static void main(String[] args) {
        Medicamento med = new Medicamento(1,"abc123","Dorflex","NeoQuimica",3,10.99);
        ServidorH2 servidor = new ServidorH2();

        servidor.insert(med);
        servidor.select(med.getId());
        servidor.selectCodNumerico(med.getCodNumerico());
        servidor.selectAll();
        servidor.delete(med.getId());
    }
}
