package com.nz.kiwi.view;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nz.kiwi.model.HealthCheck;
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
//@AllArgsConstructor
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
        Point<G2D> location;
        //User holder;


        public HealthCheckDto(Long id, LocalDateTime catchDateTime, LocalDateTime releaseDateTime, Point<G2D> location) {
                this.id = id;
                this.catchDateTime = catchDateTime;
                this.releaseDateTime = releaseDateTime;
                this.location = location;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public LocalDateTime getCatchDateTime() {
                return catchDateTime;
        }

        public void setCatchDateTime(LocalDateTime catchDateTime) {
                this.catchDateTime = catchDateTime;
        }

        public LocalDateTime getReleaseDateTime() {
                return releaseDateTime;
        }

        public void setReleaseDateTime(LocalDateTime releaseDateTime) {
                this.releaseDateTime = releaseDateTime;
        }

        public Point<G2D> getLocation() {
                return location;
        }

        public void setLocation(Point<G2D> location) {
                this.location = location;
        }
}