package com.nz.kiwi.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PitDto {
    //@JsonProperty("taskId")
    private Long taskId;
    //@JsonProperty("code")
    private String code;
    //@JsonProperty("dateInserted")
    private LocalDate dateInserted;
    //@JsonProperty("comment")
    private String comment;
    //@JsonProperty("healthCheckId")
    private Long healthCheckId;


}
