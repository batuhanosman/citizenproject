package com.example.citizenproject.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CitizenFindByParametersRequest {
    private Boolean isCitizen;
    private String name;
    private Long childrenNumber;
    private Boolean hasDrivingLicense;

}
