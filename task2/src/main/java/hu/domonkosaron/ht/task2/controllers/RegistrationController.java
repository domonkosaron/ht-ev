package hu.domonkosaron.ht.task2.controllers;

import hu.domonkosaron.ht.task2.models.RegistrationForm;
import hu.domonkosaron.ht.task2.repositories.SaveRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
public class RegistrationController implements WebMvcConfigurer {

    private final SaveRepository repository;
    private final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    public RegistrationController(SaveRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/tac").setViewName("tac");
        registry.addViewController("/welcome").setViewName("welcome");
    }

    @GetMapping("/")
    public String showRegistrationForm(RegistrationForm registrationForm) {
        return "registration";
    }

    @PostMapping("/")
    public String register(@Valid RegistrationForm registrationForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }

        if (repository.findByEmailAddress(registrationForm.getEmail()).isPresent()) {
            return "redirect:/welcome";
        } else {
            repository.save(registrationForm);
            return "redirect:/tac";
        }

    }
}
