package ru.geekbrains.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.service.repr.ProductRepr;
import javax.ejb.Stateful;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Stateful
public class CartServiceImpl implements CartService {

    private final Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);

    private final Map< Long, ProductRepr> productMap = new ConcurrentHashMap<>();

    @Override
    public void add(ProductRepr productRepr) {
        productMap.put((long) productRepr.hashCode(), productRepr);
    }

    @Override
    public void remove(long id) {
        Iterator<Map.Entry<Long, ProductRepr>> iterator = productMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Long, ProductRepr> me =  iterator.next();
            if (me.getValue().getId().equals(id)) {
                productMap.remove(me.getKey());
                return;
            }
        }
    }

    @Override
    public List<ProductRepr> findAll() {
        return new ArrayList<>(productMap.values());
    }
}
