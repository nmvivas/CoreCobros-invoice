package com.banquito.cobros.invoice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.cobros.invoice.model.InvoiceTaxDetail;
import com.banquito.cobros.invoice.service.InvoiceTaxDetailService;

@RestController
@RequestMapping("/invoice-tax-details")
public class InvoiceTaxDetailController {
    private InvoiceTaxDetailService invoiceTaxDetailService;

    public InvoiceTaxDetailController(InvoiceTaxDetailService invoiceTaxDetailService) {
        this.invoiceTaxDetailService = invoiceTaxDetailService;
    }
    
    @PostMapping
    public ResponseEntity<InvoiceTaxDetail> createInvoiceTaxDetail(@RequestBody InvoiceTaxDetail invoiceTaxDetail) {
        try {
            InvoiceTaxDetail createdInvoiceTaxDetail = invoiceTaxDetailService.createInvoiceTaxDetail(invoiceTaxDetail);
            return new ResponseEntity<>(createdInvoiceTaxDetail, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
