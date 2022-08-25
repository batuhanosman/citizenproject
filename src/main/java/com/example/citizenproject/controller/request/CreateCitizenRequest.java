package com.example.citizenproject.controller.request;

import com.example.citizenproject.entity.Citizen;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCitizenRequest {

    private Boolean isCitizen;
    private String name;
    private Set<CreateCitizenRequest> children;
    private Boolean hasDrivingLicense;

}
