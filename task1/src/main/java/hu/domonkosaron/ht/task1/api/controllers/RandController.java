package hu.domonkosaron.ht.task1.api.controllers;

import hu.domonkosaron.ht.task1.domain.services.RandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandController {

    private final RandService service;

    @Autowired
    public RandController(RandService service) {
        this.service = service;
    }

    @GetMapping("/rand")
    public String rand(@RequestParam(value = "max", defaultValue = "11") String max){
        try {
            return service.rand(Integer.parseInt(max));
        } catch (final NumberFormatException nfe) {
            return "Invalid number: " + max + "!";
        }
    }
}
