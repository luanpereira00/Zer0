package commands;

public enum ECommand {
    PING("PING"),
    ERROR("ERROR");

    private String displayName;

    ECommand(String displayName) {
        this.displayName = displayName;
    }

    public String getName(){
        return this.toString();
    }
}
