package com.banquito.cobros.invoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banquito.cobros.invoice.model.InvoiceTaxDetail;

public interface InvoiceTaxDetailRepository extends JpaRepository<InvoiceTaxDetail,Long>{

}
