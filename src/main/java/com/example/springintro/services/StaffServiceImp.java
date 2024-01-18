package com.example.springintro.services;

import com.example.springintro.entity.Staff;
import com.example.springintro.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImp implements StaffService {

    @Autowired
    private StaffRepository staffRepository;

    @Override
    public void CreateStaff(String name, int age) {
        Staff staff = new Staff();
        staff.setName(name);
        staff.setAge(age);
        staffRepository.save(staff);

    }
}
