package za.ac.cput.repository;

public interface IRepository <T>{
    T create(T t);

    T read();

    T update(T t);

    void delete();

}
