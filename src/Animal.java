public abstract class Animal {
    private String name;
    private String species;
    private int age;

    public Animal(String name, String species, int age){
        this.name = name;
        this.species = species;
        if(age < 0) {
            System.out.println("나이가 잘못 기입되어 0으로 보정합니다.");
            this.age = 0;
        }else {
            this.age = age;
        }
    }

    public void intrudouce(){
        System.out.println("저는 " + this.name + "입니다. 종류는 " + this.species + "이고 나이는 " + this.age + "살입니다.");
    }

    public abstract void makeSound();

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 0){
            System.out.println("나이를 잘못 입력하였습니다.");
        }else {
            this.age = age;
        }
    }
}
