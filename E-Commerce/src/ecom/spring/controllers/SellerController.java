package ecom.spring.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ecom.model.User;

@Controller
public class SellerController {

	@RequestMapping("welcome")
	public ModelAndView hello(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		System.out.println(user);
		ModelAndView modelAndView = new ModelAndView("buyer/test");
		//ModelAndView modelAndView = new ModelAndView("jsp_Buyer/BuyerMainPanel");
		
		return modelAndView;
	}
}
