package blaster.help.form.controller;

import blaster.help.form.domain.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class FormControllerTest {

    FormController controller;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        controller = new FormController();
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void openForm() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("form/GuestForm"))
                .andExpect(model().attributeExists("employee"));
    }

    @Test
    void guestPost() throws Exception {
        mockMvc.perform(post("/guest")
                .flashAttr("employee", new Employee()))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect: "))
                .andExpect(model().attributeExists("employee"));
    }
}