package com.example.citizenproject.controller.response;

import com.example.citizenproject.entity.Citizen;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CitizenResponse {

    private Long id;

    private Boolean isCitizen;

    private String name;

    private Set<String> children;

    private Boolean hasDrivingLicense;

}
