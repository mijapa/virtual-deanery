package com.edu.pk.data;

public enum TypeAcc {
    STUDENT(10), LECTURER(20), EMPLOYEE(31);
    private int value;

    private int getValue() {
        return value;
    }

    TypeAcc(int value) {
        this.value = value;
    }

    public static TypeAcc getType(int niu){
        if (niu < TypeAcc.STUDENT.getValue()) {
            return STUDENT;
        } else if (niu >= TypeAcc.STUDENT.getValue() && niu < TypeAcc.LECTURER.getValue()) {
            return LECTURER;
        } else if (niu >= TypeAcc.LECTURER.getValue() && niu < TypeAcc.EMPLOYEE.getValue()){
            return EMPLOYEE;
        }
        return null;
    }
}
