package br.com.arphoenix.toolschallenge.service;

import br.com.arphoenix.toolschallenge.dto.PagamentoDTO;
import br.com.arphoenix.toolschallenge.entities.PagamentoEntity;
import br.com.arphoenix.toolschallenge.entities.TransacaoEntity;
import br.com.arphoenix.toolschallenge.enums.StatusPagamento;
import br.com.arphoenix.toolschallenge.repository.AbstractBaseRepositoryImpl;
import br.com.arphoenix.toolschallenge.repository.PagamentoRepository;
import br.com.arphoenix.toolschallenge.utils.GeradorCodigoAutorizacao;
import br.com.arphoenix.toolschallenge.utils.GeradorNSU;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
//@Transactional
public class PagamentoServiceImp extends AbstractBaseRepositoryImpl<PagamentoEntity, UUID> implements PagamentoService {

    public PagamentoServiceImp(PagamentoRepository pagamentoRepository) {
        super(pagamentoRepository);
    }


    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PagamentoDTO insert(PagamentoDTO pagamentoDTO) {

        PagamentoEntity pagamento = modelMapper.map(pagamentoDTO, PagamentoEntity.class);

        pagamento.getTransacao().getDescricao().setStatus(StatusPagamento.AUTORIZADO);
        pagamento.getTransacao().getDescricao().setNsu(GeradorNSU.gerarNSU());
        pagamento.getTransacao().getDescricao().setCodigoAutorizacao(GeradorCodigoAutorizacao.gerarCodigoAutorizacao());

        //NSU
        //CODIGO AUTORIZACAO
        pagamento = pagamentoRepository.save(pagamento);

        return modelMapper.map(pagamento, PagamentoDTO.class);
    }
}
