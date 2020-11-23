package blaster.help.form.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Department {

    private int id;
    private String name;

    public Department(String name) {
        this.name = name;
    }
}
