package com.edu.pk.data;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class VirtualDeaneryRepository {
    private StudentDao mStudentDao;
    private EmployeeDao mEmployeeDao;
    private String DEBUG_TAG = "DEBUG_TAG";

    private Integer NIU;

    public VirtualDeaneryRepository(Application application) {
        VirtualDeaneryRoomDatabase db = VirtualDeaneryRoomDatabase.getDatabase(application);
        mStudentDao = db.studentDao();
        mEmployeeDao = db.employeeDao();
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



    public void insert(Student student) {
        new insertAsyncTask(mStudentDao).execute(student);

    }

    public LiveData<Student> getStudent() {
        return mStudentDao.getStudent(NIU);
    }

    public LiveData<List<Student>> getStudents() {
        return mStudentDao.getStudents();
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
