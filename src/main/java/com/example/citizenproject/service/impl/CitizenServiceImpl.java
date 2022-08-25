package com.example.citizenproject.service.impl;

import com.example.citizenproject.controller.request.CitizenFindByParametersRequest;
import com.example.citizenproject.controller.request.CreateCitizenRequest;
import com.example.citizenproject.controller.request.UpdateCitizenRequest;
import com.example.citizenproject.controller.response.CitizenResponse;
import com.example.citizenproject.entity.Citizen;
import com.example.citizenproject.entity.specification.CitizenSpecification;
import com.example.citizenproject.exception.CitizenEntityNotFoundException;
import com.example.citizenproject.mapper.CitizenMapper;
import com.example.citizenproject.repository.CitizenRepository;
import com.example.citizenproject.service.CitizenService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CitizenServiceImpl implements CitizenService {

    private final CitizenRepository citizenRepository;

    private final CitizenMapper citizenMapper;

    @Override
    public CitizenResponse createCitizen(CreateCitizenRequest request) {

        var citizen = Citizen.builder()
                .isCitizen(request.getIsCitizen())
                .name(request.getName())
                .children(citizenMapper.createRequestToCitizen(request.getChildren()))
                .hasDrivingLicense(request.getHasDrivingLicense())
                .build();

        citizenRepository.save(citizen);



        return citizenMapper.map(citizen);
    }

    @Override
    public CitizenResponse updateCitizen(UpdateCitizenRequest request) {
        var citizen = citizenRepository.findById(request.getId()).orElseThrow(() -> new CitizenEntityNotFoundException(request.getId()));

        citizen.setIsCitizen(request.getIsCitizen());
        citizen.setChildren(citizenMapper.updateRequestToCitizen(request.getChildren()));
        citizen.setHasDrivingLicense(request.getHasDrivingLicense());
        citizen.setName(request.getName());
        citizenRepository.save(citizen);

        return citizenMapper.map(citizen);
    }

    @Override
    public CitizenResponse getCitizen(Long id) {
        var citizen = citizenRepository.findById(id).orElseThrow(() -> new CitizenEntityNotFoundException(id));

        return citizenMapper.map(citizen);
    }

    @Override
    public List<CitizenResponse> findCitizensByParameters(CitizenFindByParametersRequest request, PageRequest pageReq) {
        Specification<Citizen> specification = new CitizenSpecification(request);
        var citizenList = citizenRepository.findAll(specification, pageReq);
        return citizenMapper.map(citizenList.getContent());
    }
}
