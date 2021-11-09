package AvaliacaoI.dao;

public interface IDao<T> {
    public void createTable();
    public void insert(T t);
    public void delete(Integer id);
    public String select(Integer id);
    public void selectAll();
    public void dropTable();
}
