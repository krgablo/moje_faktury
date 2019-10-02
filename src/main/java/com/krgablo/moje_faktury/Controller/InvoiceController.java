package com.krgablo.moje_faktury.Controller;

import com.krgablo.moje_faktury.Repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class InvoiceController {
    @Autowired
    InvoiceRepository invoiceRepository;
}
