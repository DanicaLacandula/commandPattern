public class RemoteControl {
    private Command[] onCommands;
    private Command[] offCommands;
    private Command undoCommand;
    private static final int SLOTS = 7;

    public RemoteControl() {
        onCommands = new Command[SLOTS];
        offCommands = new Command[SLOTS];

        Command noCommand = new NoCommand();
        for (int i = 0; i < SLOTS; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        if (slot < 0 || slot >= SLOTS) throw new IllegalArgumentException("Invalid slot");
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void pressOn(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void pressOff(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    public void pressUndo() {
        undoCommand.undo();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n----- Remote Control -----\n");
        for (int i = 0; i < SLOTS; i++) {
            sb.append("[slot " + i + "] " + onCommands[i].getClass().getName()
                      + "    " + offCommands[i].getClass().getName() + "\n");
        }
        return sb.toString();
    }
}
