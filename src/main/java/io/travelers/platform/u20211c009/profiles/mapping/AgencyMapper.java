package io.travelers.platform.u20211c009.profiles.mapping;

import io.travelers.platform.u20211c009.profiles.domain.model.entity.Agency;
import io.travelers.platform.u20211c009.profiles.resource.AgencyResource;
import io.travelers.platform.u20211c009.profiles.resource.CreateAgencyResource;
import io.travelers.platform.u20211c009.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class AgencyMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public AgencyResource toResource(Agency model) {
        return mapper.map(model, AgencyResource.class);
    }

    public Agency toModel(CreateAgencyResource resource) {
        return mapper.map(resource, Agency.class);
    }

}
