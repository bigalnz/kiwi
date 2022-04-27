package com.nz.kiwi.dto;

import com.nz.kiwi.enumeration.*;
import com.nz.kiwi.model.TarsusDepth;
import com.nz.kiwi.model.TarsusLength;
import com.nz.kiwi.model.TarsusWidth;
import com.nz.kiwi.model.Weight;
import lombok.Data;
import org.locationtech.jts.geom.Point;

import javax.persistence.Lob;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class HealthCheckViewDTO {
    private Long id;
    private String name;
    private LocalDate catchDate;
    //private PointDTO point;
    private Double longitude;
    private Double latitude;
    private LocalTime catchTime;
    private LocalTime releaseTime;
    private String catchingComment;
    private List<WeightDTO> weights;
    private List<TarsusDepthDTO> tarsusDepths;
    private List<TarsusLengthDTO> tarsusLengths;
    private List<TarsusWidthDTO> tarsusWidths;

    private TransmitterOnHealthCheckDTO transmitter;

    private BodyLocation parasiteLocation;
    private Coverage parasiteCoverage;
    private BodyLocation liceLocation;
    private Coverage liceCoverage;
    private SkinDisorder skinDisorder;
    private Behaviour behaviour;
    private BodyCondition bodyCondition;
    private Capture capture;
    private String diseaseComment;

}
