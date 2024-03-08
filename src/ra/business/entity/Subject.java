package ra.business.entity;

import ra.business.implement.StudentImpl;
import ra.presentation.SchoolManagement;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Subject {
    private String subjectId;
    private String subjectName;

    public Subject() {
    }

    public Subject(String subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

}
