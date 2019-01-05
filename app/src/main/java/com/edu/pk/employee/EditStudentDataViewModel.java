package com.edu.pk.employee;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.edu.pk.data.VirtualDeaneryRepository;

public class EditStudentDataViewModel extends AndroidViewModel {

    private VirtualDeaneryRepository mRepository;

    public EditStudentDataViewModel(@NonNull Application application) {
        super(application);
        mRepository = new VirtualDeaneryRepository(application);
    }

    public void setAlbumNo(Integer niu, Integer albumNo){ mRepository.setAlbumNo(niu, albumNo); }

    public void setPesel(Integer niu, String pesel){ mRepository.setPesel(niu, pesel); }

    public void setFirstName(Integer niu, String firstName){ mRepository.setFirstName(niu, firstName); }

    public void setLastName(Integer niu, String lastName){ mRepository.setLastName(niu, lastName); }

    public void setFamilyName(Integer niu, String familyName){ mRepository.setFamilyName(niu, familyName); }

    public void setSex(Integer niu, Integer sex){ mRepository.setSex(niu, sex); }

    public void setAddress(Integer niu, String address){ mRepository.setAddress(niu, address); }

    public void setCityOrVillage(Integer niu, String cityOrVillage){ mRepository.setCityOrVillage(niu, cityOrVillage); }

    public void setVoivodeship(Integer niu, String voivodeship){ mRepository.setVoivodeship(niu, voivodeship); }

    public void setCountry(Integer niu, String country){ mRepository.setCountry(niu, country); }

    public void setDistanceFromTheCheck_InPlace(Integer niu, Integer distanceFromTheCheck_InPlace){ mRepository.setDistanceFromTheCheck_InPlace(niu, distanceFromTheCheck_InPlace); }

    public void setDateOfBirth(Integer niu, String dateOfBirth){ mRepository.setDateOfBirth(niu, dateOfBirth); }

    public void setPlaceOfBirth(Integer niu, String placeOfBirth){ mRepository.setPlaceOfBirth(niu, placeOfBirth); }

    public void setFatherName(Integer niu, String fatherName){ mRepository.setFatherName(niu, fatherName); }

    public void setMotherName(Integer niu, String motherName){ mRepository.setMotherName(niu, motherName); }

    public void setMotherFamilyName(Integer niu, String motherNameFamily){ mRepository.setMotherFamilyName(niu, motherNameFamily); }

    public void setMaritalStatus(Integer niu, Integer maritalStatus){ mRepository.setMaritalStatus(niu, maritalStatus); }

    public void setForeigner(Integer niu, Integer foreigner){ mRepository.setForeigner(niu, foreigner); }

    public void setPhoneNumber(Integer niu, Integer phoneNumber){ mRepository.setPhoneNumber(niu, phoneNumber); }

    public void setOtherNumber(Integer niu, Integer otherNumber){ mRepository.setOtherNumber(niu, otherNumber); }

    public void setBankAccount(Integer niu, String bankAccount){ mRepository.setBankAccount(niu, bankAccount); }

    public void setEmail(Integer niu, String email){ mRepository.setEmail(niu, email); }

    public void setDateOfStudyStart(Integer niu, String dateOfStudyStart){ mRepository.setDateOfStudyStart(niu, dateOfStudyStart); }

    public void setTerm(Integer niu, Integer term){ mRepository.setTerm(niu, term); }

}

