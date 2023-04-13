package br.com.arphoenix.toolschallenge.controller;

import br.com.arphoenix.toolschallenge.dto.PagamentoDTO;
import br.com.arphoenix.toolschallenge.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PagamentoDTO> insert(@RequestBody PagamentoDTO pagamento) /*throws JsonProcessingException*/ {
        PagamentoDTO pagamentoDTO = pagamentoService.insert(pagamento);
        return ResponseEntity.ok(pagamentoDTO);
    }

}