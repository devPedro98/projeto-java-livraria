package br.com.livrariaasafe.model.book;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.livrariaasafe.util.JPAUtil;

public class BookDAO {

    private final EntityManager em;

    public BookDAO() {
        this.em = JPAUtil.getEntityManager();
    }

    public void register(Book book) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(book);
        tx.commit();
    }

    public List<Book> readAllBooks() {
        String jpql = "SELECT p FROM Book p";
        return em.createQuery(jpql, Book.class).getResultList();
    }

    public Book selectId(Long id) {
        return em.find(Book.class, id);
    }
    
    public void updateBook(Book book) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(book);
        tx.commit();
    }
    
    public void deleteBook(Book book) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        book = em.find(Book.class, book.getId());
        em.remove(book);
        tx.commit();
    }

    public void closeEntityManager() {
        em.close();
    }
}
