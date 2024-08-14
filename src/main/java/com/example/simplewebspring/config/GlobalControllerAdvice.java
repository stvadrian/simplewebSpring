package com.example.simplewebspring.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@ControllerAdvice
@SessionAttributes({"currentTemplate", "appName", "authenticated"})
public class GlobalControllerAdvice {

    @ModelAttribute("currentTemplate")
    public String defineCurrentTemplate() {
        return "oneui";
    }

    @ModelAttribute("appName")
    public String defineAppName() {
        return "PremierCare Hub";
    }

    @ModelAttribute("authenticated")
    public String defineUsername() {
        // In a real application, this would probably be fetched from the logged-in user’s session or security context
        return "John Doe";
    }
}
