package br.com.arphoenix.toolschallenge.repository;

import br.com.arphoenix.toolschallenge.entities.PagamentoEntity;
import br.com.arphoenix.toolschallenge.entities.TransacaoEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PagamentoRepository extends AbstractBaseRepository<PagamentoEntity, UUID>,
        JpaSpecificationExecutor<PagamentoEntity> {

}