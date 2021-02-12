package br.com.zup.casadocodigo.book.dto;

import br.com.zup.casadocodigo.author.dto.NewAuthorResponse;
import br.com.zup.casadocodigo.book.entity.Book;
import br.com.zup.casadocodigo.category.dto.NewCategoryResponse;

import java.math.BigDecimal;
import java.time.LocalDate;

public class NewBookResponse {

    private String title;
    private String resume;
    private String summary;
    private BigDecimal price;
    private Integer numberPages;
    private String isbn;
    private LocalDate publicationDate;
    private NewCategoryResponse category;
    private NewAuthorResponse author;

    public NewBookResponse(Book book) {
        this.title = book.getTitle();
        this.resume = book.getResume();
        this.summary = book.getSummary();
        this.price = book.getPrice();
        this.numberPages = book.getNumberPages();
        this.isbn = book.getIsbn();
        this.category = new NewCategoryResponse(book.getCategory());
        this.author = new NewAuthorResponse(book.getAuthor());
        this.publicationDate = book.getPublicationDate();
    }

    public String getTitle() {
        return title;
    }

    public String getResume() {
        return resume;
    }

    public String getSummary() {
        return summary;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getNumberPages() {
        return numberPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public NewCategoryResponse getCategory() {
        return category;
    }

    public NewAuthorResponse getAuthor() {
        return author;
    }
}
