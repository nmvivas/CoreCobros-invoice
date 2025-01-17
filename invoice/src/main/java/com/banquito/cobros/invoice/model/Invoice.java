package com.banquito.cobros.invoice.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "INVOICE")
public class Invoice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INVOICE_ID", nullable = false)
    private Long id;

    @Column(name = "PAY_COMM_ID", nullable = false)
    private Long payComId;

    @Column(name = "RECIPIENT_ID", nullable = false)
    private Long recipientId;

    @Column(name = "SEQUENTIAL", length = 20, nullable = false)
    private String sequential;

    @Column(name = "AUTHORIZATION_NUMBER", length = 40, nullable = false)
    private String authorizationNumber;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE", nullable = false)
    private LocalDateTime date;

    @Column(name = "SUBTOTAL", scale = 17, precision = 2, nullable = false)
    private BigDecimal subtotal;

    @Column(name = "TOTAL", scale = 17, precision = 2, nullable = false)
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "RECIPIENT_ID", referencedColumnName = "RECIPIENT_ID", insertable = false, updatable = false)
    private Recipient recipient;

    public Invoice(Long id) {
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
        Invoice other = (Invoice) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
