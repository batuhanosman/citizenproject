package com.example.citizenproject.service;

import com.example.citizenproject.controller.request.CitizenFindByParametersRequest;
import com.example.citizenproject.controller.request.CreateCitizenRequest;
import com.example.citizenproject.controller.request.UpdateCitizenRequest;
import com.example.citizenproject.controller.response.CitizenResponse;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface CitizenService {

    CitizenResponse createCitizen(CreateCitizenRequest request);

    CitizenResponse updateCitizen(UpdateCitizenRequest request);

    CitizenResponse getCitizen(Long id);

    List<CitizenResponse> findCitizensByParameters(CitizenFindByParametersRequest request, PageRequest pageReq);
}
