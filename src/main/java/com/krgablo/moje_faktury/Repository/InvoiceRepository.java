package com.krgablo.moje_faktury.Repository;

import com.krgablo.moje_faktury.Entity.Invoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Integer> {
}
