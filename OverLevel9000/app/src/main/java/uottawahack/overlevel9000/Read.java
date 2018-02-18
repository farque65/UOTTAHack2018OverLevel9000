package uottawahack.overlevel9000;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Read {

	private String destination = "";
	private int lineNumber = 0;

	public Read(String destination) {
		this.destination = destination;
		try (BufferedReader reader = new BufferedReader(new FileReader(new File(destination)))) {
			while (reader.readLine() != null) {
				lineNumber++;
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

    public String readAll() {
        String total = "";
        try (BufferedReader br = new BufferedReader(new FileReader(new File(destination)))) {
            String line;

            while ((line = br.readLine()) != null) {
                total += line + "\n";
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + destination);
        } catch (IOException e) {
            System.out.println("Unable to read file: " + destination);
        }
        return total;
    }

}
