package org.validation.example.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.validation.example.dto.Dto;

import javax.validation.Valid;

@Service
@Validated
public class DtoService {

    public String handle(@Valid Dto dto){
        return "Ok";
    }
}
