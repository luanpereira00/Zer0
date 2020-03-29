package commands;

/*
Enumeration of commands
*/
public enum ECommand {
    PING("PING"),
    ERROR("ERROR");

    private String displayName;

    //Constructor
    ECommand(String displayName) {
        this.displayName = displayName;
    }

    /*
    * Returns enum value
    *
    * @return the name
    */
    public String getName(){
        return this.toString();
    }
}
