package com.krgablo.moje_faktury.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collection;

import static java.util.concurrent.TimeUnit.DAYS;

@Entity
@Table(name = "invoice")
public class Invoice  implements Comparable<Invoice>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String invoiceNumber;

    private int value;

    private LocalDate paymentDate;

    private String invoiceIssuer;

    private LocalDate today;

    private long daysToPay;

    @ManyToOne
    User user;

    private Enum invoiceStatus;

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
    public long getDaysToPay() {
        return daysToPay;
    }


    public void setDaysToPay(long daysToPay) {
        this.daysToPay = daysToPay;
    }
    public void restTime(LocalDate localDate) {
        daysToPay = ChronoUnit.DAYS.between(localDate, paymentDate);
    }

    @Override
    public int compareTo(Invoice o) {

        return getPaymentDate().compareTo(o.getPaymentDate());
    }

}
