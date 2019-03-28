package jeff;

public class A {
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
