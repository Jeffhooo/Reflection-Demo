package jeff;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionDemo {

    public static void main(String[] args) {
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            Class cls = loader.loadClass("jeff.A");
            Method m[] = cls.getDeclaredMethods();
            System.out.println(Arrays.toString(m));
            A instance = (A) cls.newInstance();

            Field nameFld = cls.getDeclaredField("name");
            nameFld.setAccessible(true);
            nameFld.set(instance, "Jeff");

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
