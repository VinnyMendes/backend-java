package Aula11.ex1;

import java.sql.*;

public class Main {

    private static final String sqlCreate =
            "CREATE TABLE Animal (" +
                    "id INT PRIMARY KEY," +
                    " nome VARCHAR(120) NOT NULL," +
                    " tipo VARCHAR(120) NOT NULL)";

    private static final String sqlDrop = "DROP TABLE IF EXISTS Animal";

    private static final String sqlInsert = "INSERT INTO Animal (id, nome, tipo) VALUES (1, 'Tchuco', 'Gato')";
    private static final String sqlInsert1 = "INSERT INTO Animal (id, nome, tipo) VALUES (2, 'Rex', 'Cachorro')";
    private static final String sqlInsert2 = "INSERT INTO Animal (id, nome, tipo) VALUES (3, 'Pikachu', 'Pokemon')";

    private static final String sqlSelect = "SELECT * FROM Animal";

    private static final String sqlDelete = "DELETE FROM Animal WHERE id=1";

    public static void main(String[] args) {
        Connection connection;

        try{
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(sqlDrop);
            statement.execute(sqlCreate);

            statement.execute(sqlInsert);
            statement.execute(sqlInsert1);
            statement.execute(sqlInsert2);

            mostrarAnimais(connection);

            statement.execute(sqlDelete);

            mostrarAnimais(connection);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void mostrarAnimais(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultado = statement.executeQuery(sqlSelect);

        while (resultado.next()){
            System.out.println(resultado.getInt(1) + " " + resultado.getString(2) + " " + resultado.getString(3));
        }

    }

    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa","");
    }
}
