package io.travelers.platform.u20211c009.profiles.service;

import io.travelers.platform.u20211c009.profiles.domain.model.entity.Agency;
import io.travelers.platform.u20211c009.profiles.domain.persistence.AgencyRepository;
import io.travelers.platform.u20211c009.profiles.domain.service.AgencyService;
import io.travelers.platform.u20211c009.shared.exception.ResourceValidationException;
import jakarta.validation.ConstraintViolation;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import jakarta.validation.Validator;
@Service
public class AgencyServiceImpl implements AgencyService {

    private static final String ENTITY = "Agency";
    private final AgencyRepository agencyRepository;

    private final Validator validator;

    public AgencyServiceImpl(AgencyRepository agencyRepository, Validator validator) {
        this.agencyRepository = agencyRepository;
        this.validator = validator;
    }

    @Override
    public Agency create(Agency agency) {

        Set<ConstraintViolation<Agency>> violations = validator.validate(agency);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        Optional<Agency> agencyWithBusinessIdAndName = agencyRepository.findByBusinessIdAndName(agency.getBusinessId(), agency.getName());
        Optional<Agency> agencyWithLatitudeAndLongitude = agencyRepository.findByLatitudeAndLongitude(agency.getLatitude(), agency.getLongitude());
        Optional<Agency> agencyWithStreetAddress = agencyRepository.findByStreetAddress(agency.getStreetAddress());

        if(agencyWithBusinessIdAndName.isPresent())
            throw new ResourceValidationException(ENTITY,
                    "An Agency with the same business id and name already exists.");

        if(agencyWithLatitudeAndLongitude.isPresent())
            throw new ResourceValidationException(ENTITY,
                    "An Agency with the same latitude and longitude already exists.");

        if(agencyWithStreetAddress.isPresent())
            throw new ResourceValidationException(ENTITY,
                    "An Agency with the same street address already exists.");

        return agencyRepository.save(agency);
    }


}
