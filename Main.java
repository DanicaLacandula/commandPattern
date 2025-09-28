import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();

        // Receivers
        Light livingRoomLight = new Light("Living Room");
        Thermostat thermostat = new Thermostat(22);
        MusicPlayer player = new MusicPlayer();

        // Commands
        TurnOnLightCommand livingRoomOn = new TurnOnLightCommand(livingRoomLight);
        TurnOffLightCommand livingRoomOff = new TurnOffLightCommand(livingRoomLight);
        IncreaseTempCommand tempUp = new IncreaseTempCommand(thermostat, 2);
        DecreaseTempCommand tempDown = new DecreaseTempCommand(thermostat, 2);
        PlayMusicCommand playHits = new PlayMusicCommand(player, "Top Hits");
        StopMusicCommand stopMusic = new StopMusicCommand(player);

        // Assign to remote slots
        remote.setCommand(0, livingRoomOn, livingRoomOff);
        remote.setCommand(1, tempUp, tempDown);
        remote.setCommand(2, playHits, stopMusic);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Smart Home Remote ===");
            System.out.println("1. Turn ON Living Room Light");
            System.out.println("2. Turn OFF Living Room Light");
            System.out.println("3. Set Light Brightness");
            System.out.println("4. Increase Temp");
            System.out.println("5. Decrease Temp");
            System.out.println("6. Play Music");
            System.out.println("7. Stop Music");
            System.out.println("8. Undo Last Command");
            System.out.println("9. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> remote.pressOn(0);
                case 2 -> remote.pressOff(0);
                case 3 -> {
                    System.out.print("Enter brightness (0-100): ");
                    int level = scanner.nextInt();
                    SetBrightnessCommand brightnessCommand = new SetBrightnessCommand(livingRoomLight, level);
                    brightnessCommand.execute();
                }
                case 4 -> remote.pressOn(1);
                case 5 -> remote.pressOff(1);
                case 6 -> remote.pressOn(2);
                case 7 -> remote.pressOff(2);
                case 8 -> remote.pressUndo();
                case 9 -> running = false;
                default -> System.out.println("Invalid choice.");
            }
        }

        scanner.close();
        System.out.println("Smart Home System shutting down...");
    }
}
