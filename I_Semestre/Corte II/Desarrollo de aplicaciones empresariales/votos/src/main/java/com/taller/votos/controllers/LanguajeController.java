package com.taller.votos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.taller.votos.entities.LanguajeEntity;
import com.taller.votos.enums.MessageType;
import com.taller.votos.enums.OperationType;
import com.taller.votos.services.LanguajeService;

@Controller
public class LanguajeController {
    
    @Autowired
    private LanguajeService languajeService;
    private MessageType message = MessageType.NOTHING;

    @GetMapping("/")
    public String home(Model model){
        List<LanguajeEntity> languajes = languajeService.list();
        model = setMessage(model);
        model.addAttribute("languajes", languajes);
        return "home";
    }

    @GetMapping("/vote/{id}/{operation}")
    public String vote(LanguajeEntity languaje, @PathVariable Integer operation){
        if ((languajeExists(languaje)) || (operation >= 0 && operation < 2)){
            languajeService.votes(languaje, operation == 0 ? OperationType.SUMA : OperationType.RESTA);
            message = MessageType.VOTE_DONE_MESSAGE;
        };
        return "redirect:/";
    }

    private Boolean languajeExists(LanguajeEntity languaje){
        if (languajeService.search((languaje)) != null) return true;
        message = MessageType.ERROR_MESSAGE;
        return false;
    }

    private Model setMessage(Model model){
        if (message.getCode() != 0){
            model.addAttribute("message", message.getMessage());
            message = MessageType.NOTHING;
        }
        return model;
    }
}
