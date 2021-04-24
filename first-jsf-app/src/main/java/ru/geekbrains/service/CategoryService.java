package ru.geekbrains.service;

import ru.geekbrains.persist.Category;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CategoryService {

    void save(Category category);

    void delete(long id);

    Category findById(long id);

    List<Category> findAll();

//    long count();
}
