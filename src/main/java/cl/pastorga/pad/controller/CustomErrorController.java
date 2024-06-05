package cl.pastorga.pad.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CustomErrorController implements ErrorController{
    
    @RequestMapping("/error")
    public ResponseEntity<Map<String, Object>> handleError() {
        log.error("Generic error");
        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", HttpStatus.NOT_FOUND.value());
        response.put("message", HttpStatus.NOT_FOUND.series());
        return ResponseEntity.ok().body(response);
    }

}
