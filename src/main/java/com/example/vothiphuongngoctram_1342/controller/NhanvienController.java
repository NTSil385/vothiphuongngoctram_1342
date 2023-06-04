package com.example.vothiphuongngoctram_1342.controller;

import com.example.vothiphuongngoctram_1342.model.nhanvien;
import com.example.vothiphuongngoctram_1342.service.NhanvienService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/nhanvien")
public class NhanvienController {
    private static final String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/src/main/resources/static/images";
    @Autowired
    private NhanvienService nhanvienService;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("nhanviens", nhanvienService.GetAll());
        return "nhanviens/index";
    }

    @GetMapping("/{id}")
        // Let's return an object with: data, message, status
    public String findById(@PathVariable("id") String id, Model model){
        nhanvien found = nhanvienService.getNVtById(id);
        if(found != null){
            model.addAttribute("nvById",found);
            return "nhanviens/details";
        }else{
            return "not-found";
        }
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("nv",new nhanvien());
        return "nhanviens/create";
    }

    @PostMapping("/create")
    public String create(@Valid nhanvien newNhanvien
            , BindingResult result,  Model model) throws IOException {
        if(result.hasErrors()){
            model.addAttribute("nv",newNhanvien);
            return "nhanviens/create";
        }

        nhanvienService.add(newNhanvien);
        return "redirect:/nhanvien";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model){
        nhanvien editNV = null;
        for(nhanvien nv : nhanvienService.GetAll()){
            if(nv.getId().equals(id)){
                editNV = nv;
            }
        }
        if(editNV != null){
            model.addAttribute("nv",editNV);
            return "nhanviens/edit";
        }else{
            return "not-found";
        }
    }
    @PostMapping ("/edit")
    public String edit(@Valid @ModelAttribute("nv") nhanvien updatedNV
            , BindingResult bindingResult, Model model)throws IOException{
        if(bindingResult.hasErrors()){
            return "nhanviens/edit";
        }

        for(int i = 0; i<nhanvienService.GetAll().size();i++){
            nhanvien product = nhanvienService.GetAll().get(i);
            if(product.getId() == updatedNV.getId()){
                nhanvienService.GetAll().set(i,updatedNV);
                nhanvienService.update(updatedNV);
                break;
            }
        }
        return "redirect:/nhanvien";
    }



    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id){
        Iterator<nhanvien> iterator = nhanvienService.GetAll().iterator();
        while (iterator.hasNext()){
            nhanvien nv = iterator.next();
            if(nv.getId().equals(id)){
//                iterator.remove();
                nhanvienService.delete(id);
                break;
            }
        }
        return "redirect:/nhanvien";
    }


}
