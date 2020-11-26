package blaster.help.form.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Department {

    private int id;
    @NotBlank(message = "Choose a department")
    private String name;

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    public static List<Department> mockDepartmentList() {
        List<Department> departments = new ArrayList<>();
        departments.add(new Department("TeleSoftas Kaunas"));
        departments.add(new Department("TeleSoftas Vilnius"));
        departments.add(new Department("TeleSoftas Klaipėda"));
        departments.add(new Department("Adeo Web Kaunas"));
        departments.add(new Department("Adeo Web Vilnius"));
        departments.add(new Department("SneakyBox Kaunas"));
        departments.add(new Department("SneakyBox Vilnius"));
        departments.add(new Department("MobOn"));
        departments.add(new Department("OKTA"));
        departments.add(new Department("Agmis"));
        return departments;
    }
}
