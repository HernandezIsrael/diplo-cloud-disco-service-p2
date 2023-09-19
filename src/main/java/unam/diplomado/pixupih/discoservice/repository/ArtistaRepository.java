package unam.diplomado.pixupih.discoservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import unam.diplomado.pixupih.discoservice.domain.Artista;

public interface ArtistaRepository extends MongoRepository<Artista, String>{

}
