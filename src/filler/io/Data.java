package filler.io;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Data implements Serializable {

    private String name;
    private Date date;
    private transient Thread thread;

    public Data(String name) {
        this.name = name;

        date = new Date();
        thread = new Thread();
    }

    public String getName() {
        return name;
    }

    public String created() {
        DateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        return format.format(date);
    }

}
