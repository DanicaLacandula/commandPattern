public class Thermostat {
    private int temperature; // in Celsius

    public Thermostat(int initial) {
        this.temperature = initial;
    }

    public void increase(int delta) {
        temperature += delta;
        System.out.println("Thermostat increased to " + temperature + "°C");
    }

    public void decrease(int delta) {
        temperature -= delta;
        System.out.println("Thermostat decreased to " + temperature + "°C");
    }

    public void setTemperature(int temp) {
        temperature = temp;
        System.out.println("Thermostat set to " + temperature + "°C");
    }

    public int getTemperature() {
        return temperature;
    }
}
