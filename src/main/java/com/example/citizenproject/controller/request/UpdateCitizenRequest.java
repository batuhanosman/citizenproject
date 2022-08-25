package com.example.citizenproject.controller.request;

import com.example.citizenproject.entity.Citizen;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCitizenRequest {

    private Long id;
    private Boolean isCitizen;
    private String name;
    private Set<UpdateCitizenRequest> children;
    private Boolean hasDrivingLicense;

}
