package br.com.arphoenix.toolschallenge.service;

import br.com.arphoenix.toolschallenge.dto.request.PagamentoRequestDTO;
import br.com.arphoenix.toolschallenge.dto.response.PagamentoResponseDTO;
import br.com.arphoenix.toolschallenge.entities.TransacaoEntity;

import java.util.List;
import java.util.UUID;


public interface TransacaoService extends AbstractBaseService<TransacaoEntity, UUID> {

    public PagamentoResponseDTO insert(PagamentoRequestDTO pagamentoRequestDTO);

    public PagamentoResponseDTO findTransacaoById(UUID id);

    public List<PagamentoResponseDTO> findAllTransacoes();

    public List<PagamentoResponseDTO> getPagamentosEstornados() ;

    public PagamentoResponseDTO updateById(UUID id);
}
