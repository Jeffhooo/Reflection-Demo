package jeff;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionDemo {

    public static void main(String[] args) {
        try {
            // Load class with ClassLoader
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            Class cls = loader.loadClass("jeff.A");

            // Get class methods with reflection
            Method m[] = cls.getDeclaredMethods();
            System.out.println(Arrays.toString(m));

            // Create a instance with reflection
            A instance = (A) cls.newInstance();

            // Set fields with reflection
            Field nameFld = cls.getDeclaredField("name");
            nameFld.setAccessible(true);
            nameFld.set(instance, "Jeff");

            // Invoke a method with reflection
            Method sayMtd = cls.getDeclaredMethod("say", (Class[])null);
            sayMtd.setAccessible(true);
            sayMtd.invoke(instance, (Object[])null);

//          The console output:
//          [private void jeff.A.say(), private void jeff.A.setName(java.lang.String), private void jeff.A.setValue(java.lang.String)]
//          Hello, My name is Jeff.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
