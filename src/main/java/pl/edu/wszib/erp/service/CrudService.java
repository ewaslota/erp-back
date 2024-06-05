package pl.edu.wszib.erp.service;

import org.springframework.data.domain.Page;

public interface CrudService<T, ID> {

  Page<T> list(int page, int size, String[] sortColumns, String[] sortDirections);
  T get(ID id);
  T create(T t);
  T update(T t);
  void delete(ID id);

}
