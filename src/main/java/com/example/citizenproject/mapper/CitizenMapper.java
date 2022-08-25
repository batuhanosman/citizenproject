package com.example.citizenproject.mapper;

import com.example.citizenproject.controller.request.CreateCitizenRequest;
import com.example.citizenproject.controller.request.UpdateCitizenRequest;
import com.example.citizenproject.controller.response.CitizenResponse;
import com.example.citizenproject.entity.Citizen;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CitizenMapper {

    @Mapping(target = "children", source = "citizen", qualifiedByName = "citizenName")
    CitizenResponse map(Citizen citizen);

    List<CitizenResponse> map(List<Citizen> citizenList);

    Set<Citizen> createRequestToCitizen(Set<CreateCitizenRequest> request);

    Set<Citizen> updateRequestToCitizen(Set<UpdateCitizenRequest> request);

    @Named("citizenName")
    default Set<String> citizenName(Citizen citizen){
       return citizen.getChildren().stream().map(Citizen::getName).collect(Collectors.toSet());
    }
}
