package dev.mk.First.app.data.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "equipment")
public class EquipmentEntity {

    @Id
    @GeneratedValue
    @Column(name = "equipment_id")
    public int equipmentId;

    @Column(name = "name")
    public String name;

    @Column(name = "price")
    public double price;

    @Column(name = "serial_number")
    public String serialNumber;

    public EquipmentEntity(String name, double price, String serialNumber) {
        this.name = name;
        this.price = price;
        this.serialNumber = serialNumber;
    }

    public EquipmentEntity() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquipmentEntity that = (EquipmentEntity) o;
        return equipmentId == that.equipmentId && Double.compare(that.price, price) == 0
                && name.equals(that.name) && serialNumber.equals(that.serialNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equipmentId, name, price, serialNumber);
    }
}
