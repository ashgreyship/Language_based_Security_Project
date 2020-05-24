import java.io.*;

public class SerializationUtil {
    public static void serialize(Object obj, String path)
            throws IOException {
        FileOutputStream file = new FileOutputStream(path);
        ObjectOutputStream output = new ObjectOutputStream(file);
        output.writeObject(obj);
        output.close();
    }

    public static Object deserialize(String path) throws IOException,
            ClassNotFoundException {
        FileInputStream file = new FileInputStream(path);
        ObjectInputStream input = new ObjectInputStream(file);
        Object obj = input.readObject();
        input.close();
        return obj;
    }


}