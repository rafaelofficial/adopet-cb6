package br.com.rafael.adopet.tutor.controllers;


import br.com.rafael.adopet.tutor.domain.Tutor;
import br.com.rafael.adopet.tutor.dto.TutorDto;
import br.com.rafael.adopet.tutor.services.TutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/adopet/tutor")
public class TutorController {

		private final TutorService tutorService;

		public TutorController(TutorService tutorService) {
				this.tutorService = tutorService;
		}

		@PostMapping
		public ResponseEntity<TutorDto> createTutor(@RequestBody TutorDto newTutorDto) {
				var tutor = this.tutorService.createTutor(newTutorDto);
				return new ResponseEntity<>(tutor.toTutorDto(), HttpStatus.CREATED);
		}

		@PutMapping("/{id}")
		public ResponseEntity<TutorDto> updateTutor(@RequestBody TutorDto tutorDto, @PathVariable Long id) {
				tutorDto.setId(id);
				var updatedTutor = this.tutorService.updateTutor(tutorDto);
				return new ResponseEntity<>(updatedTutor.toTutorDto(), HttpStatus.NO_CONTENT);
		}

		@GetMapping
		public ResponseEntity<List<TutorDto>> findAllTutor() {
				List<Tutor> tutorList = this.tutorService.findAllTutor();
				List<TutorDto> tutorDtoList = tutorList.stream()
						.map(TutorDto::new)
						.collect(Collectors.toList());
				return ResponseEntity.ok().body(tutorDtoList);
		}
}
