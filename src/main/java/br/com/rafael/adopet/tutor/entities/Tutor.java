package br.com.rafael.adopet.tutor.entities;

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
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private UUID id;

		private String nome;
		private String telefone;
		private String cidade;
		private String sobre;
		private String fotoDePerfil;
		private String email;
		private String senha;
}
