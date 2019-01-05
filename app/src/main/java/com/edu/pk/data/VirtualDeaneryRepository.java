package com.edu.pk.data;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.content.Intent;
import android.os.AsyncTask;

import com.edu.pk.LoginActivity;
import com.edu.pk.connection.FetchUserDataFromDatabase;
import com.edu.pk.employee.EmployeeMenuActivity;
import com.edu.pk.lecturer.LecturerMenuActivity;
import com.edu.pk.student.MenuActivity;

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

    //TODO: this should not be perormed on main thread
    public String getPassword() {
        switch (TypeAcc.getType(niu)){
            case STUDENT: return mStudentDao.getStudentPassword(niu);
            case LECTURER: return mLecturerDao.getLecturerPassword(niu);
            case EMPLOYEE: return mEmployeeDao.getEmployeePassword(niu);
        }
        return null;
    }

    public void updateData(int niu) {
        try {
            FetchUserDataFromDatabase fetchSingleAccount = new FetchUserDataFromDatabase(niu);
            fetchSingleAccount.execute().get(5000, TimeUnit.MILLISECONDS);
            if (fetchSingleAccount.isSuccess()) {
                switch (TypeAcc.getType(niu)){
                    case STUDENT: mStudentDao.insert(fetchSingleAccount.getStudent()); break;
                    case LECTURER: mLecturerDao.insert(fetchSingleAccount.getLecturer()); break;
                    case EMPLOYEE: mEmployeeDao.insert(fetchSingleAccount.getEmployee()); break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //TODO insert dla użytkowników jeden w zależności od niu
    public void insert(Student student) {
        new insertStudentAsyncTask(mStudentDao).execute(student);
    }

    public void insertEmployee(Employee employee) { new insertEmployeeAsyncTask(mEmployeeDao).execute(employee); }

    public void insertLecturer(Lecturer lecturer) { new insertLecturerAsyncTask(mLecturerDao).execute(lecturer); }

    public void insertCourse(Course course) { new insertCourseAsyncTask(mCourseDao).execute(course); }

    public void insertStudentApplication(StudentApplication studentApplication) { new insertStudentApplicationAsyncTask(mStudentApplicationDao).execute(studentApplication); }

    public void insertStudentDormitory(StudentDormitory studentDormitory) { new insertStudentDormitoryAsyncTask(mStudentDormitoryDao).execute(studentDormitory); }

    public void insertLecturerCourse(LecturerCourse lecturerCourse) { new insertLecturerCourseAsyncTask(mLecturerCourseDao).execute(lecturerCourse); }

    public void insertFieldOfStudy(FieldOfStudy fieldOfStudy) { new insertFieldOfStudyAsyncTask(mFieldOfStudyDao).execute(fieldOfStudy); }

    public void insertFieldOfStudyCourse(FieldOfStudyCourse fieldOfStudyCourse) { new insertFieldOfStudyCourseAsyncTask(mFieldOfStudyCourseDao).execute(fieldOfStudyCourse); }

    public void insertStudentFieldOfStudy(StudentFieldOfStudy studentFieldOfStudy) { new insertStudentFieldOfStudyAsyncTask(mStudentFieldOfStudyDao).execute(studentFieldOfStudy); }

    public void insertPayment(Payment payment){ new insertPaymentAsyncTask(mPaymentDao).execute(payment);}

    public void inserBenefit(Benefit benefit){ new insertBenefitAsyncTask(mBenefitDao).execute(benefit);}


    public void changePasswordStudent(int niu, String password) { mStudentDao.changePasswordStudent(niu, password); }

    public void changePasswordEmployee(int niu, String password) { mEmployeeDao.changePasswordEmployee(niu, password); }

    public void changePasswordLecturer(int niu, String password) { mLecturerDao.changePasswordLecturer(niu, password); }


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

    public List<FieldOfStudy> getFieldOfStudyList() { return mFieldOfStudyDao.getFieldOfStudyList(); }

    public List<Student> getStudentByFieldOfStudyList(String fieldOfStudy, String department, Integer term) { return mStudentDao.getStudentByFieldOfStudyList(fieldOfStudy, department, term); }


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
}
