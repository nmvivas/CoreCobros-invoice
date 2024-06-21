package com.banquito.cobros.invoice.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "RECIPIENT")
public class Recipient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RECIPIENT_ID", nullable = false)
    private Long id;
    @Column(name = "INVOICE_ID", nullable = false)
    private Long invoiceId;
    @Column(name = "IDENTIFICATION_TYPE", length = 3, nullable = false)
    private String identificationType;
    @Column(name = "IDENTIFICATION", length = 20, nullable = false)
    private String identification;
    @Column(name = "LAST_NAME", length = 50)
    private String lastName;
    @Column(name = "FIRST_NAME", length = 50)
    private String firstName;
    @Column(name = "FULL_NAME", length = 100)
    private String fullName;
    @Column(name = "LEGAL_NAME", length = 100)
    private String legalName;
    @Column(name = "ADDRESS", length = 100, nullable = false)
    private String address;
    @Column(name = "PHONE", length = 15, nullable = false)
    private String phone;
    @Column(name = "EMAIL", length = 100, nullable = false)
    private String email;

    @OneToMany(mappedBy = "recipient")
    private List<Invoice> invoices;
    
    public Recipient(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Recipient other = (Recipient) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
}
