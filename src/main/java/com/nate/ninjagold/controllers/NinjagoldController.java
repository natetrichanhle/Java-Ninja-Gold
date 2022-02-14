package com.nate.ninjagold.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NinjagoldController {
	public ArrayList<String> activities = new ArrayList<String>();
	
	@RequestMapping("/Gold")
	public String form(HttpSession session, Model model) {
		Integer currentGold = (Integer) session.getAttribute("gold");
		model.addAttribute("showGold", currentGold);
		@SuppressWarnings("unchecked")
		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
		model.addAttribute("activity", activities);
		return "index.jsp";
	}
	
	@RequestMapping(value="/farm", method=RequestMethod.POST)
	public String farm(HttpSession session) {
		Date date = new Date();
		Random randomGenerator = new Random();
		if (session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		} else {
			int addToGold = (int) session.getAttribute("gold");
			int min = 10;
			int max = 20;
			int farmGold = min+randomGenerator.nextInt(max-min+1);
			addToGold += farmGold;
			session.setAttribute("gold", addToGold);
			activities.add(0,"You entered a farm and earned " + farmGold + " gold. " + date);
			session.setAttribute("activities", activities);
		}
		return "redirect:/Gold";
	}
	
	@RequestMapping(value="/cave", method=RequestMethod.POST)
	public String cave(HttpSession session) {
		Date date = new Date();
		Random randomGenerator = new Random();
		if (session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		} else {
			int addToGold = (int) session.getAttribute("gold");
			int min = 5;
			int max = 10;
			int caveGold = min+randomGenerator.nextInt(max-min+1);
			addToGold += caveGold;
			session.setAttribute("gold", addToGold);
			activities.add(0,"You entered a farm and earned " + caveGold + " gold. " + date);
			session.setAttribute("activities", activities);
		}
		return "redirect:/Gold";
	}
	
}
