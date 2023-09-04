package com.nz.kiwi.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Imported;

@AllArgsConstructor
@NoArgsConstructor
//@ToString
@Imported
@Data
public class Test {

    public Long id;
    public String name;
    //@JsonFormat(pattern="yyyy-MM-dd HH:mm")
    //public LocalDateTime healthCheckDateTime;
    public HealthCheckDto healthCheckDto;
}
