package blaster.help.form.controller;

import blaster.help.form.domain.Employee;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Log4j2
public class FormController {

    @GetMapping({"", "/"})
    public String openForm(Model model) {
        model.addAttribute("employee", new Employee());

        return "form/GuestForm";
    }

    @PostMapping("/guest")
    public String guestPost(@ModelAttribute("employee") Employee employee) {
        log.info("Employee name: " + employee.getName());
        log.info("Employee surname: " + employee.getSurname());
        log.info("Employee email: " + employee.getEmail());
        log.info("Employee department: " + employee.getDepartment().getName());
        return "redirect: ";
    }

}
