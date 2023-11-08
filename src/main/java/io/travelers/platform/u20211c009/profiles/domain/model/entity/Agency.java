package io.travelers.platform.u20211c009.profiles.domain.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "agencies")
public class Agency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "business_id", nullable = false)
    Long businessId;

    @NotNull
    @NotBlank
    String name;

    @NotBlank
    @Column(name = "street_address", nullable = false)
    String streetAddress;

    Long latitude;

    Long longitude;
}
