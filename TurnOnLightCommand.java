public class TurnOnLightCommand implements Command {
    private Light light;
    private int prevBrightness;

    public TurnOnLightCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        prevBrightness = light.getBrightness();
        light.on();
        light.setBrightness(75); // comfortable brightness
    }

    public void undo() {
        light.setBrightness(prevBrightness);
        if (prevBrightness == 0) {
            light.off();
        } else {
            System.out.println("Undo: restored light brightness to " + prevBrightness + "%");
        }
    }
}
