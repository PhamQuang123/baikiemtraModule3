package ra.business.implement;

import ra.business.design.IOData;
import ra.business.entity.Mark;
import ra.business.entity.Student;
import ra.business.entity.Subject;
import ra.presentation.SchoolManagement;

import java.util.Comparator;
import java.util.List;


public class MarkImpl implements IOData<Mark> {
    @Override
    public List<Mark> inputData() {
        boolean isExist = false;
        Mark marks = new Mark();
        if (SchoolManagement.listSubject.size() != 0 && SchoolManagement.listStudents.size() != 0) {
            marks.setMarkId(inputMarkId());
            marks.setStudent(inputStudent());
            marks.setSubject(inputSubject());
            for (int i = 0; i < SchoolManagement.listMark.size(); i++) {
                if (SchoolManagement.listMark.get(i).hashCode() != marks.hashCode() &&
                        SchoolManagement.listMark.get(i).getSubject().getSubjectId().equals(marks.getSubject().getSubjectId()) &&
                SchoolManagement.listMark.get(i).getStudent().getStudentId() == marks.getStudent().getStudentId()) {
                    isExist = true;
                }
            }
            if (isExist) {
                System.err.println("Đã nhập điểm");
            } else {
                marks.setPoint(inputPoint());
                SchoolManagement.listMark.add(marks);
                return SchoolManagement.listMark;
            }
        } else {
            System.err.println("\n Vui lòng nhập thông tin học sinh và môn học");
        }
        return null;
    }

    @Override
    public void displayData() {
        SchoolManagement.listMark.stream().sorted(Comparator.comparing(mark -> mark.getPoint())).forEach(mark ->
                System.out.printf("Mã điểm: %d - Tên học sinh: %s - Tên môn học: %s - Điểm số: %.1f\n",
                        mark.getMarkId(), mark.getStudent().getStudentName(), mark.getSubject().getSubjectName(),
                        mark.getPoint()));
    }

    public static int inputMarkId() {
        int maxId = 0;
        if (SchoolManagement.listMark.size() == 0) {
            maxId = 0;
        } else {
            for (int i = 0; i < SchoolManagement.listMark.size(); i++) {
                if (SchoolManagement.listMark.get(i).getMarkId() > maxId) {
                    maxId = SchoolManagement.listMark.get(i).getMarkId();
                }
            }
        }
        return maxId + 1;
    }

    public float inputPoint() {
        System.out.println("Nhập điểm học sinh:");
        do {
            float pointInp = Float.parseFloat(scanner.nextLine());

            if (pointInp >= 0 && pointInp <= 10) {
                return pointInp;
            } else {
                System.err.println("Điểm nhận giá trị từ 0-10");
            }
        } while (true);
    }

    public Student inputStudent() {
        if (SchoolManagement.listStudents.size() > 0) {
            System.out.println("Danh sách học sinh:");
            for (int i = 0; i < SchoolManagement.listStudents.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, SchoolManagement.listStudents.get(i).getStudentName());
            }
            System.out.println("Lựa chọn học sinh:");
            int choice = Integer.parseInt(scanner.nextLine());
            return SchoolManagement.listStudents.get(choice - 1);
        } else {
            System.err.println("Chưa nhập thông tin học sinh");
        }
        return null;
    }
    public Subject inputSubject() {
        if (SchoolManagement.listSubject.size() > 0) {
            System.out.println("Danh sách môn học:");
            for (int i = 0; i < SchoolManagement.listSubject.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, SchoolManagement.listSubject.get(i).getSubjectName());
            }
            System.out.println("Lựa chọn môn học:");
            int choice = Integer.parseInt(scanner.nextLine());
            return SchoolManagement.listSubject.get(choice - 1);
        } else {
            System.err.println("Chưa nhập thông tin môn học");
        }
        return null;
    }
}
