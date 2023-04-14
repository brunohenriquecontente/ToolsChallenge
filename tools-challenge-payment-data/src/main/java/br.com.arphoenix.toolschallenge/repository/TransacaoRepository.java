package br.com.arphoenix.toolschallenge.repository;

import br.com.arphoenix.toolschallenge.entities.TransacaoEntity;
import br.com.arphoenix.toolschallenge.enums.StatusPagamento;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransacaoRepository extends AbstractBaseRepository<TransacaoEntity, UUID>, JpaSpecificationExecutor<TransacaoEntity> {

    List<TransacaoEntity> findAllByDescricaoStatus(StatusPagamento status);

}
