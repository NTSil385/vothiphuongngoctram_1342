package com.example.vothiphuongngoctram_1342.service;

import com.example.vothiphuongngoctram_1342.model.nhanvien;
import com.example.vothiphuongngoctram_1342.model.phongban;
import com.example.vothiphuongngoctram_1342.repositories.NhanVienRepository;
import com.example.vothiphuongngoctram_1342.repositories.PhongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhongBanService {
    @Autowired
    private PhongBanRepository repository;

    public List<phongban> GetAll(){
        return (List<phongban>) repository.findAll();
    }


}
