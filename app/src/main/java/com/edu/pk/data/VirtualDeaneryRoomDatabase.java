package com.edu.pk.data;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {Student.class, Employee.class}, version = 2, exportSchema = false)
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

    /**
     * Populate the database in the background.
     */
    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final StudentDao sDao;
        private final EmployeeDao eDao;

        PopulateDbAsync(VirtualDeaneryRoomDatabase db) {
            sDao = db.studentDao();
            eDao = db.employeeDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            // Start the app with a clean database every time.
            // Not needed if you only populate the database
            // when it is first created

            Student student;
            student = new Student(
                    3,
                    101010,
                    "3",
                    0,
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
                    "20160904"
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
            return null;
        }
    }
}