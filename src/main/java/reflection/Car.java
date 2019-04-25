package reflection;

public class Car {
    @Writable
    private String name;

    @Writable
    private String colour;
    private Integer power;

    @Writable
    private String owner;

    public Car() {
    }

    public Car(String name, String colour, Integer power, String owner) {
        this.name = name;
        this.colour = colour;
        this.power = power;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
