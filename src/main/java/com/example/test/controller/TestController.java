package com.example.test.controller;

import com.example.test.model.TestModel;
import com.example.test.service.TestService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/test", produces = {"application/json"})
public class TestController {
    @Autowired
    private TestService service;

    @PostMapping("/report")
    public String printPdf(@RequestBody TestModel latarWaktu) throws JRException {

        return service.printPDF(latarWaktu);
    }
}
