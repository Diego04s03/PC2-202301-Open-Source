package io.travelers.platform.u20211c009.profiles.api.rest;

import io.travelers.platform.u20211c009.profiles.domain.service.AgencyService;
import io.travelers.platform.u20211c009.profiles.mapping.AgencyMapper;
import io.travelers.platform.u20211c009.profiles.resource.AgencyResource;
import io.travelers.platform.u20211c009.profiles.resource.CreateAgencyResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/agencies")
public class AgenciesController {

    private final AgencyService agencyService;
    private final AgencyMapper mapper;

    public AgenciesController(AgencyService agencyService, AgencyMapper mapper) {
        this.agencyService = agencyService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<AgencyResource> createAgency(@RequestBody CreateAgencyResource resource) {
        return new ResponseEntity<>(mapper.toResource(agencyService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }
}
