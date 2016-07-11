package pl.rafalszyszka.stoper.model;

import android.content.Context;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Squier on 2016-07-10.
 */
public class Serialize {

    public static void saveObject(Object o, String filename, Context context) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(context.openFileOutput(filename, Context.MODE_WORLD_READABLE));
        oos.writeObject(o);
        oos.close();
    }

    public static Object restoreObject(String filename, Context context) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(context.openFileInput(filename));
        return ois.readObject();
    }

}
