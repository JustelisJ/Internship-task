package lt.blaster.help.form.controllers;

import lombok.extern.log4j.Log4j2;
import lt.blaster.help.form.domain.EquipmentOrder;
import lt.blaster.help.form.domain.StandardEquipment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
@Log4j2
public class StandardEquipmentController {

    @GetMapping("/standardEquipment")
    public String getStandardEquipmentForm(Model model) {
        model.addAttribute("today", LocalDate.now());
        model.addAttribute("order", new EquipmentOrder());
        model.addAttribute("allEquipment", StandardEquipment.mockStandardEquipment());
        return "form/standardEquipment";
    }

    @PostMapping("/standardEquipment")
    public String postStandardEquipmentOrder(EquipmentOrder order) {
        log.error(order.toString());
        return "redirect:/standardEquipment";
    }

}
