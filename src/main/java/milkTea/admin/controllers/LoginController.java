package milkTea.admin.controllers;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import milkTea.admin.dto.User;
import milkTea.admin.services.UserService;
import milkTea.admin.utils.FormatDate;
import milkTea.admin.utils.ValidateData;

@Controller
public class LoginController {
	@Autowired
	UserService userService;

	public LoginController() {
		System.out.println("LoginControllers");
	}

	@RequestMapping(path = { "/login" }, method = { RequestMethod.GET })
	public String showLogin() {
		return "login";
	}

	@RequestMapping(path = { "/login" }, method = { RequestMethod.POST })
	public String checkLogin(Model model, User user, HttpSession session) {
		String email = user.getEmail();
		String password = user.getPassword();
		User userInfo = userService.findOne(email);
		if (userInfo != null && userInfo.getPassword().equals(password)) {
			// Login Success
			session.setAttribute("LoginUser", userInfo.getId());
			System.out.println("Filter Info:\t" + new Date() + "\t/SpringMvcXml/login");
			return "redirect:" + "/user/editProfile";
		}
		model.addAttribute("email", email);
		model.addAttribute("password", password);
		model.addAttribute("messageServer", "Email or password invalid !!!");
		return "login";
	}

	@RequestMapping(path = { "/logout" }, method = { RequestMethod.GET })
	public String logout(HttpSession session) {
		session.removeAttribute("LoginUser");
		session.invalidate();
		System.out.println("Filter Info:\t" + new Date() + "\t/SpringMvcXml/logout");
		return "redirect:" + "/login";
	}

	@RequestMapping(path = { "/register" }, method = { RequestMethod.GET })
	public String showRegister() {
		return "register";
	}

	@RequestMapping(path = { "/register" }, method = { RequestMethod.POST })
	public String checkRegister(HttpSession session, Model model, User user, String rePassword) {
		user.setCreateDate(FormatDate.format(new Date()));
		if (userService.findOne(user.getEmail()) == null) {
			if (ValidateData.validateEmail(user.getEmail())) {
				userService.add(user);
				return "redirect:" + "/login";
			} else {
				model.addAttribute("messageServer", "Email invalid");
			}
		} else {
			model.addAttribute("messageServer", "Email already exists!!!");
		}
		model.addAttribute("userName", user.getUserName());
		model.addAttribute("email", user.getEmail());
		model.addAttribute("password", user.getPassword());
		model.addAttribute("rePassword", rePassword);
		System.out.println("Filter Info:\t" + new Date() + "\t/SpringMvcXml/register");
		return "register";
	}

}
