package com.banquito.cobros.invoice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.banquito.cobros.invoice.model.InvoiceTaxDetail;
import com.banquito.cobros.invoice.service.InvoiceTaxDetailService;

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST,
    RequestMethod.PUT })
@RestController
@RequestMapping("/invoice-tax-details")
public class InvoiceTaxDetailController {
    private InvoiceTaxDetailService invoiceTaxDetailService;

    public InvoiceTaxDetailController(InvoiceTaxDetailService invoiceTaxDetailService) {
        this.invoiceTaxDetailService = invoiceTaxDetailService;
    }
    
    @PostMapping
    public ResponseEntity<?> createInvoiceTaxDetail(@RequestBody InvoiceTaxDetail invoiceTaxDetail) {
        try {
            InvoiceTaxDetail createdInvoiceTaxDetail = invoiceTaxDetailService.createInvoiceTaxDetail(invoiceTaxDetail);
            return new ResponseEntity<>(createdInvoiceTaxDetail, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
