package net.codejava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.Service.CarService;
import net.codejava.Service.ClientService;
import net.codejava.Service.ContractService;
import net.codejava.model.Car;
import net.codejava.model.Client;
import net.codejava.model.Contract;

@Controller
public class AppController {
	@Autowired
	private ClientService clienService;
	@Autowired
	private CarService carService;
	@Autowired
	private ContractService contractService;
		
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		return "home"; 
	}
	
	@RequestMapping("/clients")
	public String viewClientsPage(Model model) {
		List<Client> listClients = clienService.listAll();
		model.addAttribute("listClients", listClients);
		
		return "clients"; 
	}
	
	@RequestMapping("/cars")
	public String viewCarsPage(Model model) {
		List<Car> listCars = carService.listAll();
		model.addAttribute("listCars", listCars);
		
		return "cars"; 
	}
	
	@RequestMapping("/contracts")
	public String viewContractPage(Model model) {
		List<Contract> listContracts = contractService.listAll();
		model.addAttribute("listContracts", listContracts);
		
		return "contracts"; 
	}
	
	@RequestMapping("/new-client")
	public String showNewClientPage(Model model) {
	    Client client = new Client();
	    model.addAttribute("client", client); 
	    
	    return "new_client"; 
	}
	
	@RequestMapping("/new-car")
	public String showNewCarPage(Model model) {
		Car car = new Car();
	    model.addAttribute("car", car); 
	    
	    return "new_car"; 
	}
	
	@RequestMapping("/new-contract")
	public String showNewContractPage(Model model) {
		Contract contract = new Contract();
	    model.addAttribute("contract", contract); 
	    
	    return "new_contract"; 
	}
	@RequestMapping(value = "/save-client", method = RequestMethod.POST)
	public String saveClient(@ModelAttribute("client") Client client) {
		clienService.save(client);
	     
	    return "redirect:/clients";
	}
	
	@RequestMapping(value = "/save-car", method = RequestMethod.POST)
	public String saveCar(@ModelAttribute("car") Car car) {
		carService.save(car);
	     
	    return "redirect:/cars";
	}
	
	@RequestMapping(value = "/save-contract", method = RequestMethod.POST)
	public String saveContract(@ModelAttribute("contract") Contract contract) {
		contractService.save(contract);
	     
	    return "redirect:/contracts";
	}
	
	@RequestMapping("/edit-client/{id}")
	public ModelAndView showEditClientPage(@PathVariable(name = "id") Long id) {
	    ModelAndView mav = new ModelAndView("edit_client");
	    Client client = clienService.get(id);
	    mav.addObject("client", client);
	     
	    return mav;
	}
	
	@RequestMapping("/edit-car/{car_id}")
	public ModelAndView showEditCarPage(@PathVariable(name = "car_id") Long id) {
	    ModelAndView mav = new ModelAndView("edit_car");
	    Car car = carService.get(id);
	    mav.addObject("car", car);
	     
	    return mav;
	}
	
	@RequestMapping("/edit-contract/{contract_id}")
	public ModelAndView showEditContractPage(@PathVariable(name = "contract_id") Long id) {
	    ModelAndView mav = new ModelAndView("edit_contract");
	    Contract contract = contractService.get(id);
	    mav.addObject("contract", contract);
	     
	    return mav;
	}
	
	@RequestMapping("/delete-client/{id}")
	public String deleteClient(@PathVariable(name = "id") Long id) {
		clienService.delete(id);
	    
	    return "redirect:/clients";       
	}
	
	@RequestMapping("/delete-car/{car_id}")
	public String deleteCar(@PathVariable(name = "car_id") Long id) {
		carService.delete(id);
	    
	    return "redirect:/cars";       
	}
	
	@RequestMapping("/delete-contract/{contract_id}")
	public String deleteContract(@PathVariable(name = "contract_id") Long id) {
		contractService.delete(id);
	    
	    return "redirect:/contracts";       
	}
}
