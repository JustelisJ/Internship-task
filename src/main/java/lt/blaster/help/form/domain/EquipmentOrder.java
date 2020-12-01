package lt.blaster.help.form.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class EquipmentOrder {

    private List<StandardEquipment> equipments;
    private LocalDate deadline;
    private String comment;

}
