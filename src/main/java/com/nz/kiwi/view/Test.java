package com.nz.kiwi.view;

import lombok.*;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

import java.io.Serializable;


@Data
@AllArgsConstructor
public class Test implements Serializable {

    public Long id;
    public Point<G2D> location;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Point<G2D> getLocation() {
        return location;
    }

    public void setLocation(Point<G2D> location) {
        this.location = location;
    }
}
