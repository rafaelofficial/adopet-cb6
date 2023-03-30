package br.com.rafael.adopet.tutor.entities;

import br.com.rafael.adopet.tutor.dto.TutorDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Tutor {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;

		private String nome;
		private String telefone;
		private String cidade;
		private String sobre;
		private String fotoDePerfil;
		private String email;
		private String senha;

		public TutorDto toTutorDto() {
				return TutorDto.builder()
						.id(this.id)
						.nome(this.nome)
						.cidade(this.cidade)
						.telefone(this.telefone)
						.sobre(this.sobre)
						.fotoDePerfil(this.fotoDePerfil)
						.email(this.email)
						.senha(this.senha)
						.build();
		}
}
