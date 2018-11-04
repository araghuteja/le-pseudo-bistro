package com.enigma.config;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.db.DataSourceFactory;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class BistroConfiguration extends Configuration {

    @JsonProperty("swagger")
    public SwaggerBundleConfiguration swaggerBundleConfiguration;

    @JsonProperty("keepalive")
    public String url;

    @Valid
    @NotNull
    @JsonProperty("database")
    private DataSourceFactory database = new DataSourceFactory();

    public DataSourceFactory getDataSourceFactory() {
        return database;
    }

}
