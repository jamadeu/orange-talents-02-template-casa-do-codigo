package br.com.zup.casadocodigo.book.dto;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ListAllBooksResponse {

    public List listAll(EntityManager manager) {
        Query query = manager.createQuery("select b.id, b.title from Book b");
        return query.getResultList();
    }

}
