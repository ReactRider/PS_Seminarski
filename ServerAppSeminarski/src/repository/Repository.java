/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;
import java.util.List;
/**
 *
 * @author ennouser
 */
public interface Repository<T,K> {
    List<T> getAll(T t) throws Exception;
    long add(T t) throws Exception;
    boolean edit(T t) throws Exception;
    boolean delete(T t, T t2) throws Exception;
    List<T> getByODK(T t, T t2, String s) throws Exception;
    Object login(T t) throws Exception;
}
