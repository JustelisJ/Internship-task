package lt.blaster.help.form.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class EquipmentOrder {

    private List<StandardEquipment> equipments;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deadline;
    private String comment;

    public EquipmentOrder() {
        equipments = new ArrayList<>();
    }
}
