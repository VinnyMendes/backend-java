package Aula11.mesa;

import java.sql.*;

public class Main {

    private static final String sqlCreate =
            "CREATE TABLE Figuras (" +
                    "id INT PRIMARY KEY," +
                    " figura VARCHAR(120) NOT NULL," +
                    " cor VARCHAR(120) NOT NULL)";

    private static final String sqlDrop = "DROP TABLE IF EXISTS Figuras";

    private static final String sqlInsert = "INSERT INTO Figuras (id, figura, cor) VALUES (1, 'Quadrado', 'Vermelho')";
    private static final String sqlInsert1 = "INSERT INTO Figuras (id, figura, cor) VALUES (2, 'Quadrado', 'Azul')";
    private static final String sqlInsert2 = "INSERT INTO Figuras (id, figura, cor) VALUES (3, 'Quadrado', 'Amarelo')";
    private static final String sqlInsert3 = "INSERT INTO Figuras (id, figura, cor) VALUES (4, 'Quadrado', 'Laranja')";
    private static final String sqlInsert4 = "INSERT INTO Figuras (id, figura, cor) VALUES (5, 'Circulo', 'Roxo')";
    private static final String sqlInsert5 = "INSERT INTO Figuras (id, figura, cor) VALUES (6, 'Circulo', 'Verde')";

    private static final String sqlSelect = "SELECT * FROM Figuras WHERE figura='Quadrado'";

    private static final String sqlDelete = "DELETE FROM Figuras WHERE id=1";

    public static void main(String[] args) {
        Connection connection;

        try {
            connection = getConnection();
            Statement statement = connection.createStatement();

            statement.execute(sqlDrop);
            statement.execute(sqlCreate);

            statement.execute(sqlInsert);
            statement.execute(sqlInsert1);
            statement.execute(sqlInsert2);
            statement.execute(sqlInsert3);
            statement.execute(sqlInsert4);
            statement.execute(sqlInsert5);

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
