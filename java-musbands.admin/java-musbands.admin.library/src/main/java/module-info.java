module musbands.admin.library {
	exports org.sylrsykssoft.java.musbands.admin.library.configuration;
	exports org.sylrsykssoft.java.musbands.admin.library;

	requires spring.boot;
	requires spring.boot.autoconfigure;
	requires spring.context;
	requires spring.core;
}