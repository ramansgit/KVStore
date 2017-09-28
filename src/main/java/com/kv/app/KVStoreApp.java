package com.kv.app;

import java.net.UnknownHostException;

import org.eclipse.jetty.server.session.SessionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kv.api.KeyValueApi;
import com.kv.service.KeyValueServiceImpl;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

/**
 * holds dropwizard configuration
 * 
 * @author ramans
 *
 */
public class KVStoreApp extends Application<KVStoreAppConfig> {
	private static final Logger LOGGER = LoggerFactory.getLogger(KVStoreApp.class);
	public static void main(String[] args) throws Exception {	
		new KVStoreApp().run(args);
	
	}

	/**
	 * initalize the swagger configuration
	 */
	@Override
	public void initialize(Bootstrap<KVStoreAppConfig> bootstrap) {

		bootstrap.addBundle(new SwaggerBundle<KVStoreAppConfig>() {
			@Override
			protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(KVStoreAppConfig configuration) {
				// this would be the preferred way to set up swagger, you can
				// also construct the object here programtically if you want
				return configuration.swaggerBundleConfiguration;
			}
		});
	}

	/**
	 * run method cvcvc
	 */
	@Override
	public void run(KVStoreAppConfig config, Environment env) throws UnknownHostException {
		env.jersey().register(new KeyValueApi());
		env.servlets().setSessionHandler(new SessionHandler());
		final KVStoreAppHealthCheck healthCheck = new KVStoreAppHealthCheck(config.getVersion());
		env.healthChecks().register("template", healthCheck);
		env.jersey().register(healthCheck);

	}
}