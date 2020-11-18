package blaster.help.form.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {

    private int id;
    private String name;
    private String surname;
    private String email;
    private Department department;

}
