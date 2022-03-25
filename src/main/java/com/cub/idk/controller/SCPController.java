package com.cub.idk.controller;

import com.cub.idk.model.Employee;
import com.cub.idk.model.SCPentity;
import com.cub.idk.service.EmployeeService;
import com.cub.idk.service.SCPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SCPController {
    @Autowired
    private SCPService scpService;

    // display list of employees
    @GetMapping("/scplist")
    public String viewHomePage(Model model) {

        List<SCPentity> list = scpService.getAllSCPs();
        model.addAttribute("listSCPs",list);


        return "scplist";
    }

    @GetMapping("/showNewSCPForm")
    public String showNewSCPForm(Model model) {
        // create model attribute to bind form data
        SCPentity employee = new SCPentity();
        model.addAttribute("employee", employee);
        return "new_scp";
    }

    @PostMapping("/saveSCP")
    public String saveEmployee(@ModelAttribute("employee") SCPentity scp) {
        // save employee to database
        scpService.saveSCP(scp);
        return "redirect:/scplist";
    }

    @GetMapping("/showSCPFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get employee from the service
        SCPentity employee = scpService.getSCPById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employee);
        return "update_scp";
    }

    @GetMapping("/deleteSCP/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {

        // call delete employee method
        this.scpService.deleteSCPById(id);
        return "redirect:/scplist";
    }
}
