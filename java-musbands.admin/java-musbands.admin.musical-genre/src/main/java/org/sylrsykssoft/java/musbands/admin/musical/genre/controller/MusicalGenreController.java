package org.sylrsykssoft.java.musbands.admin.musical.genre.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.sylrsykssoft.coreapi.framework.database.exception.NotFoundEntityException;
import org.sylrsykssoft.coreapi.framework.database.exception.NotIdMismatchEntityException;
import org.sylrsykssoft.coreapi.framework.web.BaseAdminController;
import org.sylrsykssoft.java.musbands.admin.musical.genre.domain.MusicalGenre;
import org.sylrsykssoft.java.musbands.admin.musical.genre.exception.MusicalGenreException;
import org.sylrsykssoft.java.musbands.admin.musical.genre.resource.MusicalGenreResource;
import org.sylrsykssoft.java.musbands.admin.musical.genre.service.MusicalGenreService;

/**
 * Rest Controller for Musical Genre API
 * 
 * @author juan.gonzalez.fernandez.jgf
 * 
 * @see https://restfulapi.net/http-methods/
 *
 */
@RestController
@RequestMapping("/admin/musicalGenres")
public class MusicalGenreController extends BaseAdminController<MusicalGenreResource, MusicalGenre> {

	@Autowired
	private MusicalGenreService musicalGenreService;
	
	/**
	 * Get all musical genres
	 * 
	 * @return
	 * @throws NotFoundEntityException
	 */
	@GetMapping
	public @ResponseBody List<MusicalGenreResource> findAll() throws NotFoundEntityException {
		final List<MusicalGenreResource> result = musicalGenreService.findAll();
		if (result == null) {
			throw new NotFoundEntityException();
		}

		return result;
	}
	
	/**
	 * Find by name.
	 * 
	 * @param name
	 *            Value of attribute name.
	 * 
	 * @return T entity.
	 * 
	 * @throws NotFoundEntityException
	 */
	@GetMapping(path = "/name/{name}")
	public @ResponseBody MusicalGenreResource findByName(@PathVariable final String name) throws NotFoundEntityException {
		final Optional<MusicalGenreResource> result = musicalGenreService.findByName(name);
		return result.get();
	}

	/**
	 * Find one entry.
	 * 
	 * @param id
	 *            Id
	 * 
	 * @return T entry.
	 * 
	 * @throws NotFoundEntityException
	 */
	@GetMapping("/{id}")
	public @ResponseBody MusicalGenreResource findOne(@PathVariable final Integer id) throws NotFoundEntityException {
		final Optional<MusicalGenreResource> result = musicalGenreService.findById(id);
		return result.get();
	}

	/**
	 * Create entry.
	 * 
	 * @param entity
	 *            Entity.
	 * 
	 * @return T entity.
	 */
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody MusicalGenreResource create(@Valid @RequestBody final MusicalGenreResource entity) {
		return musicalGenreService.save(entity);
	}

	/**
	 * Update entity.
	 * 
	 * @param entity
	 *            Entity.
	 * @param id
	 *            Id.
	 * 
	 * @return T entity.
	 * 
	 * @throws NotIdMismatchEntityException
	 * @throws NotFoundEntityException
	 */
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody MusicalGenreResource update(@Valid @RequestBody final MusicalGenreResource entity, final @PathVariable Integer id)
			throws NotIdMismatchEntityException, NotFoundEntityException {

		if (ObjectUtils.notEqual(entity.getEntityId(), id)) {
			throw new NotIdMismatchEntityException();
		}
		
		return musicalGenreService.save(entity);
	}

	/**
	 * Delete entry.
	 * 
	 * @param id
	 *            Id.
	 * 
	 * @throws NotFoundEntityException
	 * @throws AppException
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable final Integer id) throws NotFoundEntityException, MusicalGenreException {
		try {
			musicalGenreService.deleteById(id);
		} catch (Exception e) {
			throw new MusicalGenreException();
		}
	}
	
}
