package com.banquito.cobros.invoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banquito.cobros.invoice.model.Recipient;

public interface RecipientRepository extends JpaRepository<Recipient, Long> {

}
