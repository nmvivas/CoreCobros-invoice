package com.banquito.cobros.invoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banquito.cobros.invoice.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice,Long>{

}
