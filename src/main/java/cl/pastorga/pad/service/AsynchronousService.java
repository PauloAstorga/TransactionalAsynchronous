package cl.pastorga.pad.service;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import cl.pastorga.pad.entity.AsyncEntity;

public interface AsynchronousService {
    
    public CompletableFuture<AsyncEntity> getAsyncEntityByPk(long asyncPk);

    public AsyncEntity saveAsyncEntity(String name);

    Set<AsyncEntity> getAll();

}
