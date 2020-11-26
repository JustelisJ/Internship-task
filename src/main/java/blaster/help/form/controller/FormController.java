package blaster.help.form.controller;

import blaster.help.form.domain.Employee;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Log4j2
public class FormController {

    public static final String GUEST_FORM_URL = "form/GuestForm";

    @GetMapping({"", "/"})
    public String openForm(Model model) {
        model.addAttribute("employee", new Employee());

        return GUEST_FORM_URL;
    }

    @PostMapping("/guest")
    public String guestPost(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(objectError -> log.error(objectError.toString()));
            return GUEST_FORM_URL;
        }

        log.info("Employee name: " + employee.getName());
        log.info("Employee surname: " + employee.getSurname());
        log.info("Employee email: " + employee.getEmail());
        log.info("Employee department: " + employee.getDepartment().getName());
        return "redirect: ";
    }

}
