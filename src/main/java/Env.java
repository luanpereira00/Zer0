import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.HashMap;

public class Env {
    private HashMap<String,String> hashEnv;

    Env(){
        hashEnv = new HashMap<>();
        startENV();
    }

    String getEnv(String key){
        return hashEnv.get(key);
    }

    private void startENV() {
        BufferedReader objReader = null;
        try {
            String strCurrentLine;
            objReader = new BufferedReader(new FileReader("./assets/env"));

            while ((strCurrentLine = objReader.readLine()) != null) {
                String[] line = strCurrentLine.split("=");
                if(line.length==2){
                    hashEnv.put(line[0],line[1]);
                    System.out.println(Arrays.toString(line)+" added to the env hashmap!");
                }else {
                    System.out.println(Arrays.toString(line)+" no longer is an env pattern... nothing done!");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objReader != null)
                    objReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
