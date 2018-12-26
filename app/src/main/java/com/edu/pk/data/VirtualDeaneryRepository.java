package com.edu.pk.data;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class VirtualDeaneryRepository {
    private StudentDao mStudentDao;
    private EmployeeDao mEmployeeDao;
    private LecturerDao mLecturerDao;
    private CourseDao mCourseDao;
    private StudentApplicationDao mStudentApplicationDao;
    private DecisionDao mDecisionDao;
    private String DEBUG_TAG = "DEBUG_TAG";

    private Integer NIU;

    public VirtualDeaneryRepository(Application application) {
        VirtualDeaneryRoomDatabase db = VirtualDeaneryRoomDatabase.getDatabase(application);
        mStudentDao = db.studentDao();
        mEmployeeDao = db.employeeDao();
        mLecturerDao = db.lecturerDao();
        mCourseDao = db.courseDao();
        mDecisionDao = db.decisionDao();
        mStudentApplicationDao = db.studentApplicationDao();
    }

    public Integer getNIU() {
        return NIU;
    }

    public void setNIU(Integer NIU) {
        this.NIU = NIU;
    }

    //TODO: this should not be perormed on main thread
    public String getStudentPassword(Integer NIU) {
        return mStudentDao.getStudentPassword(NIU);
    }

    public String getEmployeePassword(Integer NIU) {
        return mEmployeeDao.getEmployeePassword(NIU);
    }

    public String getLecturerPassword(Integer NIU) {
        return mLecturerDao.getLecturerPassword(NIU);
    }

    public Integer getAlbumNo(Integer niu){
        return mStudentDao.getAlbumNo(niu);
    }
    public Integer getDistanceFromTheCheck_InPlace(Integer niu){
        return mStudentDao.getDistanceFromTheCheck_InPlace(niu);
    }
    public Integer searchIdApplication(Integer albumNo){
        return mStudentApplicationDao.searchIdApplication(albumNo);
    }
    public void insert(Student student) {
        new insertAsyncTask(mStudentDao).execute(student);
    }
    public void insertEmployee(Employee employee){
        new insertEmployeeAsyncTask(mEmployeeDao).execute(employee);
    }
    public void insertLecturer(Lecturer lecturer){
        new insertLecturerAsyncTask(mLecturerDao).execute(lecturer);
    }
    public void insertCourse(Course course){
        new insertCourseAsyncTask(mCourseDao).execute(course);
    }

    public void insertStudentApplication(StudentApplication studentApplication){
        new insertStudentApplicationAsyncTask(mStudentApplicationDao).execute(studentApplication);
    }

    public void insertDecision(Decision decision){
        new insertDecisionAsyncTask(mDecisionDao).execute(decision);
    }

    public void changePasswordStudent(int niu, String password){
        mStudentDao.changePasswordStudent(niu, password);
    }
    public void changePasswordEmployee(int niu, String password){
        mEmployeeDao.changePasswordEmployee(niu, password);
    }
    public void changePasswordLecturer(int niu, String password){
        mLecturerDao.changePasswordLecturer(niu, password);
    }
    public void deleteRowStudentApplication(int applicationNo){
        mStudentApplicationDao.deleteRow(applicationNo);
    }
    public void setStatusDecision(int applicationNo, String status){
        mDecisionDao.setStatusDecision(applicationNo, status);
    }
    public String getStatusDecision(Integer albumNo){
        return mDecisionDao.getStatusDecision(albumNo);
    }

    public LiveData<Student> getStudent() {
        return mStudentDao.getStudent(NIU);
    }

    public LiveData<List<Student>> getStudents() {
        return mStudentDao.getStudents();
    }

    public LiveData<List<StudentApplication>> getStudentApplications() {
        return mStudentApplicationDao.getStudentApplications();
    }



    private static class insertLecturerAsyncTask extends AsyncTask<Lecturer, Void, Void> {
        private LecturerDao mLecturerAsyncTaskDao;

        insertLecturerAsyncTask(LecturerDao dao) {
            mLecturerAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Lecturer... params) {
            mLecturerAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    private static class insertEmployeeAsyncTask extends AsyncTask<Employee, Void, Void> {
        private EmployeeDao mEmployeeAsyncTaskDao;

        insertEmployeeAsyncTask(EmployeeDao dao) {
            mEmployeeAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Employee... params) {
            mEmployeeAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    private static class insertCourseAsyncTask extends AsyncTask<Course, Void, Void> {
        private CourseDao mCourseAsyncTaskDao;

        insertCourseAsyncTask(CourseDao dao) {
            mCourseAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Course... params) {
            mCourseAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    private static class insertStudentApplicationAsyncTask extends AsyncTask<StudentApplication, Void, Void> {
        private StudentApplicationDao mStudentApplicationAsyncTaskDao;

        insertStudentApplicationAsyncTask(StudentApplicationDao dao) {
            mStudentApplicationAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final StudentApplication... params) {
            mStudentApplicationAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    private static class insertDecisionAsyncTask extends AsyncTask<Decision, Void, Void> {
        private DecisionDao mDecisionAsyncTaskDao;

        insertDecisionAsyncTask(DecisionDao dao) {
            mDecisionAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Decision... params) {
            mDecisionAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    private static class insertAsyncTask extends AsyncTask<Student, Void, Void> {
        private StudentDao mAsyncTaskDao;

        insertAsyncTask(StudentDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Student... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
