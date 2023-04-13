package br.com.arphoenix.toolschallenge.service;

import br.com.arphoenix.toolschallenge.dto.PagamentoDTO;
import br.com.arphoenix.toolschallenge.entities.PagamentoEntity;
import br.com.arphoenix.toolschallenge.entities.TransacaoEntity;

import java.util.UUID;


public interface PagamentoService extends AbstractBaseService<PagamentoEntity, UUID> {

    public PagamentoDTO insert(PagamentoDTO pagamentoDTO);

}
