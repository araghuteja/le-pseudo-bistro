package com.enigma;

import com.enigma.config.BistroConfiguration;
import com.enigma.controller.BistroController;
import com.enigma.keepalive.KeepAlive;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BistroApplication extends Application<BistroConfiguration> {

    private static final Logger LOGGER = LoggerFactory.getLogger(BistroApplication.class);
    private static String url = "";

    public static void main(final String[] args) throws Exception {
        new BistroApplication().run(args);

        // Adding logic to ping every 10 minutes after 7AM IST
        KeepAlive ka = new KeepAlive(url);
        ka.pingMe();
    }

    @Override
    public String getName() {
        return "Bistro";
    }

    @Override
    public void initialize(final Bootstrap<BistroConfiguration> bootstrap) {
//        bootstrap.addBundle(new AssetsBundle("/apidocs", "/apidocs", "index.html"));

        bootstrap.addBundle(new SwaggerBundle<BistroConfiguration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(BistroConfiguration sampleConfiguration) {
                // this would be the preferred way to set up swagger, you can also construct the object here programtically if you want
                return sampleConfiguration.swaggerBundleConfiguration;
            }
        });

    }

    @Override
    public void run(final BistroConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        LOGGER.info("Registering REST resources");
        environment.jersey().register(new BistroController());

        BistroApplication.url = configuration.url;
    }

}
