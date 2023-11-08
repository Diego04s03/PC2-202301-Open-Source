package io.travelers.platform.u20211c009.profiles.domain.persistence;

import io.travelers.platform.u20211c009.profiles.domain.model.entity.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, Long> {

    Optional<Agency> findByStreetAddress(String streetAddress);
    Optional<Agency> findByLatitudeAndLongitude(Long latitude, Long longitude);
    Optional<Agency> findByBusinessIdAndName(Long businessId, String name);
}
