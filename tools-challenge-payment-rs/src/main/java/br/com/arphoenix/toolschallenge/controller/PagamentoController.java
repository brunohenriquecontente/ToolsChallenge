package br.com.arphoenix.toolschallenge.controller;

import br.com.arphoenix.toolschallenge.dto.request.PagamentoRequestDTO;
import br.com.arphoenix.toolschallenge.dto.response.PagamentoResponseDTO;
import br.com.arphoenix.toolschallenge.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PagamentoResponseDTO> insert(@RequestBody PagamentoRequestDTO pagamentoRequestDTO){
        PagamentoResponseDTO pagamentoResponseDTO = transacaoService.insert(pagamentoRequestDTO);
        return ResponseEntity.ok(pagamentoResponseDTO);
    }

    @GetMapping(path = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PagamentoResponseDTO>findById(@PathVariable UUID id){
        PagamentoResponseDTO pagamentoResponse  = transacaoService.findTransacaoById(id);
        return ResponseEntity.ok(pagamentoResponse);
    }

    @GetMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<PagamentoResponseDTO>>findAll(@RequestBody PagamentoRequestDTO pagamentoRequestDTO){
        List<PagamentoResponseDTO> listPagamentoResponse  = transacaoService.findAllTransacoes();
        return ResponseEntity.ok(listPagamentoResponse);
    }

}