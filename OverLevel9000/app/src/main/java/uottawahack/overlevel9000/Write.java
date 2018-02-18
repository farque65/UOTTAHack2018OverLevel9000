package uottawahack.overlevel9000;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Write {

    private String destination = "";

    public Write(String destination){
        this.destination = destination;
    }

    public void write(String input){
        try(BufferedWriter br = new BufferedWriter(new FileWriter(new File(destination), true))){
            if (input != null){
                br.write(input);
                br.newLine();
            }
        } catch (FileNotFoundException e) {
            Log.d("FileWriteError", "File not found: " + destination);
        } catch (IOException e) {
            Log.d("FileWriteError", "Unable to read file: " + destination);
        }
    }

}
