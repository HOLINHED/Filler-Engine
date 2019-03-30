package filler.io;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("unused")
public abstract class Data implements Serializable {

    private String name;
    private Date date;

    public Data(String name) {
        this.name = name;

        date = new Date();
    }

    public String getName() {
        return name;
    }

    public String created() {
        DateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        return format.format(date);
    }

}
