public class SetBrightnessCommand implements Command {
    private Light light;
    private int prevLevel;
    private int newLevel;

    public SetBrightnessCommand(Light light, int level) {
        this.light = light;
        this.newLevel = level;
    }

    public void execute() {
        prevLevel = light.getBrightness();
        light.setBrightness(newLevel);
    }

    public void undo() {
        light.setBrightness(prevLevel);
        System.out.println("Undo: restored brightness to " + prevLevel + "%");
    }
}
