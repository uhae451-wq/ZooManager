public class Dog extends Animal{
    public Dog(String name, int age){
        super(name,"개", age);
    }
    @Override
    void makeSound(){
        System.out.println("왈왈");
    }
}
