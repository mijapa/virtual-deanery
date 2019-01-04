package com.edu.pk.student.mydata;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import com.edu.pk.data.Student;
import com.edu.pk.data.VirtualDeaneryRepository;

import java.util.ArrayList;
import java.util.List;

public class MyDataViewModel extends AndroidViewModel {

    private VirtualDeaneryRepository mRepository;

    public MyDataViewModel(Application application) {
        super(application);
        mRepository = new VirtualDeaneryRepository(application);
    }

    public DataList getDataList() {
        DataList mDataList = new DataList();
        return mDataList;
    }

    class DataList {

        private Student mStudent = mRepository.getStudent();

        private List<Data> mDataList = new ArrayList<Data>() {
            {
                add(new Data("Dane podstawowe", "Nazwisko, Imię", mStudent.getLastName() + " " + mStudent.getFirstName()));
                add(new Data("Dane podstawowe", "Nazwisko rodowe", mStudent.getFamilyName()));
                add(new Data("Dane podstawowe", "płeć", sextoString(mStudent.getSex())));

                add(new Data("Dane dodatkowe", "Data rozpoczęcia studiów", mStudent.getDateOfStudyStart()));
                add(new Data("Dane dodatkowe", "Kraj pochodzenia", mStudent.getCountry()));
                add(new Data("Dane dodatkowe", "Obcokrajowiec", isForeginer(mStudent.getCountry())));

                add(new Data("Dane teleadresowe", "Telefon", mStudent.getPhoneNumber().toString()));
                add(new Data("Dane teleadresowe", "e-mail", mStudent.getEmail()));

//                add(new Data("Informacje o toku studiów", "Zgoda na elektroniczne udostępnianie dokumentów", " Wyrażono zgodę na udostępnianie dokumentów drogą elektroniczn"));
                add(new Data("Informacje o toku studiów", "Semestr", mStudent.getTerm().toString()));
                add(new Data("Informacje o toku studiów", "Semestr", semestrToSemestr(mStudent.getTerm())));
                add(new Data("Informacje o toku studiów", "Forma studiów", "Stacjonarne"));

                add(new Data("Ukończona szkoła średnia", "Rodzaj matury", "(nowa matura poziom r)"));
//                add(new Data("Ukończona szkoła średnia", "Wystawiający", "Okręgowa Komisja Egzaminacyjna w Krakowie"));

                add(new Data("Ukończona szkoła wyższa", "Nazwa uczelni", ""));

                add(new Data("Dane wojskowe", "Kategoria", ""));

                add(new Data("Badania lekarskie", "Badania lekarskie", "nie"));
                add(new Data("Badania lekarskie", "Ważne do", ""));

            }
        };

        private String sextoString(int sex) {
            if (sex == 0) return "Mężczycna";
            else return "Kobieta";
        }

        private String isForeginer(String krajPochodzenia) {
            if (krajPochodzenia.equals("Polska")) return "nie";
            else return "tak";
        }

        private String semestrToSemestr(int semestr) {
            if (semestr % 2 == 1) return "Zimowy";
            else return "Letni";
        }
        private List<String> mCategoryList = new ArrayList<String>() {
            {
                add("Dane podstawowe");
                add("Dane dodatkowe");
                add("Dane teleadresowe");
                add("Informacje o toku studiów");
                add("Ukończona szkoła średnia");
                add("Ukończona szkoła wyższa");
                add("Dane wojskowe");
                add("Badania lekarskie");
            }
        };

        public List<Data> getDataList() {
            return mDataList;
        }

        public List<String> getCategoryList() {
            return mCategoryList;
        }

    }

    class Data {

        private String mCategory;
        private String mName;
        private String mValue;

        public Data(String category, String name, String value) {
            mCategory = category;
            mName = name;
            mValue = value;
        }

        public String getCategory() {
            return mCategory;
        }

        public String getName() {
            return mName;
        }

        public String getValue() {
            return mValue;
        }
    }

}
