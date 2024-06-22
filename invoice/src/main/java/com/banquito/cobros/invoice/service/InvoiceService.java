package com.banquito.cobros.invoice.service;

import com.banquito.cobros.invoice.model.Invoice;
import com.banquito.cobros.invoice.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public List<Invoice> getInvoices(String identification) {
        return invoiceRepository.findByRecipientIdentification(identification);
    }
}
