package com.example.faturacao;

import com.example.entity.Consulta;
import com.example.entity.Facturacao;
import com.example.faturacao.CreateInvoiceRequest;
import com.example.faturacao.InvoiceListRequest;

import java.util.List;

public interface FaturacaoService {

    String createInvoice(CreateInvoiceRequest request, Consulta consulta) throws Exception;

    String viewInvoice(String id);

    InvoiceResponse getInvoice(String id);

    InvoiceListResponse listInvoice(InvoiceListRequest request);

    List<Facturacao> getByIdConsulta(long idConsulta);

    String payInvoice (String Id);
}
