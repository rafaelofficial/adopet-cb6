package br.com.rafael.adopet.tutor.repository;

import br.com.rafael.adopet.tutor.entities.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, UUID> {

		Optional<Tutor> findByEmail(String email);

}
