package ru.geekbrains.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.filter.SecurityFilter;
import ru.geekbrains.persist.*;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.math.BigDecimal;

@WebListener
public class StartupListener implements ServletContextListener {

    private static final Logger logger = LoggerFactory.getLogger(StartupListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("Startup Listener");

        ProductRepository productRepository = new ProductRepository();
        CustomerRepository customerRepository = new CustomerRepository();
        CategoryRepository categoryRepository = new CategoryRepository();

        productRepository.save(new Product(null, "Product 1", "Description 1", new BigDecimal(100)));
        productRepository.save(new Product(null, "Product 2", "Description 2", new BigDecimal(200)));
        productRepository.save(new Product(null, "Product 3", "Description 3", new BigDecimal(300)));

        customerRepository.save(new Customer(null, "Customer-1", "none@mail.org"));
        customerRepository.save(new Customer(null, "Customer-2", "none@mail.net"));
        customerRepository.save(new Customer(null, "Customer-3", "none@mail.dot"));

        categoryRepository.save(new Category(null, "Category-1"));
        categoryRepository.save(new Category(null, "Category-2"));

        sce.getServletContext().setAttribute("customerRepository", customerRepository);
        sce.getServletContext().setAttribute("productRepository", productRepository);
        sce.getServletContext().setAttribute("categoryRepository", categoryRepository);
    }
}
