package br.com.arphoenix.toolschallenge.service;

import br.com.arphoenix.toolschallenge.dto.request.PagamentoRequestDTO;
import br.com.arphoenix.toolschallenge.dto.response.PagamentoResponseDTO;
import br.com.arphoenix.toolschallenge.entities.TransacaoEntity;
import br.com.arphoenix.toolschallenge.enums.StatusPagamento;
import br.com.arphoenix.toolschallenge.exceptions.CartaoCreditoInvalidoException;
import br.com.arphoenix.toolschallenge.exceptions.TransacaoNotFoundException;
import br.com.arphoenix.toolschallenge.repository.AbstractBaseRepositoryImpl;
import br.com.arphoenix.toolschallenge.repository.TransacaoRepository;
import br.com.arphoenix.toolschallenge.utils.GeradorCodigoAutorizacao;
import br.com.arphoenix.toolschallenge.utils.GeradorNSU;
import br.com.arphoenix.toolschallenge.utils.ValidadorCartaoCredito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class TransacaoServiceImpl extends AbstractBaseRepositoryImpl<TransacaoEntity, UUID> implements TransacaoService {

    public TransacaoServiceImpl(TransacaoRepository transacaoRepository) {
        super(transacaoRepository);
    }

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PagamentoResponseDTO insert(PagamentoRequestDTO pagamentoRequestDTO) {

        TransacaoEntity transacao = modelMapper.map(pagamentoRequestDTO.getTransacao(), TransacaoEntity.class);

        // TODO:
        // Verificar se quantidade de parcelas igual 1 então tipo de pagamento não pode ser parcelado
        // if(pagamentoRequestDTO.getTransacao().getFormaPagamento().getParcelas().equals(1)
        //      && (pagamentoRequestDTO.getTransacao().getFormaPagamento().getTipo().equals(TipoPagamento.PARCELADOEMISSOR)
        //     || pagamentoRequestDTO.getTransacao().getFormaPagamento().getTipo().equals(TipoPagamento.PARCELADOLOJA)))
        //    throw new TipoPagamentoInvalidoException();

        // TODO:
        // Verificar se quantidade de parcelas diferente de 1, então pagamento só pode ser a vista
        // if(!pagamentoRequestDTO.getTransacao().getFormaPagamento().getParcelas().equals(1)
        //        && (pagamentoRequestDTO.getTransacao().getFormaPagamento().getTipo().equals(TipoPagamento.AVISTA)))
        //    throw new TipoPagamentoInvalidoException();

        // Valida o cartão de crédito
        if (!ValidadorCartaoCredito.validate(pagamentoRequestDTO.getTransacao().getCartao()))
            throw new CartaoCreditoInvalidoException();

        transacao.getDescricao().setStatus(StatusPagamento.AUTORIZADO);
        // Gera número de NSU
        transacao.getDescricao().setNsu(GeradorNSU.gerarNSU());

        // Gera código de autorização
        transacao.getDescricao().setCodigoAutorizacao(GeradorCodigoAutorizacao.gerarCodigoAutorizacao());

        transacao = transacaoRepository.save(transacao);
        return modelMapper.map(transacao, PagamentoResponseDTO.class);
    }
    
    public PagamentoResponseDTO findTransacaoById(UUID id){
        TransacaoEntity transacaoEntity = transacaoRepository.findById(id).orElseThrow(()
                -> new TransacaoNotFoundException(id));
        PagamentoResponseDTO pagamentoResponseDTO = modelMapper.map(transacaoEntity, PagamentoResponseDTO.class);
        return pagamentoResponseDTO ;
    }

    public List<PagamentoResponseDTO> findAllTransacoes(){
        List<TransacaoEntity> transacoes = transacaoRepository.findAll();
        List<PagamentoResponseDTO> pagamentosDTO = new ArrayList<>();
        for (TransacaoEntity transacao : transacoes) {
            PagamentoResponseDTO pagamentoDTO = modelMapper.map(transacao, PagamentoResponseDTO.class);
            pagamentosDTO.add(pagamentoDTO);
        }
        return pagamentosDTO;

    }

    @Override
    public List<PagamentoResponseDTO> getPagamentosEstornados() {
        List<TransacaoEntity> transacoes = transacaoRepository.findAllByDescricaoStatus(StatusPagamento.CANCELADO);
        List<PagamentoResponseDTO> pagamentosDTO = new ArrayList<>();
        for (TransacaoEntity transacao : transacoes) {
            PagamentoResponseDTO pagamentoDTO = modelMapper.map(transacao, PagamentoResponseDTO.class);
            pagamentosDTO.add(pagamentoDTO);
        }
        return pagamentosDTO;
    }


    @Override
    public PagamentoResponseDTO updateById(UUID id) {
        TransacaoEntity transacao = transacaoRepository.findById(id).orElseThrow(() -> new TransacaoNotFoundException(id));
        transacao.getDescricao().setStatus(StatusPagamento.CANCELADO);
        transacao = transacaoRepository.save(transacao);
        return modelMapper.map(transacao, PagamentoResponseDTO.class);
    }
}
