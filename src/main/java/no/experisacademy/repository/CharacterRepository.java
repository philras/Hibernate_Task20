package no.experisacademy.repository;

import no.experisacademy.jpa.character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<character, Integer> {
}
