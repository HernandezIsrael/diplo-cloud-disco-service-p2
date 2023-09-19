package unam.diplomado.pixupih.discoservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unam.diplomado.pixupih.discoservice.domain.Artista;
import unam.diplomado.pixupih.discoservice.repository.ArtistaRepository;

@Service
public class ArtistaServiceImpl implements ArtistaService{
	
	@Autowired
	private ArtistaRepository artistaDataManager;

	// AGREGAMOS EL CUERPO DE NUESTRA FUNCIÒN "ACTUALIZAR ARTISTA" ESPECIFICADA EN LA CAPA DE SERVICIO
	
	@Override
	public Artista actualizarArtista(String id, Artista nuevo) {
		
		Optional<Artista> actual = artistaDataManager.findById(id);
		
		if(actual.isPresent()) {
			
			Artista actualizado = actual.get();
			actualizado.setNombre(nuevo.getNombre());
			artistaDataManager.save(actualizado);
			return actualizado;
			
		}
		
		return null;
	}

}
