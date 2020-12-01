package lt.blaster.help.form.controllers;

import lombok.extern.log4j.Log4j2;
import lt.blaster.help.form.domain.EquipmentOrder;
import lt.blaster.help.form.domain.StandardEquipment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
@Log4j2
public class StandardEquipmentController {

    private static final String STANDARD_EQUIPMENT_FORM = "form/standardEquipment";

    @GetMapping("/standardEquipment")
    public String getStandardEquipmentForm(Model model) {
        model.addAttribute("today", LocalDate.now());
        model.addAttribute("order", new EquipmentOrder());
        model.addAttribute("allEquipment", StandardEquipment.mockStandardEquipment());
        return STANDARD_EQUIPMENT_FORM;
    }

    @PostMapping("/standardEquipment")
    public String postStandardEquipmentOrder(@Valid @ModelAttribute("order") EquipmentOrder order,
                                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(objectError -> log.error(objectError.toString()));
            model.addAttribute("today", LocalDate.now());
            model.addAttribute("allEquipment", StandardEquipment.mockStandardEquipment());
            return STANDARD_EQUIPMENT_FORM;
        }

        log.error(order.toString());
        return "redirect:/standardEquipment";
    }

}
