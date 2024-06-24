package com.banquito.cobros.invoice.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.banquito.cobros.invoice.model.Invoice;
import com.banquito.cobros.invoice.model.InvoiceTaxDetail;
import com.banquito.cobros.invoice.repository.InvoiceRepository;
import com.banquito.cobros.invoice.repository.InvoiceTaxDetailRepository;

@Service
public class InvoiceTaxDetailService {
    private InvoiceTaxDetailRepository invoiceTaxDetailRepository;
    private InvoiceRepository invoiceRepository;

    public InvoiceTaxDetailService(InvoiceTaxDetailRepository invoiceTaxDetailRepository,
            InvoiceRepository invoiceRepository) {
        this.invoiceTaxDetailRepository = invoiceTaxDetailRepository;
        this.invoiceRepository = invoiceRepository;
    }

    public InvoiceTaxDetail createInvoiceTaxDetail(InvoiceTaxDetail invoiceTaxDetail) {
        Optional<Invoice> invoice = invoiceRepository.findById(invoiceTaxDetail.getInvoiceId());
        if (invoice.isPresent()) {
            invoiceTaxDetail.setInvoice(invoice.get());
            invoiceTaxDetail.calculateValue();
            return invoiceTaxDetailRepository.save(invoiceTaxDetail);
        } else {
            throw new IllegalArgumentException("Invoice not found for id: " + invoiceTaxDetail.getInvoiceId());
        }
    }
}
