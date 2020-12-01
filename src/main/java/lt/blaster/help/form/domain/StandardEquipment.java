package lt.blaster.help.form.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class StandardEquipment {

    private int id;
    private String name;
    private String imageUrl;

    public StandardEquipment(String name) {
        this.name = name;
        imageUrl = name;
    }

    public static List<StandardEquipment> mockStandardEquipment() {
        List<StandardEquipment> standardEquipments = new ArrayList<>();

        standardEquipments.add(new StandardEquipment("Standart headset (Logitech H570e)"));
        standardEquipments.add(new StandardEquipment("Standart monitor (Dell U2415)"));
        standardEquipments.add(new StandardEquipment("Standart wireless combo keyboard+mouse big (Logitech K270+M705)"));
        standardEquipments.add(new StandardEquipment("Standart wireless combo keyboard+mouse small (Logitech K270+M185)"));
        standardEquipments.add(new StandardEquipment("Standart wireless keyboard (Logitech K270)"));
        standardEquipments.add(new StandardEquipment("Standart wireless mouse big (Logitech M705)"));
        standardEquipments.add(new StandardEquipment("Standart wireless mouse small (Logitech M185)"));

        return standardEquipments;
    }

    @Override
    public String toString() {
        return "StandardEquipment{" +
                "name='" + name + '\'' +
                '}';
    }
}
