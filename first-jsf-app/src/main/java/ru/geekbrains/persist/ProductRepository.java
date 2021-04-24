package ru.geekbrains.persist;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ProductRepository {

    @PersistenceContext(unitName = "ds")
    private EntityManager em;


    @TransactionAttribute
    public void save(Product product) {
        if (product.getId() == null) {
            em.persist(product);
        }
        em.merge(product);
    }

    @TransactionAttribute
    public void deleteById(Long id) {
        em.createNamedQuery("deleteProductById")
                .setParameter("id", id)
                .executeUpdate();
    }

    public Product findById(Long id) {
        return em.find(Product.class, id);
    }

    public List<Product> findAll() {
        return em.createNamedQuery("findAllProduct", Product.class)
                .getResultList();
    }

    public List<Product> findAllWithCategoryFetch() {
        return em.createNamedQuery("findAllWithCategoryFetch", Product.class)
                .getResultList();
    }

    public List<Product> findByName(String name) {
        return em.createNamedQuery("findByName", Product.class)
                .setParameter("name", name)
                .getResultList();
    }

    public List<Product> findByCategoryId(long id) {
        return em.createNamedQuery("findByCategoryId", Product.class)
                .setParameter("id", id)
                .getResultList();
    }

    public long count() {
        return em.createNamedQuery("countProduct", Long.class).getSingleResult();
    }
}
