package com.krgablo.moje_faktury.Entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String invoiceNumber;

    private int value;

    private LocalDate paymentDate;

    private String invoiceIssuer;

    private Enum invoiceStatus;

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

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getInvoiceIssuer() {
        return invoiceIssuer;
    }

    public void setInvoiceIssuer(String invoiceIssuer) {
        this.invoiceIssuer = invoiceIssuer;
    }

    public Enum getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(Enum invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }
}
