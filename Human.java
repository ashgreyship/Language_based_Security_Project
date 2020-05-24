import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Human implements Externalizable {

    private String name;
    private int id;
    transient private boolean gender; // set a variable to be unserializable

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(id);
        out.writeObject(name + "encrypted");
        out.writeObject(gender);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException,
            ClassNotFoundException {
        id = in.readInt();
        if (id>200000000) throw new IOException("corrupted data");
        name = (String) in.readObject();
        if (!name.endsWith("encrypted")) throw new IOException("corrupted data");
        name = name.substring(0, name.length() - 9);
        gender = (boolean) in.readObject();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        if (gender)
            return "Name: " + name + "\nId: " + id + "\nGender: Female\n";
        else
            return "Name: " + name + "\nId: " + id + "\nGender: Male\n";
    }
}
