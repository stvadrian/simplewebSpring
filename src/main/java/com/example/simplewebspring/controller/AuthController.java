package com.example.simplewebspring.controller;

import com.example.simplewebspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
public class AuthController extends com.example.simplewebspring.controller.Controller {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String redirectToLogin() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage(Model model,
                            @RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "username", required = false) String username,
                            RedirectAttributes redirectAttributes) {
        model.addAttribute("subtitleAuth", "Please sign in.");

        if (error != null) {
            redirectAttributes.addFlashAttribute("alertType", "toast");
            redirectAttributes.addFlashAttribute("alertCategory", "error");
            redirectAttributes.addFlashAttribute("alertMessage", "Credentials doesn't match");
            redirectAttributes.addFlashAttribute("username", username);
            return "redirect:/login";
        }
        return "pages/auth/login";
    }


    @GetMapping("/register")
    public String register() {
        return "pages/auth/register";
    }


    @PostMapping("/register")
    public String registerAttempt(@RequestParam("username") String username,
                                  @RequestParam("password") String password,
                                  @RequestParam("mobile") String mobile,
                                  @RequestParam("dob") String dobString,
                                  RedirectAttributes redirectAttributes) {

        boolean userExists = userService.userExistsByUsername(username);
        if (userExists) {
            redirectAttributes.addFlashAttribute("alertType", "toast")
                    .addFlashAttribute("alertCategory", "error")
                    .addFlashAttribute("alertMessage", "Username already exist!");

            redirectAttributes.addFlashAttribute("errorMessage", "username")
                    .addFlashAttribute("mobile", mobile)
                    .addFlashAttribute("dob", dobString);
            return "redirect:/register";
        }

        boolean mobileExists = userService.userExistsByMobile(mobile);
        if (mobileExists) {
            redirectAttributes.addFlashAttribute("alertType", "toast")
                    .addFlashAttribute("alertCategory", "error")
                    .addFlashAttribute("alertMessage", "Mobile phone already taken!");

            redirectAttributes.addFlashAttribute("errorMessage", "mobile")
                    .addFlashAttribute("username", username)
                    .addFlashAttribute("dob", dobString);
            return "redirect:/register";
        }

        LocalDate dob = normalizeDate(dobString);
        boolean successRegister = userService.registerUser(username, password, dob, mobile, 1,1,1);
        if (!successRegister) {
            redirectAttributes.addFlashAttribute("alertType", "toast");
            redirectAttributes.addFlashAttribute("alertCategory", "error");
            redirectAttributes.addFlashAttribute("alertMessage", "Something went wrong!");

            redirectAttributes.addFlashAttribute("username", username);
            return "redirect:/register";
        }

        redirectAttributes.addFlashAttribute("alertType", "swal");
        redirectAttributes.addFlashAttribute("alertCategory", "success");
        redirectAttributes.addFlashAttribute("alertMessage", "Registered Successfully!");
        return "redirect:/login";
    }
}
