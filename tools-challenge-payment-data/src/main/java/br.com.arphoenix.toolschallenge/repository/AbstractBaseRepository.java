package br.com.arphoenix.toolschallenge.repository;

import java.io.Serializable;

import br.com.arphoenix.toolschallenge.entities.AbstractBaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface AbstractBaseRepository<T extends AbstractBaseEntity, ID extends Serializable>
		extends JpaRepository<T, ID> {

}
