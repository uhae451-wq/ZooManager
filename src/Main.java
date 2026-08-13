import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Animal[] zoo = new Animal[10];
        int count = 0;
        boolean running = true;   // 반복문 종료를 제어하는 플래그

        while (running) {
            System.out.println("===== 동물원 접수 =====");
            System.out.println("1. 동물 등록");
            System.out.println("2. 동물 정보 보기");
            System.out.println("3. 훈련 가능한 동물만 훈련시키기");
            System.out.println("4. 먹이주기");
            System.out.println("0. 종료");
            System.out.print("선택> ");

            int choice = sc.nextInt();
            sc.nextLine(); // 개행 문자 처리

            switch (choice) {
                case 1:
                    if(count == zoo.length){
                        System.out.println("동물 입력횟수 초과(시스템 종료)");
                        break;
                    }
                    // TODO: 이름, 종류, 나이를 입력받아 name/species/age에 저장
                    // TODO: registered = true
                    System.out.println("1. 개 2. 고양이 3. 새");
                    int spce;
                    try{
                        spce = Integer.parseInt(sc.nextLine());
                        if(spce > 3 || spce < 0 ){
                            break;
                        }
                    }catch (Exception e){
                        System.out.println("숫자를 입력해주세요.");
                        break;
                    }
                    System.out.print("2. 동물 이름 : ");
                    String name = sc.nextLine();
                    System.out.print("3. 동물 나이 : ");
                    int age;
                    try {
                        age = Integer.parseInt(sc.nextLine());
                    }catch (Exception e){
                        System.out.println("숫자를 입력해주세요.");
                        break;
                    }
                    Animal ani = null;
                    switch (spce){
                        case 1 : ani = new Dog(name,age);
                        break;
                        case 2 : ani = new Cat(name,age);
                        break;
                        case 3 : ani = new Bird(name,age);
                        break;
                        default: System.out.println("잘못된 종류입니다.");
                    }
                    zoo[count++] = ani;
                    break;
                case 2:
                    // TODO: registered가 false면 안내 메시지 출력
                    // TODO: registered가 true면 정보 출력
                    if(count == 0){
                        System.out.println("동물이 없습니다.");
                    }else {
                        for(int i=0; i<count; i++){
                            zoo[i].intrudouce();
                            zoo[i].makeSound();
                        }
                    }
                    break;
                case 3:
                    if(count == 0){
                        System.out.println("동물이 없습니다.");
                    }else {
                        for(int i=0; i<count; i++){
                            if(zoo[i] instanceof Trainable){
                                ((Trainable) zoo[i]).train();
                            }
                        }
                    }
                    break;
                case 4:
                    if(count == 0){
                        System.out.println("동물이 없습니다.");
                    }else {
                        for(int i=0; i<count; i++){
                            if(zoo[i] instanceof Feeable){
                                ((Feeable) zoo[i]).feed("사료");
                            }
                        }
                    }
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다");
                    // TODO: 반복문을 빠져나가려면 여기서 무엇을 해야 할까요?
                    running = false;
                    break;
                default:
                    // TODO: 잘못된 입력 처리
                    System.out.println("등록되지 않은 처리입니다. 다시 입력해주세요.");
            }
        }
    }
}