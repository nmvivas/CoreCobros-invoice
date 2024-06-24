package com.banquito.cobros.invoice.controller;

import com.banquito.cobros.invoice.model.Invoice;
import com.banquito.cobros.invoice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice) {
        try {
            Invoice createdInvoice = service.createInvoice(invoice);
            return new ResponseEntity<>(createdInvoice, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
