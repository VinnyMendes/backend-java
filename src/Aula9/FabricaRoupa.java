package Aula9;

import java.util.HashMap;
import java.util.Map;

public class FabricaRoupa {

    private static Map<String, Roupa> flyweight = new HashMap<>();

    private static Integer counter = 0;

    public Roupa fabricarRoupa(TipoRoupa tipoRoupa, Tamanho tamanho, Boolean eNovo, Boolean importada){

        String id = "tipoRoupa:" + tipoRoupa;

        if(!flyweight.containsKey(id)){
            flyweight.put(id, new Roupa(tipoRoupa, tamanho, eNovo, importada));
        }
        counter++;
        return flyweight.get(id);
    }

    public int getFlyweightSize(){
        return flyweight.size();
    }

    public static Integer getCounter() {
        return counter;
    }
}

