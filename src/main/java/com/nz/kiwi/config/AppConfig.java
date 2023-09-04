package com.nz.kiwi.config;

import com.blazebit.persistence.integration.view.spring.EnableEntityViews;
import com.blazebit.persistence.spring.data.repository.config.EnableBlazeRepositories;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Geometry;
import org.geolatte.geom.Point;
import org.geolatte.geom.Simple;
import org.geolatte.geom.codec.db.oracle.Settings;
import org.geolatte.geom.crs.CoordinateReferenceSystem;
import org.geolatte.geom.crs.CoordinateReferenceSystems;
import org.geolatte.geom.json.GeolatteGeomModule;
import org.geolatte.geom.json.GeometryDeserializer;
import org.geolatte.geom.json.GeometrySerializer;
import org.mapstruct.BeanMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static org.geolatte.geom.crs.CoordinateReferenceSystems.WGS84;

@Configuration
@EnableEntityViews("com.nz.kiwi.model")
@ComponentScan("com.nz.kiwi")
public class AppConfig {
    @Bean
    public ObjectMapper mapper() {
        CoordinateReferenceSystem<G2D> crs = WGS84;
        ObjectMapper gMapper = new ObjectMapper();
        gMapper.registerModule(new GeolatteGeomModule(crs));
        return gMapper;
    }
}

