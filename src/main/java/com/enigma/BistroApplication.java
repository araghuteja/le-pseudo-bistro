package com.enigma;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class BistroApplication extends Application<BistroConfiguration> {

    public static void main(final String[] args) throws Exception {
        new BistroApplication().run(args);
    }

    @Override
    public String getName() {
        return "Bistro";
    }

    @Override
    public void initialize(final Bootstrap<BistroConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final BistroConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
