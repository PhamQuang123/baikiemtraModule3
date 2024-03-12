package ra.business.implement;

import ra.business.design.IOData;
import ra.business.entity.Subject;
import ra.presentation.SchoolManagement;

import java.util.List;
import java.util.regex.Pattern;

public class SubjectImpl implements IOData<Subject> {
    @Override
    public List<Subject> inputData() {
        Subject subject = new Subject();
        subject.setSubjectId(inputSubjectId());
        subject.setSubjectName(inputSubjectName());
        SchoolManagement.listSubject.add(subject);
        return SchoolManagement.listSubject;
    }

    @Override
    public void displayData() {
        for (int i = 0; i < SchoolManagement.listSubject.size(); i++) {
            System.out.printf("Mã môn học: %s - Tên môn học: %s \n",
                    SchoolManagement.listSubject.get(i).getSubjectId(), SchoolManagement.listSubject.get(i).getSubjectName());
        }
    }

    public static String inputSubjectId() {
        System.out.println("Nhập mã môn học:");
        do {
            String subjectIdInp = scanner.nextLine();
            if (Pattern.matches("MH[0-9]{3}", subjectIdInp)) {
                boolean isExist = false;
                for (int i = 0; i < SchoolManagement.listSubject.size(); i++) {
                    if (SchoolManagement.listSubject.get(i).getSubjectId().equals(subjectIdInp)) {
                        isExist = true;
                    }
                }
                if (isExist) {
                    System.err.println("Mã đã tồn tại");
                } else {
                    return subjectIdInp;
                }
            } else {
                System.err.println("Mã gồm 5 kí tự bắt đầu bằng “MH” và 3 kí tự số bất kì");
            }
        } while (true);
    }

    public static String inputSubjectName() {
        System.out.println("Nhập tên môn học:");
        do {
            String subjectNamedInp = scanner.nextLine();
            if (subjectNamedInp.length() != 0) {
                boolean isExist = false;
                for (int i = 0; i < SchoolManagement.listSubject.size(); i++) {
                    if (SchoolManagement.listSubject.get(i).getSubjectName().equals(subjectNamedInp)) {
                        isExist = true;
                    }
                }
                if (isExist) {
                    System.err.println("Tên đã tồn tại");
                } else {
                    return subjectNamedInp;
                }
            } else {
                System.err.println("Không được để trống");
            }
        } while (true);
    }
}
