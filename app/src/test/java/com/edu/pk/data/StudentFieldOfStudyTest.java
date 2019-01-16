package com.edu.pk.data;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class StudentFieldOfStudyTest {

    StudentFieldOfStudy studentFieldOfStudy;

    @Before
    public void setUp() throws Exception {
        studentFieldOfStudy = new StudentFieldOfStudy(1, 1);
    }

    @Test
    public void getFieldOfStudyNo() {
        assertTrue("Zwracanie fieldOfStudy jest niepoprawne", studentFieldOfStudy.getFieldOfStudyNo().equals(1));
    }

    @Test
    public void getNiu() {
        assertTrue("Zwracanie niu jest niepoprawne", studentFieldOfStudy.getNiu().equals(1));

    }
}