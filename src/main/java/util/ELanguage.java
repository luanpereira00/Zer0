package commands;
/*
* Enumeration with languages in bot
*/
public enum ELanguage {
    PT_BR("PT_BR"), //Portuguese - Brazil
    EN_US("EN_US"); //English - United States

    private String displayName;

    /*
    * Constructor
    */
    ELanguage(String displayName) {
        this.displayName = displayName;
    }

    /*
    * Get name of Enum
    */
    public String getName(){
        return this.toString();
    }

    /*
    * Get default ENUM : Portuguese Brazil
    */
    public ELanguage getDefault(){ return PT_BR; }
}
