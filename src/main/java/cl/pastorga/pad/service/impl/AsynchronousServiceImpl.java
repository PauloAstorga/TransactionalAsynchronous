package cl.pastorga.pad.service.impl;

import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cl.pastorga.pad.entity.AsyncEntity;
import cl.pastorga.pad.repository.AsyncEntityRepository;
import cl.pastorga.pad.service.AsynchronousService;
import lombok.extern.slf4j.Slf4j;

@Service("MyAsyncService")
@Slf4j
public class AsynchronousServiceImpl implements AsynchronousService{
    
    @Autowired
    private AsyncEntityRepository asyncRepository;

    @Override
    @Async
    public CompletableFuture<AsyncEntity> getAsyncEntityByPk(long asyncPk) {
        log.info("Async Service Impl - getAsyncEntityByPk : {}", asyncPk);
        try {
            AsyncEntity entity = asyncRepository.getAsyncEntityById(asyncPk);
            TimeUnit.SECONDS.sleep(5);
            log.info("Async Service Impl - getAsyncEntityByPk - Method Completed After Long Task.");
            return CompletableFuture.completedFuture(entity);
        } catch (Exception e) {
            log.error("Exception Handled", e);
            return null;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public AsyncEntity saveAsyncEntity(String name) {
        log.info("Async Service Impl - saveAsyncEntity : {}", name);
        AsyncEntity entity = new AsyncEntity(name);
        return asyncRepository.save(entity);
    }

    @Override
    public Set<AsyncEntity> getAll() {
        log.info("Async Service Impl - getAll");
        return asyncRepository.findAllByOrderByAsyncEntityPk();
    }

}
