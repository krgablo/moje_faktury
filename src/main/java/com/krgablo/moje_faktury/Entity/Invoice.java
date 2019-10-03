package com.krgablo.moje_faktury.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String invoiceNumber;

    private int value;

    private Date paymentDate;

    private String invoiceIssuer;

    @ManyToOne
    User user;



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getInvoiceIssuer() {
        return invoiceIssuer;
    }

    public void setInvoiceIssuer(String invoiceIssuer) {
        this.invoiceIssuer = invoiceIssuer;
    }

}
