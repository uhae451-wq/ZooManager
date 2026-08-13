public abstract class Animal {
    private String name;
    private AnimalType species;
    private int age;
    private HealthStatus healthStatus = HealthStatus.GOOD;

    public Animal(String name, AnimalType species, int age){
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
        if(this.healthStatus.equals(HealthStatus.QUARANTINE)){
            System.out.println("저는 " + this.name + "입니다. 종류는 " + this.species.getDisplayName() + "[격리중]이고 " +
                    "건강상태는 : " + this.healthStatus + "이며, " + "나이는 " + this.age + "살입니다.");
        }else {
            System.out.println("저는 " + this.name + "입니다. 종류는 " + this.species.getDisplayName() + "이고 " +
                    "건강상태는 : " + this.healthStatus + "이며, " + "나이는 " + this.age + "살입니다.");
        }
    }

    public abstract void makeSound();

    public String getName() {
        return name;
    }

    public AnimalType getSpecies() {
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

    public void setHealthStatus(HealthStatus healthStatus) {
        this.healthStatus = healthStatus;
    }

    public HealthStatus getHealthStatus() {
        return healthStatus;
    }
}

