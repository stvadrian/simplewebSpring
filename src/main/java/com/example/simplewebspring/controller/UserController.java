package com.example.simplewebspring.controller;

import com.example.simplewebspring.model.Application;
import com.example.simplewebspring.repository.ApplicationRepository;
import com.example.simplewebspring.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class UserController {

    private final ApplicationService applicationService;

    @Autowired
    public UserController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/dashboard")
    public ModelAndView dashboardPage() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        ModelAndView modelAndView = new ModelAndView("pages/general/dashboard");
        modelAndView.addObject("username", username);

        List<Application> applicationList = applicationService.getApplicationsBySite(1);
        modelAndView.addObject("appList", applicationList);

        return modelAndView;
    }
}
