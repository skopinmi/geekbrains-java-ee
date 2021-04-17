package ru.geekbrains.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.service.CartService;
import ru.geekbrains.service.CartServiceImpl;
import ru.geekbrains.service.repr.ProductRepr;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
@Named
public class CartController implements Serializable {

    @EJB
    private CartService cartService;

    private final Logger logger = LoggerFactory.getLogger(CartController.class);

    public void add(ProductRepr product) {
        cartService.add(product);
    }

    public void delete(ProductRepr productRepr) {
        logger.info("delete " + productRepr.getId());
        cartService.remove(productRepr.getId());
    }

    public List<ProductRepr> findAll() {
        return cartService.findAll();
    }
}
