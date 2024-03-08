package ra.business.implement;

import ra.business.design.IOData;
import ra.business.entity.Mark;
import ra.business.entity.Student;
import ra.business.entity.Subject;
import ra.presentation.SchoolManagement;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MarkImpl implements IOData<Mark> {
Scanner scanner = new Scanner(System.in);

    @Override
    public List<Mark> inputData() {
       Mark mark = new Mark();
       mark.setMarkId(inputMarkId());

    }

    @Override
    public void displayData() {

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
    public float inputPoint(){
        System.out.println("Nhập điểm học sinh:");
        do {
            float pointInp = Float.parseFloat(scanner.nextLine());
            if (pointInp >= 0 && pointInp <= 10) {
                return pointInp;
            }else {
                System.err.println("Điểm nhận giá trị từ 0-10");
            }
        }while (true);
    }
    public void inputStudent(Mark mark){

        ;
    }
}
