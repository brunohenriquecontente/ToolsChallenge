package br.com.arphoenix.toolschallenge.controller;

import br.com.arphoenix.toolschallenge.dto.common.IdGenericoDTO;
import br.com.arphoenix.toolschallenge.dto.response.PagamentoResponseDTO;
import br.com.arphoenix.toolschallenge.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/estorno")
public class EstornoController {

    @Autowired
    private TransacaoService transacaoService;

    // Buscar estornos
    @GetMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<PagamentoResponseDTO>> getPagamentosEstornados(){
        List<PagamentoResponseDTO> listPagamentoResponse = transacaoService.getPagamentosEstornados();
        return ResponseEntity.ok(listPagamentoResponse);
    }

    // Solicitar estorno
    @PutMapping(path = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PagamentoResponseDTO> update(@PathVariable UUID id){
        PagamentoResponseDTO pagamentoResponseDTO = transacaoService.updateById(id);
        return ResponseEntity.ok(pagamentoResponseDTO);
    }
}
