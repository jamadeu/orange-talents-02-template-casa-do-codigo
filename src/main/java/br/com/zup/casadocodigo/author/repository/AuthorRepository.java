package br.com.zup.casadocodigo.author.repository;

import br.com.zup.casadocodigo.author.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Boolean existsAuthorByEmail(String email);
}
