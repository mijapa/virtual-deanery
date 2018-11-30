package com.edu.pk;

import java.util.ArrayList;
import java.util.List;

public class DataList {

    private List<Data> mDataList = new ArrayList<Data>() {
        {
            add(new Data("Dane podstawowe", "Nazwisko, Imię", "Kowalski, Jan"));
            add(new Data("Dane podstawowe", "Nazwisko rodowe", ""));
            add(new Data("Dane podstawowe", "płeć", "Mężczyzna"));

            add(new Data("Dane dodatkowe", "Data rozpoczęcia studiów", "04-08-2018"));
            add(new Data("Dane dodatkowe", "Kraj pochodzenia", "Polska"));
            add(new Data("Dane dodatkowe", "Obcokrajowiec", "nie"));

            add(new Data("Dane teleadresowe", "Telefon", "+48500500500"));
            add(new Data("Dane teleadresowe", "e-mail", "jak@kowalski.pl"));

            add(new Data("Informacje o toku studiów", "Zgoda na elektroniczne udostępnianie dokumentów", " Wyrażono zgodę na udostępnianie dokumentów drogą elektroniczn"));
            add(new Data("Informacje o toku studiów", "Rok/semestr (w roku akad.)", "1 / 2 (2018/2019)"));
            add(new Data("Informacje o toku studiów", "Semestr", "Zimowy"));
            add(new Data("Informacje o toku studiów", "Forma studiów", "Stacjonarne"));

            add(new Data("Ukończona szkoła średnia", "Rodzaj matury", "(nowa matura poziom r)"));
            add(new Data("Ukończona szkoła średnia", "Wystawiający", "Okręgowa Komisja Egzaminacyjna w Krakowie"));

            add(new Data("Ukończona szkoła wyższa", "Nazwa uczelni", ""));

            add(new Data("Dane wojskowe", "Kategoria", ""));

            add(new Data("Badania lekarskie", "Badania lekarskie", "nie"));
            add(new Data("Badania lekarskie", "Ważne do", ""));

        }
    };

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

