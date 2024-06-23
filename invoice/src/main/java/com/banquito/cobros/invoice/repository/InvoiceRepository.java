package com.banquito.cobros.invoice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banquito.cobros.invoice.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    List<Invoice> findByRecipientIdentification(String identification);
}
