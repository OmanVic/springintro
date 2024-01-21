package com.example.springintro.services;

import com.example.springintro.entity.Staff;

import java.util.List;

public interface StaffService {
    public void CreateStaff(String name, int age);
    public List<Staff> getAllStaff();

    public Staff getStaff(Long id);

    public void updateStaff(Staff staff);

    public void deleteStaff(Long id);
}
