package br.com.rafael.adopet.tutor.dto;

import br.com.rafael.adopet.tutor.entities.Tutor;
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
		private String nome;
		private String telefone;
		private String cidade;
		private String sobre;
		private String fotoDePerfil;
		private String email;
		private String senha;
}
