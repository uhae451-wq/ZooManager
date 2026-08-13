public class Bird extends Animal implements Feeable{

    public Bird(String name, int age){
        super(name, AnimalType.BIRD, age);
    }

    @Override
    public void intrudouce() {
        super.intrudouce();
    }

    @Override
    public void makeSound() {
        System.out.println("짹짹");
    }

    @Override
    public void feed(String food) {
        System.out.println(super.getName() +"에게 먹이를 줍니다: " + food);
    }
}
