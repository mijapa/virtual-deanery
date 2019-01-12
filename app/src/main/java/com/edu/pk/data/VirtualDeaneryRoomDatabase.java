package com.edu.pk.data;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

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

@Database(entities = {Student.class, Employee.class, Lecturer.class, Course.class, StudentApplication.class, StudentDormitory.class, LecturerCourse.class, FieldOfStudy.class, FieldOfStudyCourse.class, StudentFieldOfStudy.class, Payment.class, Benefit.class, Grade.class}, version = 27, exportSchema = false)
public abstract class VirtualDeaneryRoomDatabase extends RoomDatabase {

    private static VirtualDeaneryRoomDatabase INSTANCE;
    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback() {

                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    static VirtualDeaneryRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (VirtualDeaneryRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            VirtualDeaneryRoomDatabase.class, "word_database")
                            // Wipes and rebuilds instead of migrating
                            // if no Migration object.
                            // Migration is not part of this practical.
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .allowMainThreadQueries()//TODO: should be avoided (removed)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract StudentDao studentDao();

    public abstract EmployeeDao employeeDao();

    public abstract LecturerDao lecturerDao();

    public abstract CourseDao courseDao();

    public abstract StudentApplicationDao studentApplicationDao();

    public abstract StudentDormitoryDao studentDormitoryDao();

    public abstract LecturerCourseDao lecturerCourseDao();

    public abstract FieldOfStudyDao fieldOfStudyDao();

    public abstract FieldOfStudyCourseDao fieldOfStudyCourseDao();

    public abstract StudentFieldOfStudyDao studentFieldOfStudyDao();

    public abstract PaymentDao paymentDao();

    public abstract BenefitDao benefitDao();

    public abstract GradeDao gradeDao();

    /**
     * Populate the database in the background.
     */
    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final StudentDao sDao;
        private final EmployeeDao eDao;
        private final LecturerDao lDao;
        private final CourseDao cDao;
        private final StudentApplicationDao saDao;
        private final StudentDormitoryDao sdDao;
        private final LecturerCourseDao lcDao;
        private final FieldOfStudyDao fosDao;
        private final FieldOfStudyCourseDao foscDao;
        private final StudentFieldOfStudyDao sfosDao;
        private final PaymentDao pDao;
        private final BenefitDao bDao;
        private final GradeDao gDao;

        PopulateDbAsync(VirtualDeaneryRoomDatabase db) {
            sDao = db.studentDao();
            eDao = db.employeeDao();
            lDao = db.lecturerDao();
            cDao = db.courseDao();
            saDao = db.studentApplicationDao();
            sdDao = db.studentDormitoryDao();
            lcDao = db.lecturerCourseDao();
            fosDao = db.fieldOfStudyDao();
            foscDao = db.fieldOfStudyCourseDao();
            sfosDao = db.studentFieldOfStudyDao();
            pDao = db.paymentDao();
            bDao = db.benefitDao();
            gDao = db.gradeDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            // Start the app with a clean database every time.
            // Not needed if you only populate the database
            // when it is first created


            Payment payment;
            payment = new Payment(
                3,
                    "opłata rekrutacyjna",
                    "2016/17",
                    "1",
                    "Zima",
                    "85,00",
                    "0,00",
                    "0,00",
                    "2016-07-11",
                    "85,00",
                    "0,00",
                    "0,00",
                    ""
            );
            pDao.insert(payment);
            payment = new Payment(
                    3,
                    "legitymacja",
                    "2016/17",
                    "1",
                    "Zima",
                    "17,00",
                    "0,00",
                    "0,00",
                    "2016-07-11",
                    "17,00",
                    "0,00",
                    "0,00",
                    ""
            );
            pDao.insert(payment);

            Benefit benefit;
            benefit = new Benefit(
                    3,
                    "stypendium rektora dla najlepszych studentów",
                    "700,00 PLN",
                    "aktywne",
                    "01-10-2018",
                    "30-06-2019"
            );
            bDao.insert(benefit);

            benefit = new Benefit(
                    3,
                    "stypendium socjalne w zwiększonej wysokości",
                    "350,00 PLN ",
                    "archiwum",
                    "01-10-2017",
                    "30-06-2018"
            );
            bDao.insert(benefit);

            Student student;
            student = new Student(
                    3,
                    101010,
                    "3",
                    "97020110200",
                    "Jan",
                    "Kowalski",
                    "",
                    0,
                    "ul. Warszawska 2, 10-101 Krakówek",
                    "Krakówek",
                    "Małopolska",
                    "Polska",
                    300,
                    "970201",
                    "Krakówek",
                    "Józef",
                    "Halina",
                    "Nowak",
                    0,
                    0,
                    500500500,
                    501501501,
                    "101232135649821689798465",
                    "kowalski@kowalski.pl",
                    "20160904",
                    3
            );

            sDao.insert(student);


            Employee employee;
            employee = new Employee(
                    10,
                    "10",
                    "Grażyna",
                    "Złońska",
                    "ul. Warszawska 2, 10-101 Krakówek",
                    "Krakówek",
                    "97020110200",
                    "graża@pk.pl"
            );

            eDao.insert(employee);

            Lecturer lecturer;
            lecturer = new Lecturer(
                    20,
                    "20",
                    "Michael",
                    "Jackson",
                    "Indiana Gary",
                    608987889
            );

            lDao.insert(lecturer);

            LecturerCourse lecturerCourse;
            lecturerCourse = new LecturerCourse(
                    2, 20
            );
            lcDao.insert(lecturerCourse);

            Course course;
            course = new Course(
                    1,
                    "-",
                    "-",
                    0,
                    "-",
                    "-",
                    "-"
            );
            cDao.insert(course);

            course = new Course(
                2,
                "Angielski",
                "2",
                1,
                "WIEiK",
                "Informatyka",
                "30"
            );
            cDao.insert(course);

            course = new Course(
                    3,
                    "Angielski",
                    "2",
                    2,
                    "WIEiK",
                    "Informatyka",
                    "30"
            );
            cDao.insert(course);

            course = new Course(
                    4,
                    "Angielski",
                    "2",
                    3,
                    "WIEiK",
                    "Informatyka",
                    "30"
            );
            cDao.insert(course);

            course = new Course(
                    5,
                    "Angielski",
                    "2",
                    4,
                    "WIEiK",
                    "Informatyka",
                    "30"
            );
            cDao.insert(course);

            course = new Course(
                    6,
                    "SBD",
                    "6",
                    4,
                    "WIEiK",
                    "Informatyka",
                    "30"
            );
            cDao.insert(course);

            course = new Course(
                    7,
                    "PWJJ",
                    "5",
                    5,
                    "WIEiK",
                    "Informatyka",
                    "30"
            );
            cDao.insert(course);

            course = new Course(
                    8,
                    "Strasznie długa nazwa Strasznie długa nazwa Strasznie długa nazwa",
                    "2",
                    4,
                    "WIEiK",
                    "Informatyka",
                    "30"
            );
            cDao.insert(course);

            course = new Course(
                    9,
                    "KWD",
                    "6",
                    5,
                    "WIEiK",
                    "Informatyka",
                    "30"
            );
            cDao.insert(course);

//            StudentApplication studentApplication;
//            studentApplication = new StudentApplication(
//                    "Wniosek o akademik",
//                    1,
//                    330,
//                    "oczekujący"
//            );
//            saDao.insert(studentApplication);
//            studentApplication = new StudentApplication(
//                    "Wniosek o akademik",
//                    2,
//                    330,
//                    "oczekujący"
//            );
//            saDao.insert(studentApplication);
//            studentApplication = new StudentApplication(
//                    "Wniosek o akademik",
//                    4,
//                    330,
//                    "oczekujący"
//            );
//            saDao.insert(studentApplication);
//            studentApplication = new StudentApplication(
//                    "Wniosek o akademik",
//                    5,
//                    3,
//                    "oczekujący"
//            );
//            saDao.insert(studentApplication);

            Grade grade = new Grade(3, 2, 5);
            gDao.insert(grade);

            return null;
        }
    }
}