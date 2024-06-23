package com.banquito.cobros.invoice.controller;

import com.banquito.cobros.invoice.model.Invoice;
import com.banquito.cobros.invoice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService service;

    @GetMapping("/by-identification")
    public List<Invoice> getInvoicesByRecipientIdentification(@RequestParam String identification) {
        return service.getInvoices(identification);
    }
}
