package br.com.rafael.adopet.tutor.domain;

import br.com.rafael.adopet.tutor.dto.TutorDto;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
public class Tutor {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		private String name;
		private String email;
		private String password;
		private String phone;
		private String city;
		private String pictureProfileUrl;
		private String about;

		@CreationTimestamp
		private LocalDateTime createdAt;

		public TutorDto toTutorDto() {
				return TutorDto.builder()
						.id(this.id)
						.name(this.name)
						.email(this.email)
						.password(this.password)
						.phone(this.phone)
						.city(this.city)
						.pictureProfileUrl(this.pictureProfileUrl)
						.about(this.about)
						.createdAt(this.createdAt)
						.build();
		}
}
