package br.com.zup.casadocodigo.book.dto;

import br.com.zup.casadocodigo.author.entity.Author;
import br.com.zup.casadocodigo.book.entity.Book;
import br.com.zup.casadocodigo.category.entity.Category;
import br.com.zup.casadocodigo.shared.validator.annotation.FieldUnique;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class NewBookRequest {
    @NotEmpty
    @FieldUnique(message = "Title must be unique", domainClass = Book.class, fieldName = "title")
    private String title;
    @NotEmpty
    @Size(max = 500)
    private String resume;
    @NotEmpty
    private String summary;
    @NotNull
    @Min(20)
    private BigDecimal price;
    @NotNull
    @Min(100)
    private Integer numberPages;
    @NotEmpty
    @FieldUnique(message = "Title must be unique", domainClass = Book.class, fieldName = "isbn")
    private String isbn;
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate publicationDate;
    @NotNull
    private Long categoryId;
    @NotNull
    private Long authorId;

    public NewBookRequest(
            @NotEmpty String title,
            @NotEmpty @Size(max = 500) String resume,
            @NotEmpty String summary,
            @NotNull @Min(20) BigDecimal price,
            @NotNull @Min(100) Integer numberPages,
            @NotEmpty String isbn,
            @NotNull Long categoryId,
            @NotNull Long authorId) {
        this.title = title;
        this.resume = resume;
        this.summary = summary;
        this.price = price;
        this.numberPages = numberPages;
        this.isbn = isbn;
        this.categoryId = categoryId;
        this.authorId = authorId;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Book toModel(EntityManager manager) {
        @NotNull Author author = manager.find(Author.class, authorId);
        @NotNull Category category = manager.find(Category.class, categoryId);

        return new Book(title, resume, summary, price, numberPages, isbn, publicationDate, category, author);
    }
}
