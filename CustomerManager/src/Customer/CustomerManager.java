package Customer;

import java.util.Scanner;

public class CustomerManager {

    // 기본 입력장치로부터 데이터를 입력받기 위해 Scanner객체 생성
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
    	
    	// 고객 배열
    	CustomerList list = new CustomerList();
    	
        while (true) {
        	printMenu(list);
            String menu = scan.next();
            menu = menu.toLowerCase(); // 입력한 문자열을 모두소문자로 변환
            switch (menu.charAt(0)) {
                case 'i':
                	insertCustomerData(list);
                    break;
                case 'p':
                    System.out.println("이전 데이터를 출력합니다.");
                    if (list.getIndex() < 0) {
                        System.out.println("이전 데이터가 존재하지 않습니다.");
                    } else {
                        list.setIndex(list.getIndex() - 1);
                        printCustomerData();
                    }
                    break;
                case 'n':
                    System.out.println("다음 데이터를 출력합니다.");
                    if (list.getIndex() >= list.getCount() - 1) {
                        System.out.println("다음 데이터가 존재하지 않습니다.");
                    } else {
                        list.setIndex(list.getIndex() + 1);
                        printCustomerData();
                    }
                    break;
                case 'c':
                    System.out.println("현재 데이터를 출력합니다.");
                    if ((list.getIndex() >= 0) && (list.getIndex() < list.getCount())) {
                    	printCustomerData();
                    } else {
                        System.out.println("출력할 데이터가 선택되지 않았습니다.");
                    }
                    break;
                case 'u':
                	updateCustomerData(list);
                    break;
                case 'd':
                	deleteCustomerData(list);
                    break;
                case 'q':
                    System.out.println("프로그램을 종료합니다.");
                    scan.close(); // Scanner 객체를 닫아준다.
                    System.exit(0); // 프로그램을 종료시킨다.
                    break;
                default:
                    System.out.println("메뉴를 잘 못 입력했습니다.");
            }// end switch
        } // end while
    }// end main

    // 메뉴 출력
    public static void printMenu(CustomerList list) {
    	System.out.printf("\n[INFO] 고객 수 : %d, 인덱스(위치) : %d\n", list.getClass(), list.getIndex());
        System.out.println("메뉴를 입력하세요.");
        System.out.println("(I)nsert, (P)revious, (N)ext, " + "(C)urrent, (U)pdate, (D)elete, (Q)uit");
        System.out.print("메뉴 입력: ");
    }
    
    // 고객데이터 입력
    public static void insertCustomerData(CustomerList list) {
    	System.out.println("고객정보 입력을 시작합니다.");
        if (list.getCount() >= list.getMAX()) {
            System.out.println("더 이상 저장할 수 없습니다.");
        } else {
            System.out.print("이름 : ");
            String name = scan.next();
            System.out.print("성별(M/F) : ");
            char gender = scan.next().charAt(0);
            System.out.print("이메일 : ");
            String email = scan.next();
            System.out.print("출생년도 : ");
            int birthYear = scan.nextInt();

            // 고객 객체를 배열에 저장
            // count 번째 배열에 객체 저장 후 count 값을 증가시켜야 함
            nameList[count] = name;
            genderList[count] = gender;
            emailList[count] = email;
            birthYearList[count] = birthYear;
            index = count-1;
            count++;
            System.out.println("고객정보를 저장했습니다.");
        }
    }

    // 고객데이터 출력
    public static void printCustomerData() {
    	System.out.println("==========CUSTOMER INFO================");
        System.out.println("이름 : " + nameList[index]);
        System.out.println("성별 : " + genderList[index]);
        System.out.println("이메일 : " + emailList[index]);
        System.out.println("출생년도 : " + birthYearList[index]);
        System.out.println("=======================================");
    }

    // index 위치의 고객정보를 삭제합니다.
    public static void deleteCustomerData(CustomerList list) {
    	System.out.println("데이터를 삭제합니다.");
        if ((list.getIndex() >= 0) && (list.getIndex() < list.getCount())) {
            System.out.println(list.getIndex() + "번째 데이터를 삭제합니다.");
            for (int i = list.getIndex(); i < list.getCount() - 1; i++) {
                nameList[i] = nameList[i + 1];
                genderList[i] = genderList[i + 1];
                emailList[i] = emailList[i + 1];
                birthYearList[i] = birthYearList[i + 1];
            }
            list.setCount(list.getCount() - 1);
        } else {
            System.out.println("삭제할 데이터가 선택되지 않았습니다.");
        }
    }

    // index 위치의 고객 정보를 수정합니다.
    public static void updateCustomerData(CustomerList list) {
    	System.out.println("데이터를 수정합니다.");
        if ((list.getIndex() >= 0) && (list.getIndex() < list.getCount())) {
            System.out.println(list.getIndex() + "번째 데이터를 수정합니다.");
            System.out.println("---------UPDATE CUSTOMER INFO----------");
            System.out.print("이름(" + nameList[index] + ") :");
            nameList[index] = scan.next();

            System.out.print("성별(" + genderList[index] + ") :");
            genderList[index] = scan.next().charAt(0);

            System.out.print("이메일(" + emailList[index] + ") :");
            emailList[index] = scan.next();

            System.out.print("출생년도(" + birthYearList[index] + ") :");
            birthYearList[index] = scan.nextInt();
        } else {
            System.out.println("수정할 데이터가 선택되지 않았습니다.");
        }
    }

}// end class
