import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = null;
        String species = null;
        int age = 0;
        boolean registered = false;
        boolean running = true;   // 반복문 종료를 제어하는 플래그

        while (running) {
            System.out.println("===== 동물원 접수 =====");
            System.out.println("1. 동물 등록");
            System.out.println("2. 동물 정보 보기");
            System.out.println("0. 종료");
            System.out.print("선택> ");

            int choice = sc.nextInt();
            sc.nextLine(); // 개행 문자 처리

            switch (choice) {
                case 1:
                    // TODO: 이름, 종류, 나이를 입력받아 name/species/age에 저장
                    // TODO: registered = true
                    System.out.println("1. 동물 이름 등");
                    name = sc.nextLine();
                    System.out.println("2. 동물 종 등록");
                    species = sc.nextLine();
                    System.out.println("3. 동물 나이 등록");
                    age = Integer.parseInt(sc.nextLine());
                    registered = true;
                    break;
                case 2:
                    // TODO: registered가 false면 안내 메시지 출력
                    // TODO: registered가 true면 정보 출력
                    if(registered){
                        System.out.println(name);
                        System.out.println(species);
                        System.out.println(age);
                    }else {
                        System.out.println("동물이 없습니다.");
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