package com.example.citizenproject.controller;

import com.example.citizenproject.controller.request.CitizenFindByParametersRequest;
import com.example.citizenproject.controller.request.CreateCitizenRequest;
import com.example.citizenproject.controller.request.UpdateCitizenRequest;
import com.example.citizenproject.controller.response.BaseApiResponse;
import com.example.citizenproject.controller.response.CitizenResponse;
import com.example.citizenproject.service.CitizenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/citizen")
@RequiredArgsConstructor
@Tag(name = "citizens", description = "Citizen Operation Endpoints")
public class CitizenController {

    private final CitizenService citizenService;

    @PostMapping
    @Operation(summary = "Create Citizen")
    public BaseApiResponse<CitizenResponse> createCitizen(@RequestBody CreateCitizenRequest request){
        return BaseApiResponse.<CitizenResponse>builder()
                .code(HttpStatus.CREATED.value())
                .data(citizenService.createCitizen(request))
                .build();
    }



    @PutMapping
    @Operation(summary = "Update Citizen")
    public BaseApiResponse<CitizenResponse> updateCitizen(@RequestBody UpdateCitizenRequest request){
        return BaseApiResponse.<CitizenResponse>builder()
                .code(HttpStatus.CREATED.value())
                .data(citizenService.updateCitizen(request))
                .build();
    }

    @GetMapping("/{citizenId}")
    @Operation(summary = "Get Citizen")
    public BaseApiResponse<CitizenResponse> getCitizen(@PathVariable Long citizenId) {
        return BaseApiResponse.<CitizenResponse>builder()
                .data(citizenService.getCitizen(citizenId))
                .build();
    }

    @PostMapping("/find-by-parameters")
    @Operation(summary = "Find citizens by parameters")
    public BaseApiResponse<List<CitizenResponse>> findCitizensByParameters(
            @RequestBody CitizenFindByParametersRequest request,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size){
        var pageReq = PageRequest.of(page, size);
        return BaseApiResponse.<List<CitizenResponse>>builder()
                .data(citizenService.findCitizensByParameters(request, pageReq))
                .build();
    }

}
