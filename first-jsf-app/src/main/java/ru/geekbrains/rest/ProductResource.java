package ru.geekbrains.rest;

import ru.geekbrains.service.repr.ProductRepr;

import javax.ejb.Local;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Local
@Path("/v1/product")
public interface ProductResource {

//    f. Получить все товары;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<ProductRepr> findAllWithCategoryFetch();

//    d. Получить товар по Id;
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    ProductRepr findById(@PathParam("id") long id);

//    a. Добавлять товар в БД;
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    void insert(ProductRepr productRepr);

//  изменить продукт
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    void update(ProductRepr productRepr);

//     b. Удалять товар из БД;
    @DELETE
    @Path("/{id}")
    void delete(@PathParam("id") Long id);

// e. Получить товар по имени;
    @GET
    @Path("/name{name}")
    @Produces(MediaType.APPLICATION_JSON)
    List<ProductRepr> findByName (@PathParam("name") String name);

//    g. Получить товары по Id категории.
    @GET
    @Path("/category{id}")
    @Produces(MediaType.APPLICATION_JSON)
    List<ProductRepr> findByCategoryId(@PathParam("id") long id);
}
