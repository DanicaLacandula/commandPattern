public class DecreaseTempCommand implements Command {
    private Thermostat thermostat;
    private int delta;

    public DecreaseTempCommand(Thermostat t, int delta) {
        this.thermostat = t;
        this.delta = delta;
    }

    public void execute() {
        thermostat.decrease(delta);
    }

    public void undo() {
        thermostat.increase(delta);
        System.out.println("Undo: increased thermostat by " + delta + "°C");
    }
}
