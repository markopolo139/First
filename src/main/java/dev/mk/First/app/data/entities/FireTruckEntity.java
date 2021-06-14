package dev.mk.First.app.data.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "fire_trucks")
public class FireTruckEntity {

    @Id
    @GeneratedValue
    @Column(name = "fire_truck_id")
    public int fireTruckId;

    @Column(name = "name")
    public String name;

    @Column(name = "price")
    public double price;

    @Column(name = "vin")
    public String vin;

    @Column(name = "production_year")
    public int productionYear;

    @Column(name = "operational_numbers")
    public String operationalNumbers;

    @Column(name = "type")
    public String type;

    @Column(name = "horsepower")
    public int horsepower;

    @Column(name = "number_of_seats")
    public int numberOfSeats;

    @Column(name = "mileage")
    public int mileage;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "fire_truck_parameters", joinColumns = @JoinColumn(name = "fire_truck_id"))
    @Column(name = "fire_truck_id")
    public Collection<FireTruckParameterEntity> parameters;

    @ManyToMany
    @JoinTable(name = "fire_trucks_in_action",
                joinColumns = {@JoinColumn(name = "fire_truck_id")},
                inverseJoinColumns = {@JoinColumn(name = "call_id")})
    public Collection<CallsEntity> callsFT;

    public FireTruckEntity() {
    }

    public FireTruckEntity(String name, double price, String vin, int productionYear, String operationalNumbers,
                           String type, int horsepower, int numberOfSeats, int mileage)
    {
        this.name = name;
        this.price = price;
        this.vin = vin;
        this.productionYear = productionYear;
        this.operationalNumbers = operationalNumbers;
        this.type = type;
        this.horsepower = horsepower;
        this.numberOfSeats = numberOfSeats;
        this.mileage = mileage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FireTruckEntity that = (FireTruckEntity) o;
        return fireTruckId == that.fireTruckId
                && Double.compare(that.price, price) == 0
                && productionYear == that.productionYear
                && horsepower == that.horsepower && numberOfSeats == that.numberOfSeats
                && mileage == that.mileage && name.equals(that.name)
                && vin.equals(that.vin)
                && operationalNumbers.equals(that.operationalNumbers)
                && type.equals(that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fireTruckId, name, price, vin, productionYear, operationalNumbers, type, horsepower,
                numberOfSeats, mileage);
    }
}
