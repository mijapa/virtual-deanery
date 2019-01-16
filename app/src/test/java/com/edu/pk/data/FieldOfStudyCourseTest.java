package com.edu.pk.data;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FieldOfStudyCourseTest {

    FieldOfStudyCourse fieldOfStudyCourse;

    @Before
    public void setUp() throws Exception {
        fieldOfStudyCourse = new FieldOfStudyCourse(2, 1);
    }

    @Test
    public void getFieldOfStudyNo() {
        assertTrue("Zwracanie FieldOfStudy jest niepoprawne", fieldOfStudyCourse.getFieldOfStudyNo().equals(2));
    }

    @Test
    public void getCourseNo() {
        assertTrue("Zwracanie courseNO jest niepoprawne", fieldOfStudyCourse.getCourseNo().equals(1));

    }
}