package AvaliacaoI.dao;

import AvaliacaoI.config.ConfigJDBC;
import AvaliacaoI.model.Dentista;
import org.apache.log4j.Logger;
import org.apache.log4j.chainsaw.Main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ServidorH2 implements IDao<Dentista>{
    private static final Logger logger = Logger.getLogger(Main.class);
    private final ConfigJDBC config = new ConfigJDBC();

    @Override
    public void createTable() {
        String query = "CREATE TABLE IF NOT EXISTS dentista(id int not null auto_increment, nome VARCHAR(30) NOT NULL, sobrenome VARCHAR(30) NOT NULL, matricula VARCHAR(120) NOT NULL)";
        try {
            Connection connection = config.getConnectionH2();
            Statement stmt = connection.createStatement();
            stmt.execute(query);
            logger.info("Tabela 'dentista' criada");
            stmt.close();
        }catch (Exception e){
            logger.error(e);
        }
    }

    @Override
    public void insert(Dentista dentista) {
        String query = String.format("INSERT INTO dentista (nome, sobrenome, matricula) VALUES ('%s', '%s', '%s')",dentista.getNome(), dentista.getSobrenome(), dentista.getMatricula());

        try {
            Connection connection = config.getConnectionH2();
            Statement stmt = connection.createStatement();
            stmt.execute(query);
            logger.info(String.format("Dentista '%s' inserido na tabela com sucesso!", dentista.getNome()));
            stmt.close();
        }catch (Exception e){
            logger.error(e);
        }
    }

    @Override
    public void delete(Integer id) {
        String query = String.format("DELETE FROM dentista WHERE id=%s", id);

        try {
            Connection connection = config.getConnectionH2();
            Statement stmt = connection.createStatement();
            stmt.execute(query);
            logger.info(String.format("Dentista com o id: %s excluído com sucesso", id));
            stmt.close();
        } catch (Exception e){
            logger.error(e);
        }
    }
    @Override
    public String select(Integer id) {
        String query = String.format("SELECT * FROM dentista WHERE id=%s", id);
        String result = null;
        try {
            Connection connection = config.getConnectionH2();
            Statement stmt = connection.createStatement();
            logger.info(String.format("Busca pelo dentista de id: %s",id));
            ResultSet resultado = stmt.executeQuery(query);
            while (resultado.next()){
                result = resultado.getString(2);
            }
            stmt.close();
        }catch (Exception e){
            logger.error(e);
        }
        return result;
    }

    @Override
    public void selectAll() {
        String query = "SELECT * FROM dentista";

        try {
            Connection connection = config.getConnectionH2();
            Statement stmt = connection.createStatement();

            logger.info("Resultados da tabela dentista:");
            ResultSet result = stmt.executeQuery(query);
            while(result.next()){

                logger.info("ID: "+result.getString(1)+" Nome: "+result.getString(2)+" Sobrenome: "+result.getString(3)+" Matrícula: " + result.getString(4));

            }
            stmt.close();
        }catch (Exception e){
            logger.error(e);
        }
    }

    @Override
    public void dropTable() {
        String query = "DROP TABLE IF EXISTS dentista";
        try {
            Connection connection = config.getConnectionH2();
            Statement stmt = connection.createStatement();

            logger.info("Tabela excluída");
            stmt.execute(query);
            stmt.close();
        }catch (Exception e){
            logger.error(e);
        }
    }
}
