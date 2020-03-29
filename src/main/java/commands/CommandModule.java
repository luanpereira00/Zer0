package commands;

/*
* An enumeration of modules and category of commands
*/
public enum CommandModule {
    //MUSIC("Music"),
    //DEVELOPER("Developer"),
    //SETTINGS("Settings"),
    GENERAL("General");

    private String displayName;

    //Constructor
    CommandModule(String displayName) {
        this.displayName = displayName;
    }

    /*
    * Returns enum value / command module name
     */
    public String getName(){
        return this.toString();
    }
}