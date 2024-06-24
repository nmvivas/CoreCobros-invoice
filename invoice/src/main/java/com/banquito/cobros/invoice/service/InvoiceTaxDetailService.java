package com.banquito.cobros.invoice.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.banquito.cobros.invoice.model.Invoice;
import com.banquito.cobros.invoice.model.InvoiceTaxDetail;
import com.banquito.cobros.invoice.repository.InvoiceRepository;
import com.banquito.cobros.invoice.repository.InvoiceTaxDetailRepository;

import jakarta.transaction.Transactional;

@Service
public class InvoiceTaxDetailService {
    private InvoiceTaxDetailRepository invoiceTaxDetailRepository;
    private InvoiceRepository invoiceRepository;

    public InvoiceTaxDetailService(InvoiceTaxDetailRepository invoiceTaxDetailRepository,
            InvoiceRepository invoiceRepository) {
        this.invoiceTaxDetailRepository = invoiceTaxDetailRepository;
        this.invoiceRepository = invoiceRepository;
    }

    @Transactional
    public InvoiceTaxDetail createInvoiceTaxDetail(InvoiceTaxDetail invoiceTaxDetail) {
        if (invoiceTaxDetail.getInvoice() == null || invoiceTaxDetail.getInvoice().getId() == null) {
            throw new IllegalArgumentException("Invoice or Invoice ID cannot be null");
        }

        Optional<Invoice> invoiceOpt = invoiceRepository.findById(invoiceTaxDetail.getInvoice().getId());
        if (invoiceOpt.isPresent()) {
            Invoice invoice = invoiceOpt.get();
            invoiceTaxDetail.setInvoice(invoice);
            invoiceTaxDetail.setInvoiceId(invoice.getId()); // Asignar explícitamente invoiceId
            invoiceTaxDetail.calculateValue(); // Aquí se utiliza el campo 'total' del objeto 'Invoice'
            return invoiceTaxDetailRepository.save(invoiceTaxDetail);
        } else {
            throw new IllegalArgumentException("Invoice not found for id: " + invoiceTaxDetail.getInvoice().getId());
        }
    }
}
