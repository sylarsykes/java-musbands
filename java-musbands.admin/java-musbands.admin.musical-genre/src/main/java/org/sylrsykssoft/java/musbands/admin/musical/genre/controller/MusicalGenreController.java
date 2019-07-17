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
import org.sylrsykssoft.java.musbands.admin.musical.genre.configuration.MusicalGenreConstants;
import org.sylrsykssoft.java.musbands.admin.musical.genre.domain.MusicalGenre;
import org.sylrsykssoft.java.musbands.admin.musical.genre.exception.MusicalGenreException;
import org.sylrsykssoft.java.musbands.admin.musical.genre.resource.MusicalGenreResource;
import org.sylrsykssoft.java.musbands.admin.musical.genre.service.MusicalGenreService;

import lombok.extern.slf4j.Slf4j;

/**
 * Rest Controller for Musical Genre API
 * 
 * @author juan.gonzalez.fernandez.jgf
 * 
 * @see https://restfulapi.net/http-methods/
 *
 */
@RestController(MusicalGenreConstants.CONTROLLER_NAME)
@RequestMapping(MusicalGenreConstants.CONTROLLER_REQUEST_MAPPING)
@Slf4j
public class MusicalGenreController extends BaseAdminController<MusicalGenreResource, MusicalGenre> {

	@Autowired
	private MusicalGenreService musicalGenreService;
	
	/**
	 * Get all musical genres
	 * 
	 * @return
	 * @throws NotFoundEntityException
	 */
	@Override
	@GetMapping
	public @ResponseBody List<MusicalGenreResource> findAll() throws NotFoundEntityException {
		LOGGER.info("MusicalGenreController::findAll");
		
		final List<MusicalGenreResource> result = musicalGenreService.findAll();
		if (result == null) {
			throw new NotFoundEntityException();
		}
		
		LOGGER.info("MusicalGenreController::findAll Result -> {}", result);

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
	@GetMapping(path = MusicalGenreConstants.CONTROLLER_GET_FIND_BY_NAME_MAPPING, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody MusicalGenreResource findByName(@PathVariable final String name) throws NotFoundEntityException {
		LOGGER.info("MusicalGenreController::findByName Finding a entry with name: {}", name);
		
		final Optional<MusicalGenreResource> result = musicalGenreService.findByName(name);
		
		LOGGER.info("MusicalGenreController::findByName Result -> {}", result.get());
		
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
	@GetMapping(path = MusicalGenreConstants.CONTROLLER_GET_FIND_BY_ID, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody MusicalGenreResource findOne(@PathVariable final Integer id) throws NotFoundEntityException {
		LOGGER.info("MusicalGenreController::findOne Finding a entry with id: {}", id);
		
		final Optional<MusicalGenreResource> result = musicalGenreService.findById(id);
		
		LOGGER.info("MusicalGenreController::findOne Result -> {}", result.get());
		
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
	@Override
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody MusicalGenreResource create(@Valid @RequestBody final MusicalGenreResource entity) {
		LOGGER.info("MusicalGenreController::update Creating a entry: {}", entity);
		
		final MusicalGenreResource result = musicalGenreService.save(entity);
		
		LOGGER.info("MusicalGenreController::update Result -> {}", result);
		
		return result;
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
	@Override
	@PutMapping(path = MusicalGenreConstants.CONTROLLER_PUT_UPDATE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody MusicalGenreResource update(@Valid @RequestBody final MusicalGenreResource entity, final @PathVariable Integer id) throws NotIdMismatchEntityException, NotFoundEntityException {
		LOGGER.info("MusicalGenreController::update Updating a entry with id: {}", id);
		
		if (ObjectUtils.notEqual(entity.getEntityId(), id)) {
			throw new NotIdMismatchEntityException();
		}
		
		final MusicalGenreResource result = musicalGenreService.save(entity); 
		
		LOGGER.info("MusicalGenreController::update Result -> {}", result);
		
		return result;
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
	@Override
	@DeleteMapping(path = MusicalGenreConstants.CONTROLLER_DELETE_DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable final Integer id) throws NotFoundEntityException, MusicalGenreException {
		LOGGER.info("MusicalGenreController::delete Deleting a entry with id: {}", id);
		
		try {
			musicalGenreService.deleteById(id);
		} catch (Exception e) {
			throw new MusicalGenreException(e);
		}
	}
	
}
