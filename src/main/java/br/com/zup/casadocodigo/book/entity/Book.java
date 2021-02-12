package br.com.zup.casadocodigo.book.entity;

import br.com.zup.casadocodigo.author.entity.Author;
import br.com.zup.casadocodigo.category.entity.Category;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
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
    private String isbn;
    @NotNull
    @Future
    private LocalDate publicationDate;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @Deprecated
    public Book() {
    }

    public Book(@NotEmpty String title, @NotEmpty @Size(max = 500) String resume, @NotEmpty String summary, @NotNull @Min(20) BigDecimal price, @NotNull @Min(100) Integer numberPages, @NotEmpty String isbn, @NotNull @Future LocalDate publicationDate, Category category, Author author) {
        this.title = title;
        this.resume = resume;
        this.summary = summary;
        this.price = price;
        this.numberPages = numberPages;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.category = category;
        this.author = author;
    }

    public Long getId() {
        return id;
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

    public Category getCategory() {
        return category;
    }

    public Author getAuthor() {
        return author;
    }
}
