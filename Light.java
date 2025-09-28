public class Light {
    private String location;
    private int brightness; // 0 - 100

    public Light(String location) {
        this.location = location;
        this.brightness = 0;
    }

    public void on() {
        brightness = 100;
        System.out.println(location + " light is ON at brightness " + brightness + "%");
    }

    public void off() {
        brightness = 0;
        System.out.println(location + " light is OFF");
    }

    public void setBrightness(int level) {
        brightness = Math.max(0, Math.min(100, level));
        System.out.println(location + " light brightness set to " + brightness + "%");
    }

    public int getBrightness() {
        return brightness;
    }
}
