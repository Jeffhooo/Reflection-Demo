import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionDemo {
    public static class A {
        private String name;
        private String value;

        private void setName(String name) {
            this.name = name;
        }

        private void setValue(String value) {
            this.value = value;
        }

        private void say() {
            System.out.println("Hello, My name is " + name + ".");
        }
    }

    public static void main(String[] args) {
        try {
            Class cls = Class.forName("ReflectionDemo$A");
            Method m[] = cls.getDeclaredMethods();
            System.out.println(Arrays.toString(m));
            A instance = (A) cls.newInstance();

            Field nameFld = cls.getDeclaredField("name");
            nameFld.setAccessible(true);
            nameFld.set(instance, "Jeff");

            Method sayMtd = cls.getDeclaredMethod("say", (Class[])null);
            sayMtd.setAccessible(true);
            sayMtd.invoke(instance, (Object[])null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
