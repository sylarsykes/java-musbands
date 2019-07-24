module musbands.admin.musical.genre {
	exports org.sylrsykssoft.java.musbands.admin.musical.genre;
	exports org.sylrsykssoft.java.musbands.admin.musical.genre.configuration;
	exports org.sylrsykssoft.java.musbands.admin.musical.genre.controller;
	exports org.sylrsykssoft.java.musbands.admin.musical.genre.domain;
	exports org.sylrsykssoft.java.musbands.admin.musical.genre.exception;
	exports org.sylrsykssoft.java.musbands.admin.musical.genre.repository;
	exports org.sylrsykssoft.java.musbands.admin.musical.genre.resource;
	exports org.sylrsykssoft.java.musbands.admin.musical.genre.resource.assembler;
	exports org.sylrsykssoft.java.musbands.admin.musical.genre.service;

	requires coreapi.framework.api;
	requires coreapi.framework.database;
	requires coreapi.framework.library;
	requires coreapi.framework.service;
	requires coreapi.framework.web;
	requires com.fasterxml.jackson.core;
	requires com.fasterxml.jackson.databind;
	requires java.desktop;
	requires java.persistence;
	requires java.transaction;
	requires lombok;
	requires transitive modelmapper;
	requires musbands.admin.library;
	requires transitive slf4j.api;
	requires spring.beans;
	requires spring.boot;
	requires spring.boot.autoconfigure;
	requires spring.context;
	requires spring.data.commons;
	requires spring.data.jpa;
	requires spring.data.rest.core;
	requires transitive spring.hateoas;
	requires spring.web;
}