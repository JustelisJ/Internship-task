package blaster.help.form.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class Employee {

    private int id;
    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, max = 50, message = "Name has to be from 3 to 50 characters")
    @Pattern(message = "Name cannot contain numbers", regexp = "\\D*")
    private String name;
    @NotBlank(message = "Surname is mandatory")
    @Size(min = 3, max = 50, message = "Surname has to be from 3 to 50 characters")
    @Pattern(message = "Surname cannot contain numbers", regexp = "\\D*")
    private String surname;
    @Email
    @NotBlank(message = "Email is mandatory")
    private String email;
    @Valid
    private Department department;
}
