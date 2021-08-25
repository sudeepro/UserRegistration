package com.sudeep.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sudeep.model.User;
import com.sudeep.repository.UserRepository;
import com.sudeep.service.UserService;

/**
 * @author sudeep
 *
 */
@Controller
public class UserController {

	private UserService service;

	/**
	 * This method use to show Form.
	 * 
	 * @param model
	 * @return String
	 */

	@GetMapping(value = "/register")
	public String loadForm(Model model) {
		model.addAttribute("user", new User());
		List<String> genderList = new ArrayList<String>();
		genderList.add("Male");
		genderList.add("Female");
		model.addAttribute("gendersList", genderList);
		Map<Integer, String> cmap = service.getAllCountries();
		model.addAttribute("countriesMap", cmap);
		return "viewForm";
	}

	@PostMapping(value = "/register")
	public String registerUser(@Valid @ModelAttribute("user") User user, Model model, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "viewForm";
		} else {
			service.saveUser(user);
			return "redirect:/confirmation";
//defrgtdyukilo;p'p;loukiyjut
		}

	}

	@RequestMapping("/getStates")
	@ResponseBody
	public Map<Integer, String> getStatesByCountryId(@RequestParam("cid") Integer countryId) {
		return service.getStatesByCountryId(countryId);
	}

	@RequestMapping("/getCities")
	@ResponseBody
	public Map<Integer, String> getCitiesByStateId(@RequestParam("sid") Integer stateId) {
		return service.getCitiesByStateId(stateId);
	}

}
