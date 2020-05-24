import java.io.IOException;

public class SerializationDemo {

    public static void main(String[] args) {
       /* try {
            serializeObject();
        }catch (IOException e) {
            e.printStackTrace();
        }*/
        try {
            deserializeObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void serializeObject() throws IOException {
        Human person = new Human();
        person.setId(123456789);
        person.setName("Alice");
        person.setGender(true);
        SerializationUtil.serialize(person, "serializedObject.output");
        System.out.println(person);
    }

    public static void deserializeObject() throws IOException, ClassNotFoundException {
        //Human person2 = (Human) SerializationUtil.deserialize("serializedObject.output");
        Human person2 = (Human) SerializationUtil.deserialize("rebuilt");

        System.out.println(person2);
    }
}