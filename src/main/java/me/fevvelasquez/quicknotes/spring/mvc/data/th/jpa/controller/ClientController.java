package me.fevvelasquez.quicknotes.spring.mvc.data.th.jpa.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import me.fevvelasquez.quicknotes.spring.mvc.data.th.jpa.model.dao.IClientDAO;
import me.fevvelasquez.quicknotes.spring.mvc.data.th.jpa.model.entity.Client;

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

	/**
	 * Display list of Clients.
	 */
	@RequestMapping(value = { "/clients", "/", "/index", "/index.html" }, method = RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("mclients", clientDAO.findAll());
		return "vclients"; // resources/templates/vclients.html
	}

	/**
	 * Display form to introduce client info.
	 */
	@RequestMapping("/client") // GET by default // model can also be a Map<String, Object>
	public String create(Map<String, Object> model) {
		model.put("mclient", new Client());
		return "vclient";
	}

	/**
	 * Insert client and redirect to "/clients".
	 */
	@RequestMapping(value = "/client", method = RequestMethod.POST)
	public String save(Client client) {
		clientDAO.save(client);
		return "redirect:clients";
	}
}
