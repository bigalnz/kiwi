package com.nz.kiwi.view;

import com.nz.kiwi.enumeration.Sex;
import com.nz.kiwi.enumeration.Status;
import com.nz.kiwi.enumeration.Taxa;
import com.nz.kiwi.model.Bird;
import lombok.Value;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Bird}
 */
@Value
public class BirdDto implements Serializable {
    String name;
    Status status;
    Sex sex;
}