package com.relationship.demo.Services;

import com.relationship.demo.Reopsitories.LicenseRepository;
import com.relationship.demo.models.License;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LicenseService {
    private final LicenseRepository licenseRepository;



    public LicenseService(LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }

    public List<License> allLicense(){
        return licenseRepository.findAll();
    }

    public License addLicense(License l){
        l.setNumber(this.generateLicenseNumber());
        return  licenseRepository.save(l);
    }


    public int generateLicenseNumber() {
        License l = licenseRepository.findTopByOrderByNumberDesc();
        if(l == null)
            return 1;
        int largestNumber = l.getNumber();
        largestNumber++;
        return (largestNumber);
    }


}
