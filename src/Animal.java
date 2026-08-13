public abstract class Animal {
    protected String name;
    protected String species;
    protected int age;

    public Animal(String name, String species, int age){
        this.name = name;
        this.species = species;
        this.age = age;
    }

    public void intrudouce(){
        System.out.println("저는 " + this.name + "입니다. 종류는 " + this.species + "이고 나이는 " + this.age + "살입니다.");
    }

    public abstract void makeSound();
}
