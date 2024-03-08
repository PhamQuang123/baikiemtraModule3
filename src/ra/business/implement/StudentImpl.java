package ra.business.implement;

import ra.business.design.IOData;
import ra.business.entity.Student;
import ra.presentation.SchoolManagement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StudentImpl implements IOData<Student> {

   static Scanner scanner =new Scanner(System.in);
    @Override
    public List<Student> inputData() {

        Student student = new Student();
        student.setStudentId(inputStudenId());
        student.setStudentName(inputStudentName());
        student.setAddress(inputAddress());
        student.setBirthDay(inputBirthDay());
        student.setGender(inputGender());
        student.setPhone(inputPhone());
      SchoolManagement.listStudents.add(student);
      return SchoolManagement.listStudents;

    }

    @Override
    public void displayData() {

    }
    public static int inputStudenId() {
        int maxId = 0;
        if (SchoolManagement.listStudents.size() == 0) {
            maxId = 0;
        } else {
            for (int i = 0; i < SchoolManagement.listStudents.size(); i++) {
                if (SchoolManagement.listStudents.get(i).getStudentId() > maxId) {
                    maxId = SchoolManagement.listStudents.get(i).getStudentId();
                }
            }
        }
        return maxId + 1;
    }
    public static String inputStudentName(){
        System.out.println("Nhập tên học sinh:");
        do {
            String studentNameInp = scanner.nextLine();
            if (studentNameInp.length() != 0) {
                return studentNameInp;
            }else {
                System.err.println("Không được để trống, vui lòng nhập lại");
            }
        }while (true);
    }
    public static Date inputBirthDay(){
        System.out.println("Nhập ngày sinh:");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        do {
            String birthDayInp = scanner.nextLine();
            try {
                Date created = sdf.parse(birthDayInp);
                return created;
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }while (true);
    }
    public static String inputAddress(){
        System.out.println("Nhập địa chỉ:");
        do {
            String addressInp = scanner.nextLine();
            if (addressInp.length() != 0) {
                return addressInp;
            }else {
                System.err.println("Không được để trống, vui lòng nhập lại");
            }
        }while (true);
    }
    public static boolean inputGender(){
        System.out.println("Nhập giới tính:");
        do {
            String genderInp = scanner.nextLine();
            if (genderInp == "true" || genderInp == "false") {
                return Boolean.parseBoolean(genderInp);
            }else {
                System.err.println("Chỉ nhận giá trị true/false, vui lòng nhập lại");
            }
        }while (true);
    }
    public static String inputPhone(){
        System.out.println("Nhập số điện thoại:");
        do {
            String phoneInp = scanner.nextLine();
            if (Pattern.matches("0[0-9]{9,10}",phoneInp)) {
                boolean isExist = false;
                for (int i = 0; i < SchoolManagement.listStudents.size(); i++) {
                    if (SchoolManagement.listStudents.get(i).getPhone().equals(phoneInp)) {
                        isExist = true;
                    }
                }
                if (isExist) {
                    System.err.println("Số đã tồn tại, vui lòng nhập lại");
                }else {
                    return phoneInp;
                }
            }else {
                System.err.println("Số điện thoại bắt đầu bằng 0 và gồm 10 hoặc 11 số, vui lòng nhập lại");
            }
        }while (true);
    }
}
