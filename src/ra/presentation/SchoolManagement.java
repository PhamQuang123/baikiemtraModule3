package ra.presentation;

import ra.business.design.IOData;
import ra.business.entity.Mark;
import ra.business.entity.Student;
import ra.business.entity.Subject;
import ra.business.implement.MarkImpl;
import ra.business.implement.StudentImpl;
import ra.business.implement.SubjectImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SchoolManagement {

    public static List<Student> listStudents = new ArrayList<>();
    public static List<Subject> listSubject = new ArrayList<>();
    public static List<Mark> listMark = new ArrayList<>();
//    public static Scanner scanner = new Scanner(System.in);
    static StudentImpl objStudentImpl = new StudentImpl();
    static SubjectImpl objSubjectImpl = new SubjectImpl();
    static MarkImpl objMarkImpl = new MarkImpl();

    public static void main(String[] args) {

        do {
            System.out.println("************************SCHOOL-MANAGEMENT*************************");
            System.out.println("1. Quản lý học sinh");
            System.out.println("2. Quản lý môn học");
            System.out.println("3. Quản lí điểm thi");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(IOData.scanner.nextLine());
            switch (choice) {
                case 1:
                    studentManagement();
                    break;
                case 2:
                    subjectManagement();
                    break;
                case 3:
                    markManagemnet();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn từ 1-4");
            }
        } while (true);
    }

    // ********************** START STUDENT-MANAGEMENT************************
    public static void studentManagement() {
        boolean isExit = true;
        do {
            System.out.println("**********************STUDENT-MANAGEMENT************************");
            System.out.println("1.Thêm mới học sinh");
            System.out.println("2.Hiển thị danh sách tất cả học sinh đã lưu trữ");
            System.out.println("3.Thay đổi thông tin học sinh");
            System.out.println("4.Xóa học sinh (kiểm tra xem nếu sinh viên có điểm thi thì không xóa được)");
            System.out.println("5.Thoát");
            System.out.print("Lựa chọn của bạn là: ");
            int choice = Integer.parseInt(IOData.scanner.nextLine());
            switch (choice) {
                case 1:
                    inputListStudents();
                    break;
                case 2:
                    displayListStudent();
                    break;
                case 3:
                    updateListStudents();
                    break;
                case 4:
                    deleteListStudents();
                    break;
                case 5:
                    isExit = false;
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1-5");
            }
        } while (isExit);
    }

    public static void inputListStudents() {
        System.out.println("Nhập số học sinh cần thêm;");
        int n = Integer.parseInt(IOData.scanner.nextLine());
        for (int i = 0; i < n; i++) {
            objStudentImpl.inputData();
        }
    }

    public static void displayListStudent() {
        objStudentImpl.displayData();
    }

    public static void updateListStudents() {
        System.out.println("Nhập mã học sình cần thay đổi:");
        int updateId = Integer.parseInt(IOData.scanner.nextLine());
        int indexUpdate = findIndexUpdateStudentById(updateId);
        if (indexUpdate >= 0) {
            boolean isExit = true;
            do {
                System.out.println("Các thông tin có thể thay đổi là:");
                System.out.println("1. Tên học sinh");
                System.out.println("2. Ngày sinh");
                System.out.println("3. Địa chỉ");
                System.out.println("4. Giới tính");
                System.out.println("5. Số điện thoại");
                System.out.println("6. Thoát");
                System.out.print("Lựa chọn của bạn là: ");
                int choice = Integer.parseInt(IOData.scanner.nextLine());
                switch (choice) {
                    case 1:
                        listStudents.get(indexUpdate).setStudentName(objStudentImpl.inputStudentName());
                        break;
                    case 2:
                        listStudents.get(indexUpdate).setBirthDay(objStudentImpl.inputBirthDay());
                        break;
                    case 3:
                        System.out.println("");
                        listStudents.get(indexUpdate).setAddress(objStudentImpl.inputAddress());
                        break;
                    case 4:
                        listStudents.get(indexUpdate).setGender(objStudentImpl.inputGender());
                        break;
                    case 5:
                        listStudents.get(indexUpdate).setPhone(objStudentImpl.inputPhone());
                        break;
                    case 6:
                        isExit = false;
                        break;
                    default:
                        System.err.println("Vui lòng chọn từ 1-6");
                }
            } while (isExit);
        } else {
            System.err.println("Mã không tồn tại");
        }
    }

    public static int findIndexUpdateStudentById(int id) {
        for (int i = 0; i < listStudents.size(); i++) {
            if (listStudents.get(i).getStudentId() == id) {
                return i;
            }
        }
        return -1;
    }
    public static void deleteListStudents(){
        System.out.println("Nhập mã học sinh muốn xoá:");
        int deleteId = Integer.parseInt(IOData.scanner.nextLine());
        int indexDelete = findIndexUpdateStudentById(deleteId);
        if (indexDelete >= 0) {
            if (listMark.stream().anyMatch(mark -> mark.getStudent().getStudentId() == deleteId)) {

                System.err.println("Không thể xoá học sinh");
            }else {
                listStudents.remove(indexDelete);
            }
        }else {
            System.err.println("\n Học sinh không tồn tại");
        }
    }
// **********************END STUDENT-MANAGEMENT************************

    //**********************START SUBJECT-MANAGEMENT*************************

    public static void subjectManagement() {
        boolean isExit = true;
        do {
            System.out.println("**********************SUBJECT-MANAGEMENT*************************");
            System.out.println("1.Thêm mới môn học");
            System.out.println("2.Hiển thị danh sách tất cả môn học đã lưu trữ");
            System.out.println("3.Thay đổi thông tin học môn học");
            System.out.println("4.Xóa môn học (kiểm tra xem nếu môn học có điểm thi thì không xóa được)");
            System.out.println("5.Thoát");
            System.out.print("Lựa chọn của bạn là: ");
            int choice = Integer.parseInt(IOData.scanner.nextLine());
            switch (choice) {
                case 1:
                    inputListSubjects();
                    break;
                case 2:
                    displayListSubjects();
                    break;
                case 3:
                    updateListSubjects();
                    break;
                case 4:
                    deleteListSubjects();
                    break;
                case 5:
                    isExit = false;
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1-5");
            }
        } while (isExit);
    }

    public static void inputListSubjects() {
        System.out.println("Nhập số môn học cần thêm:");
        int n = Integer.parseInt(IOData.scanner.nextLine());
        for (int i = 0; i < n; i++) {
            objSubjectImpl.inputData();
        }
    }

    public static void displayListSubjects() {
        objSubjectImpl.displayData();
    }
    public static void updateListSubjects(){
        System.out.println("Nhập mã môn học cần cập nhật:");
        String updateId = IOData.scanner.nextLine();
        int indexUpdate = findIndexUpdateSubjectById(updateId);
        if (indexUpdate >=0) {
            System.out.println("Cập nhật tên môn học:");
            listSubject.get(indexUpdate).setSubjectName(objSubjectImpl.inputSubjectName());
        }else {
            System.err.println("\n Môn học không tồn tại");
        }
    }
    public static int findIndexUpdateSubjectById(String id){
        for (int i = 0; i < listSubject.size(); i++) {
            if (listSubject.get(i).getSubjectId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
    public static void  deleteListSubjects(){
        System.out.println("Nhập mã môn học cần xoá:");
        String deleteId = IOData.scanner.nextLine();
        int indexDelete = findIndexUpdateSubjectById(deleteId);
        if (indexDelete >=0) {
            if (listMark.stream().anyMatch(mark -> mark.getSubject().getSubjectId().equals(deleteId))) {
                System.err.println("Không thể xoá môn học");
            }else {
                listSubject.remove(indexDelete);
            }
        }else {
            System.err.println("Môn học không tồn tại");
        }
    }
    //**********************END SUBJECT-MANAGEMENT*************************

    //*********************START MARK-MANAGEMENT************************
    public static void markManagemnet() {
        boolean isExit = true;
        do {
            System.out.println("*********************MARK-MANAGEMENT************************");
            System.out.println("1.Thêm mới điểm thi cho 1 sinh viên");
            System.out.println("2.Hiển thị danh sách tất cả điểm thi theo thứ tự điểm tăng dần");
            System.out.println("3.Thay đổi điểm theo sinh viên");
            System.out.println("4.Xóa điểm thi của sinh viên");
            System.out.println("5.Hiển thị danh sách điểm thi theo mã môn học");
            System.out.println("6.Hiển thị đánh giá học lực của từng học sinh theo mã môn học (giả sử <5 là yếu , <=6.5 là trung\n" +
                    "bình, <= 8 là khá, <= 9 là giỏi, còn lại là xuất sắc).");
            System.out.println("7. Thoát");
            System.out.print("Lựa chọn của bạn là: ");
            int choice = Integer.parseInt(IOData.scanner.nextLine());
            switch (choice) {
                case 1:
                    inputListMarks();
                    break;
                case 2:
                    displayListMarks();
                    break;
                case 3:
                    updateListMarkByStudentId();
                    break;
                case 4:
                    deleteListMarks();
                    break;
                case 5:
                    displayListMarksBySubjectId();
                    break;
                case 6:
                    displayAcademicAssessmentBySubjectId();
                    break;
                case 7:
                    isExit = false;
                    break;
                default:
                    System.err.println("Vui òng chọn từ 1-7");
            }
        } while (isExit);
    }

    public static void inputListMarks() {
        System.out.println("Thêm điểm mới cho học sinh:");
        objMarkImpl.inputData();
    }

    public static void displayListMarks() {
        objMarkImpl.displayData();
    }

    public static void updateListMarkByStudentId(){
        System.out.println("Nhập mã sinh viên cần thay đổi điểm:");
        int inputStudentId = Integer.parseInt(IOData.scanner.nextLine());
        int indexUpdate ;
        if (listMark.stream().anyMatch(mark -> mark.getStudent().getStudentId() == inputStudentId)) {
            int asc = 0;
            List<Integer> listIndex = new ArrayList<>();
            System.out.println("Môn học có thể thay đổi điểm:");
            for (int i = 0; i < listMark.size();i++) {
                if (listMark.get(i).getStudent().getStudentId() == inputStudentId) {
                    asc++;
                    System.out.printf("%d. %s\n",asc, listMark.get(i).getSubject().getSubjectName());
                    listIndex.add(i);
                }
            }
            System.out.print("Lựa chọn môn học: ");
            int choice = Integer.parseInt(IOData.scanner.nextLine());
            indexUpdate = listIndex.get(choice - 1);
            listMark.get(indexUpdate).setPoint(objMarkImpl.inputPoint());
        }else {
            System.err.println("Sinh viên không tồn tại");
        }
    }
    public static void  deleteListMarks(){
        System.out.println("Nhập mã điểm cần xoá:");
        int inputDeleteId = Integer.parseInt(IOData.scanner.nextLine());
        int indexDelete = findIndexByMarkId(inputDeleteId);
        if (indexDelete >=0) {
            listMark.remove(indexDelete);
        }else {
            System.err.println("Điểm thi không tồn tại");
        }
    }
    public static int findIndexByMarkId(int id){
        for (int i = 0; i < listMark.size(); i++) {
            if (listMark.get(i).getMarkId() == id) {
                return i;
            }
        }
        return -1;
    }
    public static void displayListMarksBySubjectId(){
        System.out.println("Nhập mã môn học:");
        String inputSubjectId = IOData.scanner.nextLine();
        listMark.stream().filter(mark -> mark.getSubject().getSubjectId().equals(inputSubjectId)).
                forEach(mark ->
                        System.out.printf("Mã điểm: %d - Tên học sinh: %s - Tên môn học: %s - Điểm số: %.1f\n",
                                mark.getMarkId(), mark.getStudent().getStudentName(), mark.getSubject().getSubjectName(),
                                mark.getPoint()));
    }
    public static void displayAcademicAssessmentBySubjectId(){
        System.out.println("Nhập mã môn học:");
        String inputSubjectId = IOData.scanner.nextLine();
        listMark.stream().filter(mark -> mark.getSubject().getSubjectId().equals(inputSubjectId)).
                forEach(mark ->
                        {
                            if (mark.getPoint() < 5) {
                                System.out.printf("Học sinh: %s - Học lực: Yếu\n",
                                        mark.getStudent().getStudentName());
                            } else if (mark.getPoint() <= 6.5) {
                                System.out.printf("%s - Học lực: Trung Bình\n",
                                        mark.getStudent().getStudentName());
                            } else if (mark.getPoint() <= 8) {
                                System.out.printf("%s - Học lực: Khá\n",
                                        mark.getStudent().getStudentName());
                            } else if (mark.getPoint() <= 9) {
                                System.out.printf("%s - Học lực: Giỏi\n",
                                        mark.getStudent().getStudentName());
                            }else {
                                System.out.printf("%s - Học lực: Xuất sắc\n",
                                        mark.getStudent().getStudentName());
                            }
                        });

    }
    //*********************END MARK-MANAGEMENT************************
}
