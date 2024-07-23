package java_concepts;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * 
 * Many ways to create an object
 * 1. new keyword
 * 2. newInstance method
 * 3. clone
 * 4. deserialization
 * 
 */

class Info implements Cloneable, Serializable {

    String data;

    public Info() {
    }

    public Info(String data) {
        this.data = data;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class ObjectCreation {

    public static void main(String[] args)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, NoSuchMethodException, SecurityException, CloneNotSupportedException,
            IOException {

        // using new
        Info obj1 = new Info("INFO X");
        System.out.println(obj1.data);

        // using newInstance of constructor
        Info obj2 = Info.class.getDeclaredConstructor().newInstance();
        obj2.data = "sadiq";
        System.out.println(obj2.data);

        // using clone

        Info obj3 = (Info) obj2.clone();
        System.out.println(obj3.data);

        // deserialization

        FileOutputStream fileOutputStream = new FileOutputStream("obj.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(obj2);
        objectOutputStream.close();
        fileOutputStream.close();

        // now we will create object

        FileInputStream fileInputStream = new FileInputStream("obj.txt");
        ObjectInputStream ObjectInputStream = new ObjectInputStream(fileInputStream);
        Info readObject = (Info) ObjectInputStream.readObject();
        System.out.println(readObject.data);

    }
}
