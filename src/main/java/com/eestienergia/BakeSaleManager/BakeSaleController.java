package com.eestienergia.BakeSaleManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BakeSaleController {
	
	@Autowired
	private BakeSaleDAO dao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewHomePage(Model model) {
		List<BakeSaleModel> listSale = dao.list();
		model.addAttribute("listSale", listSale);
	    return "index";
	}
	
	@RequestMapping(value = "/purchase", method = RequestMethod.GET)
	public String purchasePage(Model model) {
		List<BakeSaleModel> checkedSale = dao.checkedList();
		model.addAttribute("checkedSale", checkedSale);
	    return "purchase_form";
	}
	
}
