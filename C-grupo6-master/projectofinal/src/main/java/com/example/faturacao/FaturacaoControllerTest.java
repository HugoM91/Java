package com.example.faturacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/invoices")
public class FaturacaoControllerTest {

    @Autowired
    FaturacaoService faturacaoService;

    @PostMapping(value = "/pay")
    public String payInvoice (){

    return faturacaoService.payInvoice("bc61f391-05d4-4a13-bd1d-820a16df465f");
    }

}
