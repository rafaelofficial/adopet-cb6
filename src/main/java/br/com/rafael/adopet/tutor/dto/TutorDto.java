package br.com.rafael.adopet.tutor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class TutorDto {
		private Long id;
		private String name;
		private String email;
		private String password;
		private String phone;
		private String city;
		private String pictureProfileUrl;
		private String about;
}
