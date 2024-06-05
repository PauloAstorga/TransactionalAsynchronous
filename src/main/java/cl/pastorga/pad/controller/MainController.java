package cl.pastorga.pad.controller;

import org.springframework.web.bind.annotation.RestController;

import cl.pastorga.pad.constants.ControllerConstants;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@RestController()
public class MainController {
    
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public ResponseEntity<Map<String, String>> defaultGetEntry(@PathVariable(required = true) String message) {
        Map<String, String> response = new HashMap<>();
        response.put("status", "SUCCESS");
        response.put("message", message);
        return ResponseEntity.status(200).body(response);
    }
    

    @RequestMapping(value = ControllerConstants.MAIN_CONTROLLER_DEFAULT_GET, method=RequestMethod.GET)
    public ResponseEntity<Map<String, String>> getEntry(@PathVariable(required = true) String message) {
        Map<String, String> response = new HashMap<>();
        response.put("status", "SUCCESS");
        response.put("message", message);
        return ResponseEntity.status(200).body(response);
    }
    
    @RequestMapping(value = ControllerConstants.MAIN_CONTROLLER_DEFAULT_POST, method=RequestMethod.POST)
    public ResponseEntity<Map<String, String>> postEntry(@PathVariable(required = true) String message) {
        Map<String, String> response = new HashMap<>();
        response.put("status", "SUCCESS");
        response.put("message", message);
        return ResponseEntity.status(200).body(response);
    }

}
