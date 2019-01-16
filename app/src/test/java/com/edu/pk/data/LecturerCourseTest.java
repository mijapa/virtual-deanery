package com.edu.pk.data;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LecturerCourseTest {

    LecturerCourse lecturerCourse;

    @Before
    public void setUp() throws Exception {
        lecturerCourse = new LecturerCourse(5, 21);
    }

    @Test
    public void getCourseNo() {
        assertTrue("Zwracanie courseNo jest niepoprawne", lecturerCourse.getCourseNo().equals(5));
    }

    @Test
    public void getNiu() {
        assertTrue("Zwracanie niu jest niepoprawne", lecturerCourse.getNiu().equals(21));
    }
}