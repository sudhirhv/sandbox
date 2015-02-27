package com.sobis.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sobis.model.Bug;
import com.sobis.model.Employee;
import com.sobis.model.Project;
import com.sobis.service.BugTrackerService;

@Controller
public class BugTrackerController {

	@Autowired
	public BugTrackerService bugTrackerService;
	
	@ModelAttribute("projects")
	public List<Project> getProjects() {
		return bugTrackerService.fetchAllProjects();
	}
	
	@ModelAttribute("employees")
	public List<Employee> getEmployees() {
		return bugTrackerService.fetchAllEmployees();
	}
	
	@RequestMapping("/reportBug.view")
	public String addBugForm(Model model) {
		model.addAttribute("bug", new Bug());
		return "bugReport";
	}
	
	@RequestMapping("/addBug.view")
	public String addBug(@ModelAttribute("bug") Bug bug, Model model) {
		bug.setRaisedDate(new Date());
		bugTrackerService.reportBug(bug);
		model.addAttribute("message", "Bug "+bug.getDescription() + " reported");
		return "redirect:home.view";		
	}
	
	@RequestMapping("/home.view")
	public String getHomePage() {
		return "home";
	}
	
	@RequestMapping("/addEmployee.view")
	public String getEmployeeForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "empAdd";
	}
			
	@RequestMapping("/insertEmployee.view")
	public String addEmployee(@ModelAttribute("employee") Employee e,
			BindingResult errors, Model model) {
		bugTrackerService.insertEmployee(e);
		model.addAttribute("message", "Employee "+e.getName() + " added successfully");
		return "redirect:home.view"; //client redirection
	}
	
	@RequestMapping("/resolveBug.view")
	public String getResolvePage(Model model) {
		model.addAttribute("bug", new Bug());
		model.addAttribute("bugs", bugTrackerService.getAllBugs());
		return "resolvePage";
	}
	
	@RequestMapping("/closeBug.view")
	public String closeBug(@ModelAttribute("bug") Bug bug, Model model) {
		bug.setResolvedDate(new Date());
		bugTrackerService.resolveBug(bug);
		model.addAttribute("message"+bug.getDescription() + " resolved successfully" );
		return "redirect:home.view";
	}
	
	
}
