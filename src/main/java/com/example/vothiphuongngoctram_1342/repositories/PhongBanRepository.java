package com.example.vothiphuongngoctram_1342.repositories;

import com.example.vothiphuongngoctram_1342.model.nhanvien;
import com.example.vothiphuongngoctram_1342.model.phongban;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhongBanRepository extends JpaRepository<phongban, String> {
}
