package filler.io;

import java.io.*;

/**
 * An object oriented wrapper for the static save/load methods. Whenever
 * either constructor is called, the data is automatically loaded or saved.
 * it provides a method for saving so data could be updated, and a get method
 * that returns the data it has saved.
 *
 * @param <T> The type of data being saved. Has to extend filler.io.Data.
 *
 * @author Dawid klatkiewicz
 */

@SuppressWarnings("WeakerAccess")
public class File<T extends Data> {

    private static final String PATH = "./save/";
    private static final String EXTENSION = ".fdat";

    private T data;

    public File(final String path) {

        //noinspection unchecked
        data = (T)load(path);
    }

    public File(final T data) {
        this.data = data;

        save();
    }

    public void save() {
        try {
            save(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public T data() {
        return this.data;
    }

    /* ============================================= Static methods ================================================ */

    /**
     * @param data The class to be saved. Has to extend Data. Automatically
     *             creates ./save directory if it doesn't exist.
     *
     * @throws IOException Throws if save directory doesn't exist.
     */
    public static void save(final Data data) throws IOException {

        try {

            // Checks to make sure save directory exists, it not, make it.
            java.io.File dir = new java.io.File(PATH);
            if (!dir.exists()) //noinspection ResultOfMethodCallIgnored
                dir.mkdir();

            // Creating save file
            FileOutputStream saveFile = new FileOutputStream(PATH + data.getName() + EXTENSION);
            ObjectOutputStream save = new ObjectOutputStream(saveFile);

            // Writing data to file
            save.writeObject(data);

            // Finalizes
            save.close();
            System.out.println("[FILLER] Data save complete! " + data.getName() + EXTENSION);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * @param name The name of the file to load without path or extension.
     *
     * @return The loaded file. Has to be cast back to it's original format.
     */
    public static Data load(final String name) {

        // Data reference to return
        Data data = null;

        try {

            // Loads file
            FileInputStream saveFile = new FileInputStream(PATH + name + EXTENSION);
            ObjectInputStream restore = new ObjectInputStream(saveFile);

            // Read data from file
            data = (Data) restore.readObject();

            // Finalizes
            restore.close();
            System.out.println("[FILLER] Load complete! " + name + EXTENSION);


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Returns data
        return data;

    }

}
