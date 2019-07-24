module musbands.admin.function.member {
	exports org.sylrsykssoft.java.musbands.admin.function.member;
	exports org.sylrsykssoft.java.musbands.admin.function.member.configuration;
	exports org.sylrsykssoft.java.musbands.admin.function.member.controller;
	exports org.sylrsykssoft.java.musbands.admin.function.member.domain;
	exports org.sylrsykssoft.java.musbands.admin.function.member.exception;
	exports org.sylrsykssoft.java.musbands.admin.function.member.repository;
	exports org.sylrsykssoft.java.musbands.admin.function.member.resource;
	exports org.sylrsykssoft.java.musbands.admin.function.member.resource.assembler;
	exports org.sylrsykssoft.java.musbands.admin.function.member.service;

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