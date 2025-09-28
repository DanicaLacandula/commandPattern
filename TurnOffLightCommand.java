public class TurnOffLightCommand implements Command {
    private Light light;
    private int prevBrightness;

    public TurnOffLightCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        prevBrightness = light.getBrightness();
        light.off();
    }

    public void undo() {
        light.setBrightness(prevBrightness);
        System.out.println("Undo: restored light brightness to " + prevBrightness + "%");
    }
}
