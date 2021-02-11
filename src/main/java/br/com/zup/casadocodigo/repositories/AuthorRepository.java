package br.com.zup.casadocodigo.repositories;

import br.com.zup.casadocodigo.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
