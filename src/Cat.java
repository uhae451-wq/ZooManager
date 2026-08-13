public class Cat extends Animal implements Trainable{

    public Cat(String name, int age){
        super(name, AnimalType.CAT , age);
    }

    @Override
    public void intrudouce() {
        super.intrudouce();
    }

    @Override
    public void makeSound() {
        System.out.println("냥냥펀치");
    }

    @Override
    public void train(){
        System.out.println(super.getName() + " 훈련을 시작합니다. 앉아~ ");
    }
}
