package com.example.vothiphuongngoctram_1342.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "NHAN_VIEN")
public class nhanvien {
    @Id
    @NotBlank(message = "Trường này không được phép bỏ trống")
    @Length(min = 3, max = 3, message = "Phải nhập vào 3 ký tự bao gồm chữ và số")
    @Column(name = "Ma_NV")
    private String id;

    @NotBlank(message = "Trường này không được phép bỏ trống")
    @Length(min = 3, max = 100, message = "Phải nhập tên nhân viên")
    @Column(name = "Ten_NV")
    private String tenNv;

    @Length(min = 0, max = 3, message = "nhập giới tính")
    @Column(name = "Phai")
    private String phai;

    @Length(min = 0, max = 200, message = "nhập nơi sinh")
    @Column(name = "Noi_sinh")
    private String noisinh;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maphong")
    private phongban phongban;





    @Column(name = "Lương")
    private int luong;


    public nhanvien(){}

    public nhanvien(String id, String tenNv, String phai, String noisinh, int luong, phongban phongban1) {
        this.id = id;
        this.tenNv = tenNv;
        this.phai = phai;
        this.noisinh = noisinh;
        this.phongban = phongban1;
        this.luong = luong;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenNv() {
        return tenNv;
    }

    public void setTenNv(String tenNv) {
        this.tenNv = tenNv;
    }

    public String getPhai() {
        return phai;
    }

    public void setPhai(String phai) {
        this.phai = phai;
    }

    public String getNoisinh() {
        return noisinh;
    }

    public void setNoisinh(String noisinh) {
        this.noisinh = noisinh;
    }

    public com.example.vothiphuongngoctram_1342.model.phongban getPhongban() {
        return phongban;
    }

    public void setPhongban(com.example.vothiphuongngoctram_1342.model.phongban phongban) {
        this.phongban = phongban;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    @Override
    public String toString() {
        return "nhanvien{" +
                "id='" + id + '\'' +
                ", tenNv='" + tenNv + '\'' +
                ", phai='" + phai + '\'' +
                ", noisinh='" + noisinh + '\'' +

                ", luong=" + luong +
                '}';
    }


}
