package com.nz.kiwi.config;

import com.blazebit.persistence.integration.view.spring.EnableEntityViews;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableEntityViews("com.nz.kiwi.model")
@ComponentScan("com.nz.kiwi")
public class AppConfig {

/*    @Bean
    public Module geolatteModule() {
        CoordinateReferenceSystem<G2D> crs = WGS84;
        return new GeolatteGeomModule(WGS84);
    }
*/


/*    @Bean
    public ObjectMapper mapper() {
        CoordinateReferenceSystem<G2D> crs = WGS84;
        ObjectMapper gMapper = new ObjectMapper();
        gMapper.registerModule(new GeolatteGeomModule(crs));
        return gMapper;
    }*/
}

