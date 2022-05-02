package com.example.hello.controller;

import com.example.hello.dto.PutRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutApiController {

    @PutMapping("/put")
    public PutRequestDto put(@RequestBody PutRequestDto requestDto) {

        System.out.println(requestDto);
        return requestDto;
    }

    @PutMapping("/put02/{userId}")
    public PutRequestDto put02(@RequestBody PutRequestDto requestDto, @PathVariable(name = "userId") Long id) {

        System.out.println(requestDto);
        return requestDto;
    }
}
