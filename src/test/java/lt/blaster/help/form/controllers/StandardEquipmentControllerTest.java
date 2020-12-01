package lt.blaster.help.form.controllers;

import lt.blaster.help.form.domain.EquipmentOrder;
import lt.blaster.help.form.domain.StandardEquipment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class StandardEquipmentControllerTest {

    StandardEquipmentController controller;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        controller = new StandardEquipmentController();
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void getStandardEquipmentForm() throws Exception {
        mockMvc.perform(get("/standardEquipment"))
                .andExpect(status().isOk())
                .andExpect(view().name("form/standardEquipment"))
                .andExpect(model().attributeExists("order"))
                .andExpect(model().attributeExists("today"))
                .andExpect(model().attributeExists("allEquipment"));
    }

    @Test
    void postStandardEquipmentOrder() throws Exception {
        EquipmentOrder orderWithOnerEquipment = initializeEquipmentOrderWithOneEquipment();
        mockMvc.perform(post("/standardEquipment").flashAttr("order", orderWithOnerEquipment))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/standardEquipment"));
    }

    @Test
    void postEmptyStandardEquipmentOrder() throws Exception {
        mockMvc.perform(post("/standardEquipment")
                .flashAttr("order", new EquipmentOrder()))
                .andExpect(status().isOk())
                .andExpect(view().name("form/standardEquipment"))
                .andExpect(model().attributeExists("order"))
                .andExpect(model().attributeExists("today"))
                .andExpect(model().attributeExists("allEquipment"));
    }

    private EquipmentOrder initializeEquipmentOrderWithOneEquipment() {
        StandardEquipment equipment = new StandardEquipment("phone");
        EquipmentOrder orderWithOneEquipment = new EquipmentOrder();
        orderWithOneEquipment.getEquipments().add(equipment);
        return orderWithOneEquipment;
    }
}