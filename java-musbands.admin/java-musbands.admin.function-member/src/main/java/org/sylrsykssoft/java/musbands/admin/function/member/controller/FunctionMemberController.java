package org.sylrsykssoft.java.musbands.admin.function.member.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.sylrsykssoft.coreapi.framework.database.exception.NotFoundEntityException;
import org.sylrsykssoft.coreapi.framework.database.exception.NotIdMismatchEntityException;
import org.sylrsykssoft.coreapi.framework.web.BaseAdminController;
import org.sylrsykssoft.java.musbands.admin.function.member.configuration.FunctionMemberConstants;
import org.sylrsykssoft.java.musbands.admin.function.member.domain.FunctionMember;
import org.sylrsykssoft.java.musbands.admin.function.member.exception.FunctionMemberException;
import org.sylrsykssoft.java.musbands.admin.function.member.resource.FunctionMemberResource;
import org.sylrsykssoft.java.musbands.admin.function.member.service.FunctionMemberService;

import lombok.extern.slf4j.Slf4j;

/**
 * Rest Controller for Function Member API
 * 
 * @author juan.gonzalez.fernandez.jgf
 * 
 * @see https://restfulapi.net/http-methods/
 *
 */
@RestController(FunctionMemberConstants.CONTROLLER_NAME)
@RequestMapping(FunctionMemberConstants.CONTROLLER_REQUEST_MAPPING)
@Slf4j
public class FunctionMemberController extends BaseAdminController<FunctionMemberResource, FunctionMember> {

	@Autowired
	private FunctionMemberService functionMemberService;

