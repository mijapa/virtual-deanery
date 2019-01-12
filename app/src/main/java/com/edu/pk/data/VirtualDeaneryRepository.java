package com.edu.pk.data;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;


import com.edu.pk.connection.BasicConnection;
import com.edu.pk.connection.FetchFromExDB.FetchBenefitTable;
import com.edu.pk.connection.FetchFromExDB.FetchCourseTable;
import com.edu.pk.connection.FetchFromExDB.FetchLecturerCourseTable;
import com.edu.pk.connection.FetchFromExDB.FetchLecturerTable;
import com.edu.pk.connection.FetchFromExDB.FetchStudentFieldOfStudyTable;
import com.edu.pk.connection.FetchFromExDB.FetchStudentTable;
import com.edu.pk.connection.FetchFromExDB.FetchFieldOfStudyCourseTable;
import com.edu.pk.connection.InsertIntoExDB.InsertUser;
import com.edu.pk.connection.FetchFromExDB.FetchFieldOfStudyTable;
import com.edu.pk.connection.UpdateExDB.UpdatePassword;
import com.edu.pk.connection.FetchFromExDB.FetchSingleUser;
import com.edu.pk.connection.FetchFromExDB.FetchGradeTable;

import com.edu.pk.data.dao.BenefitDao;
import com.edu.pk.data.dao.CourseDao;
import com.edu.pk.data.dao.EmployeeDao;
import com.edu.pk.data.dao.FieldOfStudyCourseDao;
import com.edu.pk.data.dao.FieldOfStudyDao;
import com.edu.pk.data.dao.GradeDao;
import com.edu.pk.data.dao.LecturerCourseDao;
import com.edu.pk.data.dao.LecturerDao;
import com.edu.pk.data.dao.PaymentDao;
import com.edu.pk.data.dao.StudentApplicationDao;
import com.edu.pk.data.dao.StudentDao;
import com.edu.pk.data.dao.StudentDormitoryDao;
import com.edu.pk.data.dao.StudentFieldOfStudyDao;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class VirtualDeaneryRepository {

    private StudentDao mStudentDao;
    private EmployeeDao mEmployeeDao;
    private LecturerDao mLecturerDao;
    private CourseDao mCourseDao;
    private StudentApplicationDao mStudentApplicationDao;
    private StudentDormitoryDao mStudentDormitoryDao;
    private LecturerCourseDao mLecturerCourseDao;
    private FieldOfStudyDao mFieldOfStudyDao;
    private FieldOfStudyCourseDao mFieldOfStudyCourseDao;
    private StudentFieldOfStudyDao mStudentFieldOfStudyDao;
    private PaymentDao mPaymentDao;
    private BenefitDao mBenefitDao;
    private GradeDao mGradeDao;

    private static Integer niu;

    public VirtualDeaneryRepository(Application application) {
        VirtualDeaneryRoomDatabase db = VirtualDeaneryRoomDatabase.getDatabase(application);
        mStudentDao = db.studentDao();
        mEmployeeDao = db.employeeDao();
        mLecturerDao = db.lecturerDao();
        mCourseDao = db.courseDao();
        mStudentApplicationDao = db.studentApplicationDao();
        mStudentDormitoryDao = db.studentDormitoryDao();
        mLecturerCourseDao = db.lecturerCourseDao();
        mFieldOfStudyDao = db.fieldOfStudyDao();
        mFieldOfStudyCourseDao = db.fieldOfStudyCourseDao();
        mStudentFieldOfStudyDao = db.studentFieldOfStudyDao();
        mPaymentDao = db.paymentDao();
        mBenefitDao = db.benefitDao();
        mGradeDao = db.gradeDao();
    }

    public Integer getNiu() {
        return niu;
    }

    public void setNiu(Integer niu) {
        this.niu = niu;
    }

    public void setAlbumNo(Integer niu, Integer albumNo) { mStudentDao.setAlbumNo(niu, albumNo); }

    public void setPesel(Integer niu, String pesel) { mStudentDao.setPesel(niu, pesel); }

    public void setFirstName(Integer niu, String firstName) { mStudentDao.setFirstName(niu, firstName); }

    public void setLastName(Integer niu, String lastName) { mStudentDao.setLastName(niu, lastName); }

    public void setFamilyName(Integer niu, String familyName) { mStudentDao.setFamilyName(niu, familyName); }

    public void setSex(Integer niu, Integer sex) { mStudentDao.setSex(niu, sex); }

    public void setAddress(Integer niu, String address) { mStudentDao.setAddress(niu, address); }

    public void setCityOrVillage(Integer niu, String cityOrVillage) { mStudentDao.setCityOrVillage(niu, cityOrVillage); }

    public void setVoivodeship(Integer niu, String voivodeship) { mStudentDao.setVoivodeship(niu, voivodeship); }

    public void setCountry(Integer niu, String country) { mStudentDao.setCountry(niu, country); }

    public void setDistanceFromTheCheck_InPlace(Integer niu, Integer distanceFromTheCheck_InPlace) { mStudentDao.setDistanceFromTheCheck_InPlace(niu, distanceFromTheCheck_InPlace); }

    public void setDateOfBirth(Integer niu, String dateOfBirth) { mStudentDao.setDateOfBirth(niu, dateOfBirth); }

    public void setPlaceOfBirth(Integer niu, String placeOfBirth) { mStudentDao.setPlaceOfBirth(niu, placeOfBirth); }

    public void setFatherName(Integer niu, String fatherName) { mStudentDao.setFatherName(niu, fatherName); }

    public void setMotherName(Integer niu, String motherName) { mStudentDao.setMotherName(niu, motherName); }

    public void setMotherFamilyName(Integer niu, String motherFamilyName) { mStudentDao.setMotherFamilyName(niu, motherFamilyName); }

    public void setMaritalStatus(Integer niu, Integer maritalStatus) { mStudentDao.setMaritalStatus(niu, maritalStatus); }

    public void setForeigner(Integer niu, Integer foreigner) { mStudentDao.setForeigner(niu, foreigner); }

    public void setPhoneNumber(Integer niu, Integer phoneNumber) { mStudentDao.setPhoneNumber(niu, phoneNumber); }

    public void setOtherNumber(Integer niu, Integer otherNumber) { mStudentDao.setOtherNumber(niu, otherNumber); }

    public void setBankAccount(Integer niu, String bankAccount) { mStudentDao.setBankAccount(niu, bankAccount); }

    public void setEmail(Integer niu, String email) { mStudentDao.setEmail(niu, email); }

    public void setDateOfStudyStart(Integer niu, String dateOfStudyStart) { mStudentDao.setDateOfStudyStart(niu, dateOfStudyStart); }

    public void setTerm(Integer niu, Integer term) { mStudentDao.setTerm(niu, term); }

    public void setAddress(String address) { mStudentDao.setAddress(niu, address); }

    public void setCityOrVillage(String cityOrVillage) { mStudentDao.setCityOrVillage(niu, cityOrVillage); }

    public void setVoivodeship(String voivodeship) { mStudentDao.setVoivodeship(niu, voivodeship); }

    public void setOtherNumber(Integer otherNumber) { mStudentDao.setOtherNumber(niu, otherNumber); }

    public void setEmail(String email) { mStudentDao.setEmail(niu, email); }

    //TODO: this should not be perormed on main thread
    public String getPassword() {
        switch (TypeAcc.getType(niu)){
            case STUDENT: return mStudentDao.getStudentPassword(niu);
            case LECTURER: return mLecturerDao.getLecturerPassword(niu);
            case EMPLOYEE: return mEmployeeDao.getEmployeePassword(niu);
        }
        return null;
    }

    public void updateData() {
        updateAllDataBeingNeededByApp();
    }

    private void updateAllDataBeingNeededByApp() {
        try {
            updateStudentFieldOfStudy();
            updateFieldOfStudyCourse();
            updateFieldOfStudy();
            updateGrade();
            updateLecturerCourse();
            updateLecturer();
            updateCourse();
            updateBenefit();
            updateStudent();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateStudentFieldOfStudy() throws Exception {
        FetchStudentFieldOfStudyTable studentFieldOfStudyTable = new FetchStudentFieldOfStudyTable();
        BasicConnection.updateTable(studentFieldOfStudyTable);
        if(studentFieldOfStudyTable.isSuccess()){
            for (StudentFieldOfStudy studentFieldOfStudy: studentFieldOfStudyTable.getStudentFieldOfStudyList())
                insertStudentFieldOfStudy(studentFieldOfStudy);
        }
    }

    private void updateFieldOfStudyCourse() throws Exception {
        FetchFieldOfStudyCourseTable fieldOfStudyCourseTable = new FetchFieldOfStudyCourseTable();
        BasicConnection.updateTable(fieldOfStudyCourseTable);
        if (fieldOfStudyCourseTable.isSuccess()){
            for (FieldOfStudyCourse fieldOfStudyCourse: fieldOfStudyCourseTable.getFieldOfStudyCourseList())
                insertFieldOfStudyCourse(fieldOfStudyCourse);
        }
    }

    private void updateFieldOfStudy() throws Exception {
        FetchFieldOfStudyTable fieldOfStudyTable = new FetchFieldOfStudyTable();
        BasicConnection.updateTable(fieldOfStudyTable);
        if(fieldOfStudyTable.isSuccess()){
            for (FieldOfStudy fieldOfStudy: fieldOfStudyTable.getFieldOfStudyList())
                insertFieldOfStudy(fieldOfStudy);
        }
    }

    private void updateGrade() throws Exception {
        FetchGradeTable gradeTable = new FetchGradeTable();
        BasicConnection.updateTable(gradeTable);
        if(gradeTable.isSuccess()){
            for (Grade grade: gradeTable.getGradeList())
                inserGrade(grade);
        }
    }

    private void updateLecturerCourse() throws Exception {
        FetchLecturerCourseTable lecturerCourseTable = new FetchLecturerCourseTable();
        BasicConnection.updateTable(lecturerCourseTable);
        if(lecturerCourseTable.isSuccess()){
            for (LecturerCourse lecturerCourse: lecturerCourseTable.getLecturerCourseList())
                insertLecturerCourse(lecturerCourse);
        }
    }

    private void updateLecturer() throws Exception {
        FetchLecturerTable lecturerTable = new FetchLecturerTable();
        BasicConnection.updateTable(lecturerTable);
        if(lecturerTable.isSuccess()){
            for (Lecturer lecturer: lecturerTable.getLecturerList())
                insertLecturer(lecturer);
        }
    }

    private void updateCourse() throws Exception {
        FetchCourseTable courseTable = new FetchCourseTable();
        BasicConnection.updateTable(courseTable);
        if(courseTable.isSuccess()){
            for (Course course: courseTable.getCoursesList())
                insertCourse(course);
        }
    }

    private void updateBenefit() throws Exception {
        FetchBenefitTable benefitTable = new FetchBenefitTable();
        BasicConnection.updateTable(benefitTable);
        if (benefitTable.isSuccess()) {
            for (Benefit benefit: benefitTable.getBenefitList())
                insertBenefit(benefit);
        }
    }

    private void updateStudent() throws Exception {
        FetchStudentTable studentTable = new FetchStudentTable();
        BasicConnection.updateTable(studentTable);
        if (studentTable.isSuccess()) {
            for (Student student: studentTable.getStudentList())
                insertStudent(student);
        }
    }


    //TODO insert dla użytkowników jeden w zależności od niu
    public void insertStudent(Student student) {
        try {
            InsertUser insertUser = new InsertUser(student);
            insertUser.execute().get(5000,TimeUnit.MILLISECONDS);
            if (insertUser.isSuccess()) {
                new insertStudentAsyncTask(mStudentDao).execute(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertLecturer(Lecturer lecturer) {
        try {
            InsertUser insertUser = new InsertUser(lecturer);
            insertUser.execute().get(5000,TimeUnit.MILLISECONDS);
            if (insertUser.isSuccess()) {
                new insertLecturerAsyncTask(mLecturerDao).execute(lecturer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertEmployee(Employee employee) { new insertEmployeeAsyncTask(mEmployeeDao).execute(employee); }

    public void insertCourse(Course course) { new insertCourseAsyncTask(mCourseDao).execute(course); }

    public void insertStudentApplication(StudentApplication studentApplication) { new insertStudentApplicationAsyncTask(mStudentApplicationDao).execute(studentApplication); }

    public void insertStudentDormitory(StudentDormitory studentDormitory) { new insertStudentDormitoryAsyncTask(mStudentDormitoryDao).execute(studentDormitory); }

    public void insertLecturerCourse(LecturerCourse lecturerCourse) { new insertLecturerCourseAsyncTask(mLecturerCourseDao).execute(lecturerCourse); }

    public void insertFieldOfStudy(FieldOfStudy fieldOfStudy) {
        new insertFieldOfStudyAsyncTask(mFieldOfStudyDao).execute(fieldOfStudy);
    }

    public void insertFieldOfStudyCourse(FieldOfStudyCourse fieldOfStudyCourse) { new insertFieldOfStudyCourseAsyncTask(mFieldOfStudyCourseDao).execute(fieldOfStudyCourse); }

    public void insertStudentFieldOfStudy(StudentFieldOfStudy studentFieldOfStudy) {
        //--
        new insertStudentFieldOfStudyAsyncTask(mStudentFieldOfStudyDao).execute(studentFieldOfStudy);
    }

    public void insertPayment(Payment payment){ new insertPaymentAsyncTask(mPaymentDao).execute(payment);}

    public void insertBenefit(Benefit benefit) {
        new insertBenefitAsyncTask(mBenefitDao).execute(benefit);
    }

    public void updatePasswordForUser(int niu, String password){
        try {
            UpdatePassword updatePassword = new UpdatePassword(niu, password);
            updatePassword.execute().get(5000,TimeUnit.MILLISECONDS);
            if (updatePassword.isSuccess()) {
                switch (TypeAcc.getType(niu)){
                    case STUDENT: mStudentDao.changePasswordStudent(niu, password); break;
                    case LECTURER: mLecturerDao.changePasswordLecturer(niu, password); break;
                    case EMPLOYEE: mEmployeeDao.changePasswordEmployee(niu, password); break;
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void insertGrade(Grade grade) {
        new insertGradeAsyncTask(mGradeDao).execute(grade);
    }

    public void inserGrade(Grade grade) { new insertGradeAsyncTask(mGradeDao).execute(grade); }

    public void setStatusApplication(int applicationNo, String status) { mStudentApplicationDao.setStatusApplication(applicationNo, status); }

    public String getStatusApplication(Integer albumNo, String description) { return mStudentApplicationDao.getStatusApplication(albumNo, description); }

    public Integer getAlbumNo() {
        return mStudentDao.getAlbumNo(niu);
    }

    public Integer getDistanceFromTheCheck_InPlace() { return mStudentDao.getDistanceFromTheCheck_InPlace(niu); }

    public String getDorm(Integer albumNo) {
        return mStudentDormitoryDao.getDorm(albumNo);
    }

    public String getRoom(Integer albumNo) {
        return mStudentDormitoryDao.getRoom(albumNo);
    }

    public Student getStudent() {
        return mStudentDao.getStudent(niu);
    }

    public LiveData<List<Student>> getStudents() {
        return mStudentDao.getStudents();
    }

    public LiveData<List<StudentApplication>> getStudentApplicationsByStatusWaiting() { return mStudentApplicationDao.getStudentApplicationsByStatusWaiting(); }

    public List<Course> getCourseList() {
        return mCourseDao.getCourseList();
    }

    public List<Course> getCourseListById() { return mCourseDao.getCourseListById(niu); }

    public List<FieldOfStudy> getFieldOfStudyList() {
        return mFieldOfStudyDao.getFieldOfStudyList();
    }

    public List<Student> getStudentByFieldOfStudyList(String fieldOfStudy, String department, Integer term) { return mStudentDao.getStudentByFieldOfStudyList(fieldOfStudy, department, term); }

    public List<Payment> getPayments(){ return mPaymentDao.getPayments(niu); }

    public List<Benefit> getBenefits(){ return mBenefitDao.getBenefits(niu); }

    public LiveData<List<Grade>> getGrades() { return mGradeDao.getGradesListById(niu); }

    public void deleteApplication(Integer albumNo, String description) { mStudentApplicationDao.deleteApplication(albumNo, description); }

    private static class insertStudentAsyncTask extends AsyncTask<Student, Void, Void> {
        private StudentDao mStudentAsyncTaskDao;

        insertStudentAsyncTask(StudentDao dao) {
            mStudentAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Student... params) {
            mStudentAsyncTaskDao.insert(params[0]);
            return null;
        }
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

    private static class insertStudentDormitoryAsyncTask extends AsyncTask<StudentDormitory, Void, Void> {
        private StudentDormitoryDao mStudentDormitoryAsyncTaskDao;

        insertStudentDormitoryAsyncTask(StudentDormitoryDao dao) {
            mStudentDormitoryAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final StudentDormitory... params) {
            mStudentDormitoryAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    private static class insertLecturerCourseAsyncTask extends AsyncTask<LecturerCourse, Void, Void> {
        private LecturerCourseDao mLecturerCourseAsyncTaskDao;

        insertLecturerCourseAsyncTask(LecturerCourseDao dao) {
            mLecturerCourseAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final LecturerCourse... params) {
            mLecturerCourseAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    private static class insertFieldOfStudyAsyncTask extends AsyncTask<FieldOfStudy, Void, Void> {
        private FieldOfStudyDao mFieldOfStudyAsyncTaskDao;

        insertFieldOfStudyAsyncTask(FieldOfStudyDao dao) {
            mFieldOfStudyAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final FieldOfStudy... params) {
            mFieldOfStudyAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    private static class insertFieldOfStudyCourseAsyncTask extends AsyncTask<FieldOfStudyCourse, Void, Void> {
        private FieldOfStudyCourseDao mFieldOfStudyCourseAsyncTaskDao;

        insertFieldOfStudyCourseAsyncTask(FieldOfStudyCourseDao dao) {
            mFieldOfStudyCourseAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final FieldOfStudyCourse... params) {
            mFieldOfStudyCourseAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    private static class insertStudentFieldOfStudyAsyncTask extends AsyncTask<StudentFieldOfStudy, Void, Void> {
        private StudentFieldOfStudyDao mStudentFieldOfStudyAsyncTaskDao;

        insertStudentFieldOfStudyAsyncTask(StudentFieldOfStudyDao dao) {
            mStudentFieldOfStudyAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final StudentFieldOfStudy... params) {
            mStudentFieldOfStudyAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    private static class insertPaymentAsyncTask extends AsyncTask<Payment, Void, Void> {
        private PaymentDao mPaymentAsyncTaskDao;

        insertPaymentAsyncTask(PaymentDao dao) {
            mPaymentAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Payment... params) {
            mPaymentAsyncTaskDao.insert(params[0]);
            return null;
        }
    }


    private static class insertBenefitAsyncTask extends AsyncTask<Benefit, Void, Void> {
        private BenefitDao mBenefitAsyncTaskDao;

        insertBenefitAsyncTask(BenefitDao dao) {
            mBenefitAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Benefit... params) {
            mBenefitAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
    private class insertGradeAsyncTask extends AsyncTask<Grade, Void, Void> {
        private GradeDao mGradeAsyncTaskDao;

        public insertGradeAsyncTask(GradeDao dao) {
            mGradeAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Grade... params) {
            mGradeAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
