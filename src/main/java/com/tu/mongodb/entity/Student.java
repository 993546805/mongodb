package com.tu.mongodb.entity;

/**
 * @author tu
 * @date 2022-11-11 16:01
 */
public class Student extends Person{

    private String studentNo;

    public Student(String name, Integer age, String idNumber, String studentNo) {
        super(name, age, idNumber);
        this.studentNo = studentNo;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }


}
