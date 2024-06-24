package com.banquito.cobros.invoice.service;

import com.banquito.cobros.invoice.model.Invoice;
import com.banquito.cobros.invoice.repository.InvoiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InvoiceService {
    private InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public List<Invoice> getInvoices(String identification) {
        return invoiceRepository.findByRecipientIdentification(identification);
    }
    
    @Transactional
    public Invoice createInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }
}
