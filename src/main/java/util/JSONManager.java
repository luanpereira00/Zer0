package util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import commands.CommandModule;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/*
* JSONManager is a Singleton that manager all process relative to text content of bot
*/
public class JSONManager {
    //Singleton Instance
    private static JSONManager uniqueInstance;

    //JSON file instance in memory - needed to improve performance
    private Map<String, Map<String, String>> textContent;

    /*
    * Private constructor of Singleton
    */
    private JSONManager (){
        readAllJSON();
    }

    /*
    * Return Singleton Instance
    */
    public static synchronized JSONManager getInstance() {
        if (uniqueInstance == null) uniqueInstance = new JSONManager();

        return uniqueInstance;
    }

    /*
    * Get default separator of directory in current S.O.
    */
    private String getSeparator(){
        return System.getProperty("file.separator");
    }


    /*
    * Get a String of Language + Separator + CommandModule
    * @param language The current server language
    * @param module The category of the command
    */
    private String getLangSepModule(ELanguage language, CommandModule module){
        return language.getName()+getSeparator()+module.getName();
    }

    /*
    * Get all JSONs in memory
    */
    public Map<String, Map<String, String>> getJSONs(){
        return textContent;
    }

    /*
    * Set JSONs to a global variable
    */
    private void setJSONs(Map<String, Map<String, String>> manager) {
        textContent = manager;
    }

    /*
    * Read all JSON on path, in all valid languages, in all valid modules
    */
    public void readAllJSON() {
        ELanguage[] languages = ELanguage.values();
        CommandModule[] modules = CommandModule.values();

        Map<String, Map<String, String>> manager = new HashMap<String, Map<String, String>>();

        final String path_project = new File("").getAbsolutePath();
        //TODO dynamic 'languages' -> probably on ENV
        String path=path_project+getSeparator()+"languages"+getSeparator();

        for(ELanguage language : languages){
            for(CommandModule module : modules){
                String file = path+language+getSeparator()+module+getSeparator();
                System.out.println("I'm going to read JSON from "+file);
                Map<String, String> hashMap = readJSONAsMap(file);
                if(hashMap != null) manager.put(getLangSepModule(language,module),hashMap);
            }
        }
        setJSONs(manager);
    }

    /*
    * Read a JSON File and auto convert it to a Java Map
    * @param jsonFile The JSON file that shall be read
    */
    private Map<String, String> readJSONAsMap(String jsonFile) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> hashMap = null;
        try {
            hashMap = mapper.readValue(new File(
                    jsonFile+"/TextContent.json"), new TypeReference<Map<String, String>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return hashMap;
    }

    /*
    * Get the content of some key on JSONs
    * @param language The language to return content
    * @param module The module where the content is
    * @param key The key in JSON
    *
    * @return The content as string
    */
    public String getTextContent(ELanguage language, CommandModule module, TextContent key) {
       String result = "";
        try{
            result = getContentOnJSON(key,language,module);
        } catch (Exception e){
            e.printStackTrace();
            result = "";
        }
        return result;
    }

    /*
    * Try get content of JSON using a key, if exists
    * If key is not on language, try get it on ELanguage.DEFAULT
    *
    * @param language The language to return content
    * @param module The module where the content is
    * @param key The key in JSON
    *
    * @return The content as string
    */
    private String getContentOnJSON(TextContent key, ELanguage language, CommandModule module) {
        String content = tryGetKeyOn(key, getLangSepModule(language,module));
        if(content != null && !content.equals(null)) return content;
        System.err.println("Tried to get a value that do not exists on JSON. FIX IT!\n"
                +"Language: "+language+"\n"
                +"Module: "+module+"\n"
                +"Key-Value: "+key);
        content = tryGetKeyOn(key, getLangSepModule(language.getDefault(),module));
        if(content == null || content.equals(null)) {
            content = "";
            System.err.println("Tried to get a value that do not exists on JSON. FIX IT!\n"
                                +"Language: "+language+"\n"
                                +"Module: "+module+"\n"
                                +"Key-Value: "+key);
        }
        return content;
    }

    /*
     * Try get content of JSON using a key, if exists
     *
     * @param langXMod Value of Language x Module
     * @param key The key in JSON
     *
     * @return The content as string
     */
    private String tryGetKeyOn(TextContent key, String langXMod) {
        String result = "";
        Map map = getJSONs().getOrDefault(langXMod,null);
        if(map!=null) {
            result = (String) map.getOrDefault(key.getName(),null);
        }
        return result;
    }
}