	/**
	 * Find one entry.
	 * 
	 * @param id Id
	 * 
	 * @example /admin/functionMembers/{id}]
	 * 
	 * @return T entry.
	 * 
	 * @throws NotFoundEntityException
	 */
	@GetMapping(path = FunctionMemberConstants.CONTROLLER_GET_FIND_BY_ID, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody FunctionMemberResource findById(@PathVariable final Integer id) throws NotFoundEntityException {
		LOGGER.info("FunctionMemberController::findOne Finding a entry with id: {}", id);
		
		final Optional<FunctionMemberResource> result = functionMemberService.findById(id);
		
		LOGGER.info("FunctionMemberController::findOne Result -> {}", result.get());
		
		return result.get();
	}
	
	/**
	 * Find by name.
	 * 
	 * @param name Value of attribute name.
	 * 
	 * @example /admin/functionMembers/name/{name}]
	 * 
	 * @return T entity.
	 * 
	 * @throws NotFoundEntityException
	 */
	@GetMapping(path = FunctionMemberConstants.CONTROLLER_GET_FIND_BY_NAME_MAPPING, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody FunctionMemberResource findByName(@PathVariable final String name) throws NotFoundEntityException {
		LOGGER.info("FunctionMemberController::findByName Finding a entry with name: {}", name);
		
		final Optional<FunctionMemberResource> result = functionMemberService.findByName(name);
		
		LOGGER.info("FunctionMemberController::findByName Result -> {}", result.get());
		
		return result.get();
	}

	/**
	 * Find by example
	 * 
	 * @param resource Entity to find.
	 * 
	 * @example /admin/functionMembers/find/example
	 * 
	 * @return T entity.
	 * 
	 * @throws NotFoundEntityException
	 */
	@PostMapping(path = FunctionMemberConstants.CONTROLLER_GET_FIND_BY_EXAMPLE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody FunctionMemberResource findOneByExample(@Valid @RequestBody final FunctionMemberResource resource) {
		LOGGER.info("FunctionMemberController::findOneByExample Finding a entry with example: {}", resource);
		
		Example<FunctionMemberResource> example = Example.of(resource, ExampleMatcher.matchingAll());
		
		final Optional<FunctionMemberResource> result = functionMemberService.findByExample(example);
		
		LOGGER.info("FunctionMemberController::findOneByExample Result -> {}", result.get());
		
		return result.get();
	}

	/**
	 * Get all function members
	 * 
	 * @example /admin/functionMembers
	 * 
	 * @return List<FunctionMemberResource> List of entries
	 * 
	 * @throws NotFoundEntityException
	 */
	@Override
	@GetMapping
	public @ResponseBody List<FunctionMemberResource> findAll() throws NotFoundEntityException {
		LOGGER.info("FunctionMemberController::findAll");
		
		final List<FunctionMemberResource> result = functionMemberService.findAll();
		if (result == null) {
			throw new NotFoundEntityException();
		}
		
		LOGGER.info("FunctionMemberController::findAll Result -> {}", result);

		return result;
	}
	
	/**
	 * Find all entries by example.
	 * 
	 * @param resource FunctionMemberResource object.
	 * 
	 * @example /admin/functionMembers/findAll/example
	 * 
	 * @return List<FunctionMemberResource> List of entries.
	 * 
	 * @throws NotFoundEntityException
	 */
	@PostMapping(path = FunctionMemberConstants.CONTROLLER_GET_FIND_ALL_BY_EXAMPLE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<FunctionMemberResource> findAllByExample(@RequestBody final FunctionMemberResource resource) throws NotFoundEntityException {
		LOGGER.info("FunctionMemberController:findAllByExample Finding all entries {}", resource);

		final Example<FunctionMemberResource> example = Example.of(resource, ExampleMatcher.matchingAll());
		
		final List<FunctionMemberResource> entities = functionMemberService.findAllByExample(example);
		if (entities == null) {
			throw new NotFoundEntityException();
		}

		LOGGER.info("FunctionMemberController:findAllByExample Found {} entries.", entities);

		return entities;
	}
	
	/**
	 * Find all entries by example.
	 * 
	 * @param resource FunctionMemberResource object
	 * @param direction Sorting direction values "asc" or "desc"
	 * @param properties List of properties
	 * 
	 * @example /admin/functionMembers/findAll/example/sort?direction="asc"&properties=["name", "description"]
	 * 
	 * @return List<FunctionMemberResource> entries.
	 * 
	 * @throws NotFoundEntityException
	 */
	@PostMapping(path = FunctionMemberConstants.CONTROLLER_GET_FIND_ALL_BY_EXAMPLE_SORTABLE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<FunctionMemberResource> findAllByExampleSortable(final @RequestBody FunctionMemberResource resource, 
			final @RequestParam String direction, final @RequestParam List<String> properties) throws NotFoundEntityException {
		LOGGER.info("FunctionMemberController:findAllByExampleSortable Finding all entries with example {} with direction {} and properties {}", resource, direction, properties);

		final Example<FunctionMemberResource> example = Example.of(resource, ExampleMatcher.matchingAll());
		
		final Direction sortDirection = Direction.fromString(direction);
		final Sort sort = new Sort(sortDirection, properties);
		
		final List<FunctionMemberResource> entities = functionMemberService.findAllByExampleSortable(example, sort);
		if (entities == null) {
			throw new NotFoundEntityException();
		}

		LOGGER.info("FunctionMemberController:findAllByExampleSortable Found {} entries.", entities);

		return entities;
	}
	
	/**
	 * Create entry.
	 * 
	 * @param entity Entity.
	 * 
	 * @return T entity.
	 */
	@Override
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody FunctionMemberResource create(@Valid @RequestBody final FunctionMemberResource entity) {
		LOGGER.info("FunctionMemberController::create Creating a entry: {}", entity);
		
		final FunctionMemberResource result = functionMemberService.save(entity);
		
		LOGGER.info("FunctionMemberController::create Result -> {}", result);
		
		return result;
	}

	/**
	 * Update entity.
	 * 
	 * @param entity Entity.
	 * @param id Id.
	 * 
	 * @return T entity.
	 * 
	 * @throws NotIdMismatchEntityException
	 * @throws NotFoundEntityException
	 */
	@Override
	@PutMapping(path = FunctionMemberConstants.CONTROLLER_PUT_UPDATE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody FunctionMemberResource update(@Valid @RequestBody final FunctionMemberResource entity, 
			final @PathVariable Integer id) throws NotIdMismatchEntityException, NotFoundEntityException {
		LOGGER.info("FunctionMemberController::update Updating a entry with id: {}", id);
		
		if (ObjectUtils.notEqual(entity.getEntityId(), id)) {
			throw new NotIdMismatchEntityException();
		}
		
		final FunctionMemberResource result = functionMemberService.save(entity); 
		
		LOGGER.info("FunctionMemberController::update Result -> {}", result);
		
		return result;
	}

	/**
	 * Delete entry.
	 * 
	 * @param id Id.
	 * 
	 * @throws NotFoundEntityException
	 * @throws AppException
	 */
	@Override
	@DeleteMapping(path = FunctionMemberConstants.CONTROLLER_DELETE_DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable final Integer id) throws NotFoundEntityException, FunctionMemberException {
		LOGGER.info("FunctionMemberController::delete Deleting a entry with id: {}", id);
		
		try {
			functionMemberService.deleteById(id);
		} catch (Exception e) {
			throw new FunctionMemberException(e);
		}
	}
	
}
