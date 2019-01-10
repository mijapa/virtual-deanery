package com.edu.pk.data;

public enum TypeAcc {
    STUDENT(10), EMPLOYEE(20), LECTURER(31);
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
        } else if (niu >= TypeAcc.STUDENT.getValue() && niu < TypeAcc.EMPLOYEE.getValue()) {
            return EMPLOYEE;
        } else if (niu >= TypeAcc.EMPLOYEE.getValue() && niu < TypeAcc.LECTURER.getValue()){
            return LECTURER;
        }
        return null;
    }
}
