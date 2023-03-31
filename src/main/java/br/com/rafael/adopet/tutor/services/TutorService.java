package br.com.rafael.adopet.tutor.services;

import br.com.rafael.adopet.tutor.domain.Tutor;
import br.com.rafael.adopet.tutor.exceptions.EntityAlreadyExistsException;
import br.com.rafael.adopet.tutor.repository.TutorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TutorService {

		private final TutorRepository tutorRepository;

		public TutorService(TutorRepository tutorRepository) {
				this.tutorRepository = tutorRepository;
		}

		public Tutor createTutor(Tutor tutor) {
				if (this.tutorRepository.findByEmail(tutor.getEmail()).isPresent()) {
						throw new EntityAlreadyExistsException("Tutor already exists!");
				}

				return tutorRepository.save(tutor);
		}
}
