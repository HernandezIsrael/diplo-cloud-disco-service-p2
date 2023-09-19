package unam.diplomado.pixupih.discoservice.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import unam.diplomado.pixupih.discoservice.domain.Artista;
import unam.diplomado.pixupih.discoservice.repository.ArtistaRepository;
import unam.diplomado.pixupih.discoservice.service.ArtistaService;

@RestController
@RequestMapping(path = "artistas")
public class ArtistaController implements ArtistaApi {
	
	@Autowired
	private ArtistaRepository artistaDataManager;
	@Autowired
	private ArtistaService aService;
	
	/***************** Mètodos GET *****************/
	
	@GetMapping
	public Iterable<Artista> obtenerArtistas(){
		return artistaDataManager.findAll();
	}
	
	//
	
	@GetMapping("{id}")
	public ResponseEntity<Artista> obtenerArtistaById(@PathVariable("id") String id){
		
		Optional<Artista> porID = artistaDataManager.findById(id);
		if(porID.isPresent()) {
			return new ResponseEntity<Artista>(porID.get(), HttpStatus.OK);
		}
		
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		
	}
	
	/***************** Mètodos POST *****************/
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Artista crearArtista(@RequestBody Artista nuevo) {
		Artista saved = artistaDataManager.save(nuevo);
		return saved;
	}
	
	/***************** Mètodos PUT *****************/
	
	@PutMapping(path = "{id}", consumes = "application/json")
	public ResponseEntity<Artista> actualizarArtista(@PathVariable("id") String id, @RequestBody Artista nuevo) {
		
		Artista actualizado = aService.actualizarArtista(id, nuevo);
		
		if(actualizado != null) {
			
			return new ResponseEntity<Artista>(actualizado, HttpStatus.OK);
			
		}
		
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		
	}
	
	/***************** Mètodos DELETE *****************/
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void borrarArtistaPorId(@PathVariable("id") String id){
		
		artistaDataManager.deleteById(id);
		
	}

}
