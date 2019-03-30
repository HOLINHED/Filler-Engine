package filler.io;

import java.io.*;

public class File<T> {

    private static final String PATH = "./save/";
    private static final String EXTENSION = ".fdat";

    private Data data;

    public File(final String path) {

        data = load(path);
    }

    public File(final T data) {
        this.data = (Data) data;

        save();
    }

    public void save() {
        try {
            save(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public T data() {
        return (T) this.data;
    }

    public static void save(final Data data) throws IOException {

        try {

            java.io.File dir = new java.io.File(PATH);
            if (!dir.exists()) dir.mkdir();

            FileOutputStream saveFile = new FileOutputStream(PATH + data.getName() + EXTENSION);
            ObjectOutputStream save = new ObjectOutputStream(saveFile);

            save.writeObject(data);

            save.close();
            System.out.println("[FILLER] Data save complete! " + data.getName() + EXTENSION);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static Data load(final String name) {

        Data data = null;

        try {

            FileInputStream saveFile = new FileInputStream(PATH + name + EXTENSION);
            ObjectInputStream restore = new ObjectInputStream(saveFile);

            data = (Data) restore.readObject();

            restore.close();
            System.out.println("[FILLER] Load complete! " + name + EXTENSION);


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return data;

    }

}
