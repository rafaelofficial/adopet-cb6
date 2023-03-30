package br.com.rafael.adopet.tutor.controllers;

import br.com.rafael.adopet.tutor.entities.Tutor;
import br.com.rafael.adopet.tutor.repository.TutorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/adopet/")
public class TutorController {

		final TutorRepository tutorRepository;

		public TutorController(TutorRepository tutorRepository) {
				this.tutorRepository = tutorRepository;
		}

		@GetMapping
		public List<Tutor> getTutor() {
				return tutorRepository.findAll();
		}

}
