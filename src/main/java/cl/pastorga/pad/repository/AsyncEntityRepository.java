package cl.pastorga.pad.repository;

import java.util.LinkedHashSet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cl.pastorga.pad.entity.AsyncEntity;

public interface AsyncEntityRepository extends JpaRepository<AsyncEntity, Long>{

    @Query("FROM AsyncEntity WHERE asyncEntityPk=:ASYNC_PK")
    public AsyncEntity getAsyncEntityById(@Param("ASYNC_PK") long asyncPk);

    public LinkedHashSet<AsyncEntity> findAllByOrderByAsyncEntityPk();
    
}
