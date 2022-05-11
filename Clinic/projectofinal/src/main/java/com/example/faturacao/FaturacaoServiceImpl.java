package com.example.faturacao;

import com.example.entity.Consulta;
import com.example.entity.Facturacao;
import com.example.repositories.ConsultaRepository;
import com.example.services.ConsultasService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
public class FaturacaoServiceImpl implements FaturacaoService {

    @Autowired
    FaturacaoRepository faturacaoRepository;

    @Autowired
    ConsultasService consultasService;

    @Autowired
    ConsultaRepository consultaRepository;


    @Override
    public List<Facturacao> getByIdConsulta(long idConsulta) {


        return faturacaoRepository.findAllByIdConsulta(idConsulta);
    }


    @Override
    public String createInvoice(CreateInvoiceRequest request, Consulta consulta) throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        JSONObject invoiceRequest = new JSONObject();
        invoiceRequest.put("name", request.getName());
        invoiceRequest.put("email", request.getEmail());
        invoiceRequest.put("nif", request.getNif());
        invoiceRequest.put("duedate", df.format(new Date()));

        if (StringUtils.hasText(request.getValue())) {
            invoiceRequest.put("value", request.getValue());
        } else {
            invoiceRequest.put("items", request.getItems());
        }

        String requestUrl = "https://serro.pt/invoices/512382618/create";
        InvoiceResponse response = restTemplate.postForObject(requestUrl, new HttpEntity<>(invoiceRequest.toString(), headers), InvoiceResponse.class);
        if (response == null || response.status.equals("error")) {
            System.out.println("Erro no pedido");
            return null;
        }
        Invoice invoice = response.getInvoice();
        Facturacao facturacao = new Facturacao();
        facturacao.setUrl(invoice.getUrl());
        facturacao.setIdFacturacao(invoice.getId());
        consulta.setIdFatura(invoice.getId());
        facturacao.setIdConsulta(request.getIdConsulta());

        faturacaoRepository.save(facturacao);
        consultaRepository.save(consulta);
        return invoice.getUrl();
        //System.out.println(response.getInvoice().getId() + "teste");
    }

    @Override
    public String viewInvoice(String id) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        String requestUrl = "https://serro.pt/invoices/512382618/get/" + id;
        String response = restTemplate.getForObject(requestUrl, String.class);

        //System.out.println("teste" + response);
        return response;
    }

    @Override
    public InvoiceResponse getInvoice(String id) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        String requestUrl = "https://serro.pt/invoices/512382618/info/" + id;

        InvoiceResponse response = restTemplate.getForObject(requestUrl, InvoiceResponse.class);

        return response;
    }

    @Override
    public InvoiceListResponse listInvoice(InvoiceListRequest request) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        String requestUrl = "https://serro.pt/invoices/512382618/list";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(requestUrl)
                .queryParam(request.getSearchKey(), request.getValue());

        HttpEntity<?> entity = new HttpEntity<>(headers);

        HttpEntity<InvoiceListResponse> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                InvoiceListResponse.class);


        return response.getBody();
    }

    @Override
    public String payInvoice(String id) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        String requestUrl = "https://serro.pt/invoices/512382618/pay/" + id;

        JSONObject invoiceRequest = new JSONObject();
        InvoiceResponse response = restTemplate.postForObject(requestUrl, new HttpEntity<>(invoiceRequest.toString(), headers), InvoiceResponse.class);

        return response.getStatus();
    }
}
