package br.com.zup.casadocodigo.repository;

import br.com.zup.casadocodigo.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
