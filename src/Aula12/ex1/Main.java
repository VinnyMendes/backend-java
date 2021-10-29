package Aula12.ex1;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.sql.*;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);

    private static final String sqlCreate = "CREATE TABLE usuario (" +
            "id INT PRIMARY KEY, " +
            "primeiroNome VARCHAR2 NOT NULL, " +
            "sobrenome VARCHAR2 NOT NULL, " +
            "idade INT NOT NULL)";

    private static final String sqlDrop = "DROP TABLE IF EXISTS usuario";

    private static final String sqlInsert = "INSERT INTO usuario (id, primeiroNome, sobrenome, idade) VALUES (1, 'Vinicius', 'Mendes', 18)";
    private static final String sqlInsert2 = "INSERT INTO usuario (id, primeiroNome, sobrenome, idade) VALUES (2, 'Felipe', 'Rosa', 34)";
    private static final String sqlInsert3 = "INSERT INTO usuario (id, primeiroNome, sobrenome, idade) VALUES (3, 'Matheus', 'Dalmas', 34)";

    private static final String sqlSelect = "SELECT * FROM usuario";

    private static final String sqlDelete = "DELETE FROM usuario WHERE id= 2";

    public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");

        logger.error("DEU ERRADO AQUI Ó");

        Connection connection;

        try{
            connection = getConnection();
            Statement statement = connection.createStatement();

            statement.execute(sqlDrop);
            statement.execute(sqlCreate);

            statement.execute(sqlInsert);
            statement.execute(sqlInsert2);
            statement.execute(sqlInsert3);

            showUser(connection);

            statement.execute(sqlDelete);

            logger.info("O Usuario Felipe foi deletado");
            showUser(connection);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void showUser(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sqlSelect);

        while(result.next()){
            logger.warn("Usuario " + result.getString(2) +" "+ result.getString(3));
        }
    }

    public static Connection getConnection() throws Exception{

        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa","");
    }
}
