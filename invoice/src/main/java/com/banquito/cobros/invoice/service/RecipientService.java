package com.banquito.cobros.invoice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.banquito.cobros.invoice.model.Recipient;
import com.banquito.cobros.invoice.repository.RecipientRepository;

@Service
public class RecipientService {
    private RecipientRepository recipientRepository;

    public RecipientService(RecipientRepository recipientRepository) {
        this.recipientRepository = recipientRepository;
    }

    public List<Recipient> getAllRecipients() {
        return recipientRepository.findAll();
    }
    
    public Recipient createRecipient(Recipient recipient) {
        recipient.generateFullName();
        return recipientRepository.save(recipient);
    }

}
