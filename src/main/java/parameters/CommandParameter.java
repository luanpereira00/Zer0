package parameters;

import java.util.ArrayList;
/*
* Describes how a command parameter is
*/
public abstract class CommandParameter {
    protected ETypeParameter typeParameter; //Type of this parameter -> REQUIRED, OPTIONAL, UNUSED
    protected int numberValue;
    //TODO Generify to enumeration of values -> TextValue, ChannelID, UserID, etc.
    protected ArrayList<String> values;

    //GETTER
    public ETypeParameter getTypeParameter() {
        return typeParameter;
    }

    //SETTER
    protected void setTypeParameter(ETypeParameter typeParameter) {
        this.typeParameter = typeParameter;
    }

    //GETTER
    public int getNumberValue() {
        return numberValue;
    }

    //SETTER
    protected void setNumberValue(int numberValue) {
        this.numberValue = numberValue;
    }

    //GETTER
    public ArrayList<String> getValues() {
        return values;
    }

    //SETTER
    protected void setValues(ArrayList<String> values) {
        this.values = values;
    }

    /*
    * @return true if a commandParameter is required, false otherwise
    */
    public boolean isRequired(){
        return getTypeParameter().equals(ETypeParameter.REQUIRED);
    }
}
