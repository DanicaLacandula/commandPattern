public class IncreaseTempCommand implements Command {
    private Thermostat thermostat;
    private int delta;

    public IncreaseTempCommand(Thermostat t, int delta) {
        this.thermostat = t;
        this.delta = delta;
    }

    public void execute() {
        thermostat.increase(delta);
    }

    public void undo() {
        thermostat.decrease(delta);
        System.out.println("Undo: decreased thermostat by " + delta + "°C");
    }
}
