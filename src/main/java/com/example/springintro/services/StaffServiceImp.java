package com.example.springintro.services;

import com.example.springintro.entity.Staff;
import com.example.springintro.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Staff> getAllStaff() {
        List<Staff> staffList = staffRepository.findAll();
        return staffList;
    }

    @Override
    public Staff getStaff(long id) {
        Optional<Staff> optionalStaff = staffRepository.findById(id);

        if (optionalStaff.isPresent()) {
            Staff staff = optionalStaff.get();
            return staff;
        }
        return null;
    }

    @Override
    public void updateStaff(Staff staff) {
        staffRepository.save(staff);
    }
}
