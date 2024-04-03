package home.classes;

public class Car {
    private String model;
    private String made;

    public Car() {
    }

    public Car(String model, String made) {
        this.model = model;
        this.made = made;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMade() {
        return made;
    }

    public void setMade(String made) {
        this.made = made;
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("model", model)
                .append("made", made)
                .toString();
    }
}
