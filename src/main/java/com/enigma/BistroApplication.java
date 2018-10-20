package com.enigma;

import com.enigma.controller.BistroController;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BistroApplication extends Application<BistroConfiguration> {

    private static final Logger LOGGER = LoggerFactory.getLogger(BistroApplication.class);

    public static void main(final String[] args) throws Exception {
        new BistroApplication().run(args);
    }

    @Override
    public String getName() {
        return "Bistro";
    }

    @Override
    public void initialize(final Bootstrap<BistroConfiguration> bootstrap) {
    }

    @Override
    public void run(final BistroConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        LOGGER.info("Registering REST resources");
        environment.jersey().register(new BistroController());
    }

}
