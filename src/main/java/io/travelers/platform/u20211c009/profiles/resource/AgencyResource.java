package io.travelers.platform.u20211c009.profiles.resource;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@With
public class AgencyResource {
    Long id;
    Long businessId;
    String name;
    String streetAddress;
    Long latitude;
    Long longitude;
}
