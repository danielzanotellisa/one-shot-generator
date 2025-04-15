package dev.zanotelli.One.Shot.Creator.repository;

import dev.zanotelli.One.Shot.Creator.model.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonagemRepository extends JpaRepository<Personagem,Long> {
}
