package com.nz.kiwi.view;

import com.nz.kiwi.model.HealthCheck;
import lombok.*;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import java.io.Serializable;


/**
 * DTO for {@link HealthCheck}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HealthCheckDto implements Serializable {

        Long id;
        Point<G2D> location;

}