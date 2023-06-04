package com.example.vothiphuongngoctram_1342.service;

import com.example.vothiphuongngoctram_1342.model.nhanvien;
import com.example.vothiphuongngoctram_1342.repositories.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhanvienService {
    @Autowired
    private NhanVienRepository repository;

    public List<nhanvien> GetAll(){
        return (List<nhanvien>) repository.findAll();
    }

    public nhanvien getNVtById(String id) {
        Optional<nhanvien> optional=repository.findById(id);
        nhanvien nv=null;
        if(optional.isPresent()) {
            nv=optional.get();
        }else {
            throw new RuntimeException("Nhan Vien not found for id::"+id);
        }
        return nv;
    }
    public void add(nhanvien newNhanvien){
        repository.save(newNhanvien);
    }

    public void update(nhanvien Nhanvien){
        repository.save(Nhanvien);
    }

    public void delete(String id){
        repository.deleteById(id);
    }





}
