package br.com.rafael.adopet.tutor.controllers;


import br.com.rafael.adopet.tutor.domain.Tutor;
import br.com.rafael.adopet.tutor.dto.TutorDto;
import br.com.rafael.adopet.tutor.services.TutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/adopet/tutor")
public class TutorController {

		private final TutorService tutorService;

		public TutorController(TutorService tutorService) {
				this.tutorService = tutorService;
		}

		@PostMapping
		public ResponseEntity<TutorDto> createTutor(@RequestBody Tutor tutor) {
				var newTutor = this.tutorService.createTutor(tutor);
				return ResponseEntity.ok().body(newTutor.toTutorDto());
		}
}
