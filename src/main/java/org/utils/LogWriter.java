package org.utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;

public class LogWriter <T extends Serializable>{

    private String directory;

    private final static Logger LOGGER = Logger.getLogger(LogWriter.class.getName());

    public LogWriter() {
        this.directory = System.getProperty("user.dir") + "/logs";
        System.out.println(directory);
        new File(directory).mkdir();
    }

    public void write(UUID transactionId, TransactionContext transactionContext){
        File file = new File(directory + "/" + transactionId.toString() + ".txt");
        file.getParentFile().mkdirs(); // create directory if not already created

        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            // Write object to file
            objectOutputStream.writeObject(transactionContext);
            LOGGER.log(Level.INFO, "The transactionContext was logged in the File: " + file.getPath());
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.SEVERE, "The File " + file.getPath() + "was not found!", e);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "There was an error with the IOStream", e);
        }
    }

    public void delete(UUID transactionId){
        File file = new File(directory + "/" + transactionId + ".txt");

        if (file.delete()) {
            // Delete the file of the corresponding transactionId
            LOGGER.log(Level.INFO, "The File with the transactionId: " + transactionId + "was successfully deleted from the Logs!");
        } else {
            // Log if deletion failed
            LOGGER.log(Level.SEVERE, "The File with the transactionId: " + transactionId + "couldn't be removed");
        }
    }

}
