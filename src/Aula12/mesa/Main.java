package Aula12.mesa;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.sql.*;

public class Main {
    private static final Logger logger = Logger.getLogger(Aula12.ex1.Main.class);
    private static final String sqlCreate = "CREATE TABLE filmes (" +
            "id INT PRIMARY KEY, " +
            "nome VARCHAR2 NOT NULL, " +
            "ano INT NOT NULL, " +
            "diretor VARCHAR2 NOT NULL, " +
            "classificacao VARCHAR2 NOT NULL)";
    private static final String sqlDrop = "DROP TABLE IF EXISTS filmes";
    private static final String sqlInsert = "INSERT INTO filmes (id, nome, ano, diretor, classificacao) VALUES (1, 'Harry Potter e a Pedra Filosofal', 2001, 'Chris Columbus', 'Livre')";
    private static final String sqlInsert2 = "INSERT INTO filmes (id, nome, ano, diretor, classificacao) VALUES (2, 'Enders Game', 2013, 'Gavin Hood', '12')";
    private static final String sqlInsert3 = "INSERT INTO filmes (id, nome, ano, diretor, classificacao) VALUES (3, 'Tron: Legacy', 2010, 'Joseph Kosinski', '10')";
    private static final String sqlSelect = "SELECT * FROM filmes";
    private static final String sqlUpdate = "UPDATE filmes SET diretor='Vinny Mendes' Where id=3";
    private static final String sqlDelete = "DELETE FROM filmes WHERE id= 1";
    public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");
        Connection connection;
        try{
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(sqlDrop);
            statement.execute(sqlCreate);
            try {
                statement.execute(sqlInsert);
                statement.execute(sqlInsert2);
                statement.execute(sqlInsert3);
            }catch (SQLException e){
                logger.error("|| CANNOT REPEAT AN ID ||" + e.getMessage());
            }
            showMovie(connection);
            statement.execute(sqlUpdate);
            ResultSet resultado = statement.executeQuery("SELECT * FROM filmes WHERE id=1");
            while(resultado.next()){
                logger.debug("O filme: " + resultado.getString(2) + " foi atualizado!");
            }
            statement.execute(sqlDelete);
            logger.info("Deleted the movie with id=1");
            statement.execute("DELETE FROM filmes WHERE diretor= 'Gavin Hood'");
            logger.info("O filme Enders Game foi deletado");
            showMovie(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void showMovie(Connection connection) throws Exception{
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sqlSelect);
        while(result.next()){
            logger.info("ID: "+ result.getString(1) +" Filme: " + result.getString(2) + " Ano: "+result.getString(3) + " Diretor: " +result.getString(4) + " Classificação: " + result.getString(5));
        }
    }
    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa","");
    }
}
