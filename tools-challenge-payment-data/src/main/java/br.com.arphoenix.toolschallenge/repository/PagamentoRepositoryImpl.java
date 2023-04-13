package br.com.arphoenix.toolschallenge.repository;

import br.com.arphoenix.toolschallenge.entities.PagamentoEntity;
import br.com.arphoenix.toolschallenge.entities.TransacaoEntity;
import br.com.arphoenix.toolschallenge.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional

public abstract class PagamentoRepositoryImpl extends AbstractBaseRepositoryImpl<PagamentoEntity, UUID> implements PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

  //  private static final Logger logger = LoggerFactory.getLogger(PagamentoRepositoryImpl.class);

    public PagamentoRepositoryImpl(PagamentoRepository pagamentoRepository) {
        super(pagamentoRepository);
    }

}
