package pl.edu.wszib.erp.service;

import java.util.List;

public interface CrudService<T, ID> {

  List<T> list();
  T get(ID id);
  T create(T t);
  T update(T t);
  void delete(ID id);

}
