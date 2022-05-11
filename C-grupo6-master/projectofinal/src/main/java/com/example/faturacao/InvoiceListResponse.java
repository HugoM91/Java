package com.example.faturacao;


import java.util.List;

//@JsonInclude(JsonInclude.Include.NON_NULL) TODO
public class InvoiceListResponse {
    private String status;
    private List<Invoice> invoices;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }
}
