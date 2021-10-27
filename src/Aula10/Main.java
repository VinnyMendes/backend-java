package Aula10;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");

        Integer[] lista = {2,3,4,41,10,2,4,12,3,14,14};
        Integer[] listaVazia = {};
        Media media = new Media(listaVazia);

        media.setMedia(media.calcularMedia());

        if(media.getListaDeNumeros().length >= 10){
            logger.info("Lista de números é maior ou igual a 10");
        }else if(media.getListaDeNumeros().length > 5){
            logger.info("Lista de números é maior que 5");
        }else if(media.getListaDeNumeros().length > 0){
            logger.info("Lista de números é menor que 5");
        }else{
            logger.error("A lista está vazia");
            throw new Error("Lista vazia");
        }
        logger.info("A média é igual a: " + media.getMedia());
    }
}