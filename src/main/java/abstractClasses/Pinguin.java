package abstractClasses;

public class Pinguin extends Bird{

    public Pinguin(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println("I'm not very good at that, can i go for a swim instead.");
    }
}
