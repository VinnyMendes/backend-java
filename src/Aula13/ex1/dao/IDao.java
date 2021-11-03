package Aula13.ex1.dao;

public interface IDao<T> {

    public void insert(T t);
    public void delete(Integer id);
    public void select(Integer id);
    public void selectCodNumerico(String cod);
    public void selectAll();

}