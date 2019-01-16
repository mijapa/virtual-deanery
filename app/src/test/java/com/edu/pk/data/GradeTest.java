package com.edu.pk.data;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GradeTest {

    Grade grade;

    @Before
    public void setUp() throws Exception {

        grade = new Grade(5, 5, 5);
    }


    @Test
    public void getNiu() {
        assertTrue("Zwracanie niu jest niepoprawne", grade.getNiu().equals(5));
    }

    @Test
    public void setNiu() {
        grade.setNiu(6);
        assertTrue("Ustawianie niu jest niepoprawne", grade.getNiu().equals(6));
    }

    @Test
    public void getCourseNo() {
        assertTrue("Zwracanie courseNo jest niepoprawne", grade.getCourseNo().equals(5));
    }

    @Test
    public void setCourseNo() {
        grade.setCourseNo(6);
        assertTrue("Ustawianie courseNo jest niepoprawne", grade.getCourseNo().equals(6));
    }

    @Test
    public void getGrade() {
        assertTrue("Zwracanie oceny jest niepoprawne", grade.getGrade().equals(5));
    }

    @Test
    public void setGrade() {
        grade.setGrade(6);
        assertTrue("Ustawianie oceny jest niepoprawne", grade.getGrade().equals(6));
    }
}