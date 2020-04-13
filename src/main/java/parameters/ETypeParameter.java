package parameters;

public enum ETypeParameter {
    REQUIRED("REQUIRED"),
    OPTIONAL("OPTIONAL"),
    UNUSED("UNUSED");

    private String displayName;

    //Constructor
    ETypeParameter(String displayName) {
        this.displayName = displayName;
    }

    /*
     * Returns enum value
     *
     * @return the name
     */
    public String getName(){
        return displayName;
    }
}
