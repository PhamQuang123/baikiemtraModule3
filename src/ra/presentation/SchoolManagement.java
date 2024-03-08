package ra.presentation;

import ra.business.entity.Mark;
import ra.business.entity.Student;
import ra.business.entity.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SchoolManagement {

    public static List<Student> listStudents = new ArrayList<>();
    public static List<Subject> listSubject = new ArrayList<>();
    public static List<Mark> listMark = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("************************SCHOOL-MANAGEMENT*************************");
            System.out.println("1. Quản lý học sinh");
            System.out.println("2. Quản lý môn học");
            System.out.println("3. Quản lí điểm thi");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn của bạn");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                case 4:
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1-4");
            }
        } while (true);
    }

}
