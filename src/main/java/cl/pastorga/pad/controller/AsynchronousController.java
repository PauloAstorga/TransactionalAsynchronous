package cl.pastorga.pad.controller;

import org.springframework.web.bind.annotation.RestController;

import cl.pastorga.pad.constants.ControllerConstants;
import cl.pastorga.pad.entity.AsyncEntity;
import cl.pastorga.pad.service.AsynchronousService;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@Slf4j
public class AsynchronousController {

    @Autowired
    private AsynchronousService asyncService;

    @RequestMapping(value = ControllerConstants.ASYNC_CONTROLLER_INSERT, method=RequestMethod.POST)
    public ResponseEntity<?> asyncInsert(@PathVariable String asyncEntityName) {
        log.info("Async Controller - asyncInsert -> entityName: {}", asyncEntityName);
        try {
            Map<String, Object> response = new HashMap<>();
            AsyncEntity entity = asyncService.saveAsyncEntity(asyncEntityName);
            response.put("message", "Object saved.");
            response.put("object", entity);
            log.info("Async Controller - asyncInsert - Before Long Task");
            asyncService.getAsyncEntityByPk(entity.getAsyncEntityPk());
            log.info("Async Controller - asyncInsert - After Long Task");
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            log.error("Exception Handled: {}", e);
            return null;
        }
    }

    @RequestMapping(value = ControllerConstants.ASYNC_CONTROLLER_GET_ALL, method=RequestMethod.GET)
    public Set<AsyncEntity> asyncGetAll() {
        log.info("Async Controller - asyncGetAll");
        try {
            return asyncService.getAll();
        } catch (Exception e) {
            log.error("Exception Handled: {}", e);
            return null;
        }
    }
    
}
