package com.nz.kiwi.view;

import com.nz.kiwi.enumeration.Sex;
import com.nz.kiwi.enumeration.Status;
import com.nz.kiwi.enumeration.Taxa;
import com.nz.kiwi.model.Bird;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * DTO for {@link Bird}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BirdCreateDto implements Serializable {
    @NotNull
    private String name;
    @NotNull
    private Status status;
    private Sex sex;
    @NotNull
    private Taxa taxa;
    private String comment;

}