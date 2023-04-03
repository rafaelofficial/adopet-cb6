package br.com.rafael.adopet.tutor.dto;

import br.com.rafael.adopet.tutor.domain.Tutor;
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

		public TutorDto(Tutor obj) {
				this.id = obj.getId();
				this.name = obj.getName();
				this.email = obj.getEmail();
				this.password = obj.getPassword();
				this.city = obj.getCity();
				this.phone = obj.getPhone();
				this.pictureProfileUrl = obj.getPictureProfileUrl();
				this.about = obj.getAbout();
		}
}
