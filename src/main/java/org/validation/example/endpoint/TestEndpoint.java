package org.validation.example.endpoint;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.validation.example.annotation.MustBeValid;
import org.validation.example.annotation.MustBeValidValidator;
import org.validation.example.dto.Dto;
import org.validation.example.service.DtoService;

import javax.validation.Valid;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@RestController
@Validated
@RequiredArgsConstructor
public class TestEndpoint {

    private final DtoService dtoService;
    private final MustBeValidValidator mustBeValidValidator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        if(binder.getTarget().getClass().isAnnotationPresent(MustBeValid.class)){
            binder.setValidator(mustBeValidValidator);
        }
    }

    @PostMapping
    public String test1(@RequestBody @Valid Dto dto){
        return "Ok";
    }

    @GetMapping("/pathVar/{test}/{i}")
    public String testPathVar(@PathVariable @Size(min = 5) String test, @PathVariable @PositiveOrZero Integer i){
        return "Ok";
    }

    @PostMapping("/toService")
    public String testService(@RequestBody Dto dto){
        return dtoService.handle(dto);
    }

    @PostMapping("/init")
    public String init(@RequestBody @Validated Dto dto){
        return "Ok";
    }

}
