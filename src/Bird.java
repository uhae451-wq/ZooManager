public class Bird extends Animal{
    public Bird(String name, int age){
        super(name, "새", age);
    }

    @Override
    public void makeSound() {
        System.out.println("짹짹");
    }
}
