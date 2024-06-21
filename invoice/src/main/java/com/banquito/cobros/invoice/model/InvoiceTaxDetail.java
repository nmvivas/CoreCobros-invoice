package com.banquito.cobros.invoice.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "INVOICE_TAX_DETAIL")
public class InvoiceTaxDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INVOICE_TAX_DETAIL_ID", nullable = false)
    private Long id;
    @Column(name = "INVOICE_ID", nullable = false)
    private Long invoiceId;
    @Column(name = "NAME", length = 50, nullable = false)
    private String name;
    @Column(name = "VALUE", precision = 17, scale = 2, nullable = false)
    private BigDecimal value;
    @Column(name = "PORCENTAGE", precision = 17, scale = 2, nullable = false)
    private BigDecimal porcentage;
    
    @ManyToOne
    @JoinColumn(name = "INVOICE_ID", nullable = false)
    private Invoice invoice;

    public InvoiceTaxDetail(Long id) {
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
        InvoiceTaxDetail other = (InvoiceTaxDetail) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
}
