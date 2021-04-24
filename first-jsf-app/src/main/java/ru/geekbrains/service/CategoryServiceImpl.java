package ru.geekbrains.service;

import ru.geekbrains.persist.Category;
import ru.geekbrains.persist.CategoryRepository;
import ru.geekbrains.rest.CategoryResource;
import ru.geekbrains.service.repr.CategoryRepr;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class CategoryServiceImpl implements CategoryService, CategoryResource {

    @EJB
    private CategoryRepository categoryRepository;

    @Override
    public void insert(Category category) {
        if (category.getId() != null) {
            throw new IllegalArgumentException("Not null id in the inserted Product");
        }
        save(category);
    }

    @Override
    public void update(Category category) {
        if (category.getId() == null) {
            throw new IllegalArgumentException("Not null id in the inserted Product");
        }
        save(category);
    }

    @Override
    @TransactionAttribute
    public void delete(long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    @TransactionAttribute
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category findById(long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<CategoryRepr> findAllCategory(){
        return categoryRepository.findAll().stream()
                .map(CategoryServiceImpl::createCategoryRepr)
                .collect(Collectors.toList());
    }

    private static CategoryRepr createCategoryRepr(Category category) {
        return new CategoryRepr(category.getId(),
                category.getName());
    }
}
