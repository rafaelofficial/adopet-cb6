package br.com.rafael.adopet.tutor.services;

import br.com.rafael.adopet.tutor.domain.Tutor;
import br.com.rafael.adopet.tutor.dto.TutorDto;
import br.com.rafael.adopet.tutor.exceptions.EntityAlreadyExistsException;
import br.com.rafael.adopet.tutor.exceptions.ResourceNotFoundException;
import br.com.rafael.adopet.tutor.repository.TutorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TutorService {

		private final TutorRepository tutorRepository;

		public TutorService(TutorRepository tutorRepository) {
				this.tutorRepository = tutorRepository;
		}

		public Tutor createTutor(TutorDto tutorDto) {
				var existingTutor = this.tutorRepository.findByEmail(tutorDto.getEmail());

				if (existingTutor.isPresent()) {
						throw new EntityAlreadyExistsException("Tutor already exists!");
				}

				Tutor tutor = Tutor.builder()
						.id(tutorDto.getId())
						.name(tutorDto.getName())
						.email(tutorDto.getEmail())
						.password(tutorDto.getPassword())
						.city(tutorDto.getCity())
						.phone(tutorDto.getPhone())
						.pictureProfileUrl(tutorDto.getPictureProfileUrl())
						.about(tutorDto.getAbout())
						.build();

				return tutorRepository.save(tutor);
		}

		public Tutor updateTutor(TutorDto tutorDto) {
				if (!this.tutorRepository.existsById(tutorDto.getId())) {
						throw new ResourceNotFoundException("Tutor not found");
				}

				Optional<Tutor> optionalTutor = this.tutorRepository.findById(tutorDto.getId())
						.map(updatedTutor -> {
								updatedTutor.setName(tutorDto.getName());
								updatedTutor.setEmail(tutorDto.getEmail());
								updatedTutor.setPassword(tutorDto.getPassword());
								updatedTutor.setPhone(tutorDto.getPhone());
								updatedTutor.setAbout(tutorDto.getAbout());
								updatedTutor.setPictureProfileUrl(tutorDto.getPictureProfileUrl());
								return updatedTutor;
						});

				return tutorRepository.save(optionalTutor.orElseThrow());
		}

		public List<Tutor> findAllTutor() {
				var isTutors = this.tutorRepository.findAll();
				if (isTutors.isEmpty()) {
						throw new ResourceNotFoundException("Tutor not found!");
				}

				return isTutors;
		}
}
