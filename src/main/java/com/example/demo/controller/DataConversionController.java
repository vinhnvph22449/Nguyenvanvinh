package com.example.demo.controller;

import com.example.demo.DTO.DataConversionRequest;
import com.example.demo.DTO.DataConversionResponse;
import com.example.demo.convert.ConverterAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DataConversionController {
    @Autowired
    ConverterAdapter converter;

    @PostMapping("/convert")
    public ResponseEntity<?> convertData(@RequestBody DataConversionRequest request) {
        Object result;
        try {
            result = converter.convert(request);
        }catch (Exception exception){
            System.out.println(exception);
            return ResponseEntity.badRequest().body(new DataConversionResponse(exception.getMessage()));
        }

        DataConversionResponse response = new DataConversionResponse(result);
        return ResponseEntity.ok(response);
    }

}
