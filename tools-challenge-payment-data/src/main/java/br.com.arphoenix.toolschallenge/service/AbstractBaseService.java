package br.com.arphoenix.toolschallenge.service;

import br.com.arphoenix.toolschallenge.entities.AbstractBaseEntity;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface AbstractBaseService<T extends AbstractBaseEntity, ID extends Serializable> {

    public abstract List<T> findAll();

    public abstract T update(T entity);

    public abstract T updateById(T entity, ID id);

    public abstract Optional<T> findById(ID id);

    public abstract void delete(T entity);

    public abstract void delete(ID id);

    public abstract T insert(T entity);

    public abstract boolean exists(ID id);

    public abstract Page<T> findAllPaged(Integer index, Integer offSet);

}
