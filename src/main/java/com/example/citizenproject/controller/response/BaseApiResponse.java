package com.example.citizenproject.controller.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseApiResponse<T> {

    @Builder.Default
    private Integer code = 0;

    @Builder.Default
    private String message = "success";

    private T data;

}
