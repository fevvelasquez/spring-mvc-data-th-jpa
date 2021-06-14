package me.fevvelasquez.quicknotes.spring.mvc.data.th.jpa.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import me.fevvelasquez.quicknotes.spring.mvc.data.th.jpa.model.entity.Client;
import me.fevvelasquez.quicknotes.spring.mvc.data.th.jpa.model.service.IClientService;

/**
 * Quick Notes.
 * 
 * @author fevvelasquez
 *
 */
@Controller
@SessionAttributes("client")
public class ClientController {

	// We may use a @service instead the DAO.
	@Autowired
	private IClientService clientService;

	/**
	 * Display list of Clients.
	 */
	@RequestMapping(value = { "/clients", "/" }, method = RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("clients", clientService.findAll());
		return "vclients"; // resources/templates/vclients.html
	}

	/**
	 * Display form to introduce client info.
	 */
	@RequestMapping("/client") // GET by default // model can also be a Map<String, Object>
	public String create(Map<String, Object> model) {
		model.put("client", new Client());
		return "vclient";
	}

	/**
	 * Display form to modify client info.
	 */
	@GetMapping("/client/{id}")
	public String modify(@PathVariable Long id, Model model) {
		model.addAttribute("client", clientService.findOne(id));
		return "vclient";

	}

	/**
	 * Insert / Update client and redirect to "/clients".
	 */
	@RequestMapping(value = "/client", method = RequestMethod.POST)
	public String save(Client client, SessionStatus sessionStatus) {
		System.out.println(client);
		clientService.save(client);
		sessionStatus.setComplete(); // Clean client
		return "redirect:clients";
	}

	/**
	 * Delete client and redirect to "/clients".
	 */
	@RequestMapping("/clientr/{id}")
	public String remove(@PathVariable Long id) {
		clientService.delete(id);
		return "redirect:/clients";
	}
}
