import java.sql.ClientInfoStatus;
import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Animal> zoo = new ArrayList<>();
        Map<String, List<Animal>> keeperToAnimals = new HashMap<>();
        boolean running = true;   // 반복문 종료를 제어하는 플래그
        while (running) {
            try {
                System.out.println("===== 동물원 접수 =====");
                System.out.println("1. 동물 등록");
                System.out.println("2. 동물 정보 보기");
                System.out.println("3. 훈련 가능한 동물만 훈련시키기");
                System.out.println("4. 먹이주기");
                System.out.println("5. 동물 건강상태 변경");
                System.out.println("6. 사육사 관리 동물들 보기");
                System.out.println("7. 전체 사육사 목록");
                System.out.println("0. 종료");
                System.out.print("선택> ");

                int choice = sc.nextInt();
                sc.nextLine(); // 개행 문자 처리

                switch (choice) {
                    case 1:
                        try {
                            // TODO: 이름, 종류, 나이를 입력받아 name/species/age에 저장
                            // TODO: registered = true
                            System.out.println("1. 개 2. 고양이 3. 새");
                            int spce;
                            try {
                                spce = Integer.parseInt(sc.nextLine());
                                if (spce > 3 || spce < 0) {
                                    break;
                                }
                            } catch (Exception e) {
                                System.out.println("숫자를 입력해주세요.");
                                break;
                            }
                            System.out.print("2. 동물 이름 : ");
                            String name = sc.nextLine();

                            Set<String> alreayName = zoo.stream()
                                    .map(Animal::getName)
                                    .collect(Collectors.toSet());

                            if(alreayName.contains(name)){
                                throw new IllegalArgumentException("이미 등록된 이름입니다.");
                            }
                            System.out.print("3. 동물 나이 : ");
                            int age;
                            try {
                                age = Integer.parseInt(sc.nextLine());
                            } catch (Exception e) {
                                System.out.println("숫자를 입력해주세요.");
                                break;
                            }

                            Animal ani = null;
                            switch (spce) {
                                case 1:
                                    ani = new Dog(name, age);
                                    break;
                                case 2:
                                    ani = new Cat(name, age);
                                    break;
                                case 3:
                                    ani = new Bird(name, age);
                                    break;
                                default:
                                    System.out.println("잘못된 종류입니다.");
                            }
                            System.out.print("4. 사육사 이름 : ");
                            String userName = sc.nextLine();
                            keeperToAnimals.computeIfAbsent(userName, k -> new ArrayList<>()).add(ani);

                            zoo.add(ani);
                        } catch (IllegalArgumentException | IllegalStateException e) {
                            System.out.println("등록 실패: " + e.getMessage());
                        } finally {
                            System.out.println("[로그] 등록 요청 처리를 마칩니다");
                        }
                        break;
                    case 2:
                        // TODO: registered가 false면 안내 메시지 출력
                        // TODO: registered가 true면 정보 출력
                        if (zoo.size() == 0) {
                            System.out.println("동물이 없습니다.");
                            break;
                        } else {
                            zoo.forEach((z) -> z.intrudouce());
                        }
                        break;
                    case 3:
                        if (zoo.size() == 0) {
                            System.out.println("동물이 없습니다.");
                        } else {
                            for (Animal z : zoo ) {
                                if (z instanceof Trainable) {
                                    ((Trainable) z).train();
                                }
                            }
                        }
                        break;
                    case 4:
                        if (zoo.size() == 0) {
                            System.out.println("동물이 없습니다.");
                            break;
                        } else {
                            for (Animal z : zoo) {
                                if (z instanceof Feeable) {
                                    ((Feeable) z).feed("사료");
                                }
                            }
                        }
                        break;
                    case 5:
                        if (zoo.size() == 0) {
                            System.out.println("동물이 없습니다.");
                            break;
                        }
                        System.out.print("이름 입력 : ");
                        String name1 = sc.nextLine();
                        Animal nowHealth = null;
                        for (Animal z : zoo) {
                            if (z.getName().equals(name1)) {
                                nowHealth = z;
                                break;
                            }
                        }
                        if (nowHealth == null) {
                            System.out.println("찾는 동물이 없습니다.");
                            break;
                        }
                        HealthStatus[] healthCheck = HealthStatus.values();
                        for (int i = 0; i < healthCheck.length; i++) {
                            System.out.println(i + 1 + ". " + healthCheck[i]);
                        }
                        int nowCheck = Integer.parseInt(sc.nextLine());
                        nowHealth.setHealthStatus(healthCheck[nowCheck - 1]);
                        break;
                    case 6 :
                        if (zoo.size() == 0) {
                            System.out.println("동물이 없습니다.");
                            break;
                        }
                        System.out.print("사육사 이름 입력 : ");
                        String userName = sc.nextLine();
                        if(!keeperToAnimals.containsKey(userName)){
                            System.out.println("해당 사육사는 없습니다.");
                            break;
                        }
                        keeperToAnimals.entrySet().stream()
                                .filter(e -> e.getKey().equals(userName))
                                .forEach(e -> System.out.println(e.getValue()));
                        break;
                    case 7:
                        if(keeperToAnimals.size() == 0 ){
                            System.out.println("등록된 사육사가 없습니다.");
                        }
                        keeperToAnimals.forEach((keeper,animal)-> {
                            System.out.print(keeper + "님 담당 {");
                            animal.forEach((list) -> {
                                System.out.print("( 이름 : "+list.getName() + ", 나이 : " + list.getAge() + ") ");
                            });
                            System.out.println("}");
                        });
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
            }catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요");
                sc.nextLine(); // TODO: 버퍼 비우기 잊지 말 것
            }
        }
    }
}