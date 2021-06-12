package me.fevvelasquez.quicknotes.spring.mvc.data.th.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import me.fevvelasquez.quicknotes.spring.mvc.data.th.jpa.model.dao.IClientDAO;

/**
 * Quick Notes.
 * 
 * @author fevvelasquez
 *
 */
@Controller
public class ClientController {

	// We may use a @service instead the DAO.
	@Autowired
	@Qualifier("qclientDAO") // If multiple implementations
	private IClientDAO clientDAO;

	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("mclients", clientDAO.findAll());
		return "vclients"; // resources/templates/vclients.html
	}
}
