package io.travelers.platform.u20211c009.profiles.resource;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateAgencyResource {

    @NotNull
    Long businessId;

    @NotNull
    @NotBlank
    String name;

    @NotBlank
    @NotNull
    String streetAddress;

    Long latitude;

    Long longitude;
}
