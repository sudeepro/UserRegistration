package com.sudeep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sudeep.model.UserLogin;
import com.sudeep.service.UserService;

@Controller
public class LoginController {

	@Autowired(required = true)
	private UserService service;

	@GetMapping("/login")
	public String diplaylogin(Model model) {
		model.addAttribute("loginUser", new UserLogin());
		return "login";

	}

	@PostMapping("/welcome")
	public String login(@ModelAttribute("loginUser") Model model, @RequestParam("email") String userEmail,
			@RequestParam("password") String userPassword) {

		UserLogin userLogin = service.checkEmail(userEmail);

		if (!userEmail.equalsIgnoreCase(userLogin.getEmail()) && !userEmail.equals(userLogin.getPassword())) {
			model.addAttribute("emailError", "Invalid Credentials!");
			return "login";

		} else if (userLogin.getAccountStatus().equalsIgnoreCase("Locked")) {
			model.addAttribute("errorMsg", "Your Account is locked,Plese unlock the account");
		}

		return "dashBoard";

	}

	@GetMapping("/forgetPassword")
	public String displayResetPassword(Model model) {
		model.addAttribute("resetPass", new UserLogin());
		return "forgotPassword";
	}

	@PostMapping("/forgetPassword")
	public String resetPassword(@ModelAttribute("resetPass") Model model, @RequestParam("email") String userEmail) {
		UserLogin userLogin = service.checkEmail(userEmail);
		if (userEmail != null && !userEmail.equalsIgnoreCase(userLogin.getEmail())) {
			model.addAttribute("errorEmail", "Email-ID is not correct");

		} else if (userEmail.equalsIgnoreCase(userLogin.getEmail())
				&& userLogin.getAccountStatus().equalsIgnoreCase("Locked")) {
			model.addAttribute("locked", "'Your Account Is Locked, Please Unlock.");

		} else if (userEmail.equalsIgnoreCase(userLogin.getEmail())
				&& userLogin.getAccountStatus().equalsIgnoreCase("locked")) {

			String password = userLogin.getPassword();

		}

		return "forgetPassword";

	}
}
