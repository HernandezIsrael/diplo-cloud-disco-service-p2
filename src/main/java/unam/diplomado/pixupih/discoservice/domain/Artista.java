package unam.diplomado.pixupih.discoservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "artistas")
public class Artista {

	@Id
	private String id;
	private String nombre;
}
