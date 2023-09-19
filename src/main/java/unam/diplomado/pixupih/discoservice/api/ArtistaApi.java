package unam.diplomado.pixupih.discoservice.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import unam.diplomado.pixupih.discoservice.domain.Artista;

@RequestMapping(path = "api/artistas/", produces = "application/json")
@CrossOrigin(origins = "*")
@Tag(name="artista", description="API del recurso Artista")
public interface ArtistaApi {
	
	/***************** Mètodos GET *****************/
	
	@Operation(summary = "Obtiene el listado completo de Artistas")
	@ApiResponses(
			value = {
					@ApiResponse(
							responseCode = "200",
							description = "Se ha completado la operaciòn con èxito.",
							content = {
									@Content(
											mediaType = "application/json",
											schema = @Schema(implementation = Artista.class)
											)
									}
							),
					}
			)
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	Iterable<Artista> obtenerArtistas();
	
	//
	
	@Operation(summary = "Devuelve el artista asociado al ID indicado en el PATH.")
	@ApiResponses(
			value = {
				@ApiResponse(
						responseCode = "200",
						description = "Se ha completado la acciòn correctamente.",
						content = @Content(
								mediaType = "application/json",
								schema = @Schema(implementation = Artista.class)
								)
						),
				@ApiResponse(
						responseCode = "404",
						description = "No existe un Artista con el ID proporcionado.",
						content = @Content
						)
					}
			)
	@GetMapping("{id}")
	ResponseEntity<Artista> obtenerArtistaById(@PathVariable("id") String id);
	
	/***************** Mètodos POST *****************/
	
	@Operation(summary = "Agregar Artista especificando ùnicamente su nombre")
	@ApiResponses(
	    value = {
	        @ApiResponse(
	            responseCode = "201",
	            description = "Artista creado correctamente.",
	            content = {
	                @Content(
	                    mediaType = "application/json",
	                    schema = @Schema(implementation = Artista.class)
	                )
	            }
	        ),
	    }
	)
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	Artista crearArtista(@RequestBody Artista nuevo);
	
	/***************** Mètodos PUT *****************/
	
	@Operation(summary = "Actualiza el nombre del Artista con el ID especificado en el PATH.")
	@ApiResponses(
			value = {
			@ApiResponse(
					responseCode = "200",
					description = "Se ha actualizado la informaciòn correctamente.",
					content = {
							@Content(
									mediaType = "application/json",
									schema = @Schema(implementation = Artista.class)
									)
							}
					),
			@ApiResponse(
					responseCode = "404",
					description = "No se encontrò un Artista con el ID especificado.",
					content = @Content
					)
			}
	)
	@PutMapping(path = "{id}", consumes = "application/json")
	public ResponseEntity<Artista> actualizarArtista(@PathVariable("id") String id, @RequestBody Artista nuevo);
	
	/***************** Mètodos DELETE *****************/
	
	@Operation(summary = "Elimina al Artista con el ID especificado en el PATH.")
	@ApiResponses(
			value = {
				@ApiResponse(
						responseCode = "204",
						description = "Operaciòn de borrado completada (No valida la existencia).",
						content = @Content
						)	
				}
		)
	@DeleteMapping("{id}")
	public void borrarArtistaPorId(@PathVariable("id") String id);

}
