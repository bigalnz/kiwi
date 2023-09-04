package com.nz.kiwi.view;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nz.kiwi.model.HealthCheck;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link HealthCheck}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HealthCheckDto implements Serializable {

        Long id;
        //List<Task> tasks;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
        LocalDateTime catchDateTime;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
        LocalDateTime releaseDateTime;
//        @JsonSerialize(using = GeometrySerializer.class)
//        @JsonDeserialize(using = GeometryDeserializer.class)
//        @JsonIgnore
        Point<G2D> location;
        //User holder;



}