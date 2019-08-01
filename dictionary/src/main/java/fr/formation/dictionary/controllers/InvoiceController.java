package fr.formation.dictionary.controllers;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.dictionary.business.Invoice;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @GetMapping("/{id}")
    public Invoice getOne(@PathVariable("id") Long id) {
	LocalDate date = LocalDate.of(1995, 9, 25);
	Invoice invoice = new Invoice("A01", date, 500);
	invoice.setPaid(true);
	invoice.setId(id);
	return invoice;
    }

    @GetMapping()
    public ArrayList<Invoice> getAll(@RequestParam("size") int size,
	    @RequestParam("page") int page) {
	System.out.println("size=" + size + ", page=" + page);
	ArrayList<Invoice> invoices = new ArrayList<>();
	LocalDate date = LocalDate.now();
	Invoice invoice1 = new Invoice("I01", date, 5.50);
	invoices.add(invoice1);
	Invoice invoice2 = new Invoice("I02", date, 8.50);
	invoices.add(invoice2);
	return invoices;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
	System.out.println("Deleting invoice with id " + id);
    }

    @PostMapping()
    public void create(@RequestBody @Valid Invoice invoice) {
	System.out.println(invoice);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id,
	    @RequestBody Invoice invoice) {
	System.out.println(invoice);
    }

    @PatchMapping("/{id}/paid")
    public void paid(@PathVariable("id") Long id) {
	System.out.println("Paid invoice with id " + id);
    }

    @PatchMapping("/{id}/unpaid")
    public void unpaid(@PathVariable("id") Long id) {
	System.out.println("Unpaid invoice with id " + id);
    }
}
