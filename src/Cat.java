public class Cat extends Animal{

    public Cat(String name, int age){
        super(name, "고양이" , age);
    }

    @Override
    void makeSound() {
        System.out.println("냥냥펀치");
    }
}
