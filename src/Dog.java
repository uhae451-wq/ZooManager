public class Dog extends Animal implements Trainable, Feeable{
    public Dog(String name, int age){
        super(name,"개", age);
    }
    @Override
    public void makeSound(){
        System.out.println("왈왈");
    }

    @Override
    public void feed(String food) {
        System.out.println(this.name + "에게 먹이를 줍니다: " + food);
    }

    @Override
    public void train() {
        System.out.println(this.name + " 훈련을 시작합니다. 앉아~ ");
    }
}
