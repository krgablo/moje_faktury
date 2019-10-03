package com.krgablo.moje_faktury.Controller;

import com.krgablo.moje_faktury.Entity.Invoice;
import com.krgablo.moje_faktury.Entity.User;
import com.krgablo.moje_faktury.Repository.InvoiceRepository;
import com.krgablo.moje_faktury.Repository.UserReporitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvoiceController {
        @Autowired
    InvoiceRepository invoiceRepository;
        @Autowired
    UserReporitory userReporitory;




    @RequestMapping("/invoice_example")
    @ResponseBody
    public String invoiceExample() {
        return "Example registrstion";
    }

    @GetMapping("/invoices")
    List<Invoice> allInvoices() {
        return (List<Invoice>) invoiceRepository.findAll();
    }

    @GetMapping("/showAddTransaction")
    public Invoice showAddInvoices(@RequestParam("id") Integer id) {
        userReporitory.findById(id).orElse(null);
        new Invoice();

        return (Invoice) invoiceRepository.findAll();
    }

    @PostMapping(value = "/invoice/{id}")
    Invoice newInvoice(@RequestBody Invoice newInvoice, @PathVariable("id") int id) {
        User user = userReporitory.findById(id).orElse(null);
        user.addInvoiceToUser(newInvoice);
        return invoiceRepository.save(newInvoice);

    }

    @GetMapping("/invoices/{id}")
    Invoice findInvoiceById(@PathVariable int id) {

        return invoiceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invoice is not found"));
    }

    @PutMapping("/invoices/{id}")
    Invoice editInvoice(@RequestBody Invoice newInvoice, @PathVariable int id) {

        return invoiceRepository.findById(id)
                .map(invoice -> {
                    invoice.setInvoiceNumber(newInvoice.getInvoiceNumber());
                    invoice.setValue(newInvoice.getValue());
                    invoice.setPaymentDate(newInvoice.getPaymentDate());
                    invoice.setInvoiceIssuer(newInvoice.getInvoiceIssuer());
                    return invoiceRepository.save(invoice);
                })
                .orElseGet(() -> {
                    newInvoice.setId(id);
                    return invoiceRepository.save(newInvoice);
                });
    }

    @DeleteMapping("/invoices/{id}")
    void deleteInvoice(@PathVariable int id) {
        invoiceRepository.deleteById(id);
    }


}
