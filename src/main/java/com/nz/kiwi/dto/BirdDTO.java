package com.nz.kiwi.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BirdDTO {

    private Long birdId;
    private Long healthCheckId;
    private String name;
    private String sex;
    private LocalDate catchDate;
    private String code;
    private Integer channel;

    public BirdDTO() {
    };

    public BirdDTO(Long birdId, Long healthCheckId, String name, String sex, LocalDate catchDate, String code, Integer channel) {
        this.birdId = birdId;
        this.healthCheckId = healthCheckId;
        this.name = name;
        this.sex = sex;
        this.catchDate = catchDate;
        this.code = code;
        this.channel = channel;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public LocalDate getCatchDate() {
        return catchDate;
    }

    public void setCatchDate(LocalDate catchDate) {
        this.catchDate = catchDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getBirdId() {
        return birdId;
    }

    public void setBirdId(Number birdId) {
        this.birdId = birdId.longValue();
    }

    public Long getHealthCheckId() {
        return healthCheckId;
    }

    public void setHealthCheckId(Number healthCheckId) {
        this.healthCheckId = healthCheckId.longValue();
    }
}
