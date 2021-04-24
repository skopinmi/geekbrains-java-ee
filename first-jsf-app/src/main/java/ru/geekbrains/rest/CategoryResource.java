package ru.geekbrains.rest;

import ru.geekbrains.persist.Category;
import ru.geekbrains.service.repr.CategoryRepr;

import javax.ejb.Local;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Local
@Path("/v1/category")
public interface CategoryResource {

//    тут были проблемы с сериализацией (параметр "products" из Category)
//    решил пока создав CategoryRepr.class
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<CategoryRepr> findAllCategory();

//    Получить категорию по id
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Category findById(@PathParam("id") long id);


//      c. Добавлять категорию товара;
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    void insert(Category category);

//   изменить категорию
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    void update(Category category);

//    удалить категорию
    @DELETE
    @Path("/{id}")
    void delete(@PathParam("id") long id);
}

