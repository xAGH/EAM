package com.taller.votos.controllers;

import com.taller.votos.Utils;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.taller.votos.entities.AdminEntity;
import com.taller.votos.entities.LanguajeEntity;
import com.taller.votos.enums.MessageType;
import com.taller.votos.services.AdminService;
import com.taller.votos.services.LanguajeService;


@Controller
public class AdminController {
    
    @Autowired
    private AdminService adminService;
    @Autowired
    private LanguajeService languajeService;
    private MessageType message = MessageType.SUCCESS_MESSAGE;

    @GetMapping("/admin")
    public String dashboard(Model model){
        List<AdminEntity> admins = adminService.list();
        List<LanguajeEntity> languajes = languajeService.list();
        model.addAttribute("admins", admins);
        model.addAttribute("languajes", languajes);
        model = setMessage(model);
        return "admin/dashboard";
    }

    @GetMapping("/logout")
    public String logout(){
        SecurityContextHolder.getContext().setAuthentication(null);
        return "redirect:/";
    }

    @GetMapping("/admin/update-admin/{id}")
    public String updateAdmin(AdminEntity admin, Model model){
        List<AdminEntity> admins = adminService.list();
        List<LanguajeEntity> languajes = languajeService.list();
        model.addAttribute("admins", admins);
        model.addAttribute("languajes", languajes);
        model = setMessage(model);
        admin = adminService.search(admin);
        model.addAttribute("admin", admin);
        return "admin/dashboard";
    }

    @GetMapping("/admin/update-languaje/{id}")
    public String updateLanguaje(LanguajeEntity languaje, Model model){
        List<AdminEntity> admins = adminService.list();
        List<LanguajeEntity> languajes = languajeService.list();
        model.addAttribute("admins", admins);
        model.addAttribute("languajes", languajes);
        model = setMessage(model);
        languaje = languajeService.search(languaje);
        model.addAttribute("languaje", languaje);
        return "admin/dashboard";
    }

    @PostMapping("/admin/register-admin")
    public String save(@Valid AdminEntity admin, Errors errors){
        if (errors.hasErrors()) {
            message = MessageType.ERROR_MESSAGE;
            return "redirect:/admin";
        }
        admin.setPassword(Utils.EncryptPassword(admin.getPassword()));
        message = MessageType.SUCCESS_MESSAGE;
        adminService.save(admin);
        return "redirect:/admin";
    }

    @PostMapping("/admin/register-admin/{id}")
    public String update(@Valid AdminEntity admin, Errors errors){
        if (errors.hasErrors()) {
            message = MessageType.ERROR_MESSAGE;
            return "redirect:/admin";
        }
        adminService.save(admin);
        return "redirect:/admin";
    }

    @GetMapping("/admin/delete-admin/{id}")
    public String delete(AdminEntity admin){
        admin = adminService.search((admin));
        if (! adminExists(admin)) return "redirect:/admin";
        adminService.delete(admin);
        message = MessageType.SUCCESS_MESSAGE;
        return "redirect:/admin";
    }

    @PostMapping("/admin/register-languaje")
    public String save(@Valid LanguajeEntity languaje, Errors errors){
        if (errors.hasErrors()) {
            message = MessageType.ERROR_MESSAGE;
            return "redirect:/admin";
        }
        message = MessageType.SUCCESS_MESSAGE;
        languajeService.save(languaje);
        return "redirect:/admin";
    }

    @GetMapping("/admin/delete-languaje/{id}")
    public String delete(LanguajeEntity languaje){
        if (! languajeExists(languaje)) return "redirect:/";
        languajeService.delete(languaje);
        message = MessageType.SUCCESS_MESSAGE;
        return "redirect:/";
    }

    private Boolean languajeExists(LanguajeEntity languaje){
        if (languajeService.search((languaje)) != null) return true;
        message = MessageType.ERROR_MESSAGE;
        return false;
    }

    private Boolean adminExists(AdminEntity admin){
        if (adminService.search((admin)) != null) return true;
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
