package commands;

public enum CommandCategory {
    MUSIC("Music"),
    DEVELOPER("Developer"),
    SETTINGS("Settings"),
    GENERAL("General");

    private String displayName;

    CommandCategory(String displayName) {
        this.displayName = displayName;
    }

    String getName(){
        return this.toString();
    }
}