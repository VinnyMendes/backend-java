package Aula13.ex1.dao;

import Aula13.ex1.config.ConfigJDBC;
import Aula13.ex1.model.Medicamento;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ServidorH2 implements IDao<Medicamento>{
    private static final Logger logger = Logger.getLogger(Aula10.Main.class);


    private ConfigJDBC config = new ConfigJDBC();

    @Override
    public void insert(Medicamento medicamento) {

        String query = String.format("INSERT INTO Medicamento VALUES ('%s', '%s', '%s', '%s', '%s', '%s')", medicamento.getId(), medicamento.getCodNumerico(),
                medicamento.getNome(),medicamento.getLaboratorio(),medicamento.getQuantidade(),medicamento.getPreco());
        try {
            Connection connection = config.getConnectionH2();
            Statement stmt = connection.createStatement();
            stmt.execute(query);
            stmt.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {

        String query = String.format("DELETE FROM Medicamento WHERE id=%s", id);

        try {
            Connection connection = config.getConnectionH2();
            Statement stmt = connection.createStatement();
            stmt.execute(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void select(Integer id) {
        PropertyConfigurator.configure("log4j.properties");
        String query = String.format("SELECT * FROM Medicamento WHERE id=%s", id);
        try{
            Connection connection = config.getConnectionH2();
            Statement stmt = connection.createStatement();

            ResultSet result = stmt.executeQuery(query);

            while (result.next()){
                logger.info("----------------------------");
                logger.info(result.getInt(1));
                logger.info(result.getString(2));
                logger.info(result.getString(3));
                logger.info(result.getString(4));
                logger.info(result.getInt(5));
                logger.info(result.getDouble(6));
                logger.info("----------------------------");
            }
            stmt.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void selectCodNumerico(String cod) {
        PropertyConfigurator.configure("log4j.properties");
        String query = String.format("SELECT * FROM Medicamento WHERE codigonumerico = '%s' ", cod);
        try {
            Connection connection = config.getConnectionH2();
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query);

            while (result.next()){
                logger.info("----------------------------");
                logger.info(result.getInt(1));
                logger.info(result.getString(2));
                logger.info(result.getString(3));
                logger.info(result.getString(4));
                logger.info(result.getInt(5));
                logger.info(result.getDouble(6));
                logger.info("----------------------------");
            }
            stmt.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void selectAll() {
        PropertyConfigurator.configure("log4j.properties");
        String query = "SELECT * FROM Medicamento";
        try{
            Connection connection = config.getConnectionH2();
            Statement stmt = connection.createStatement();

            ResultSet result = stmt.executeQuery(query);
            while (result.next()){
                logger.info("----------------------------");
                logger.info(result.getInt(1));
                logger.info(result.getString(2));
                logger.info(result.getString(3));
                logger.info(result.getString(4));
                logger.info(result.getInt(5));
                logger.info(result.getDouble(6));
                logger.info("----------------------------");
            }
            stmt.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}