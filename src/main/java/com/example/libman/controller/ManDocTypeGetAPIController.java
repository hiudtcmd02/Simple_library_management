package com.example.libman.controller;

import com.example.libman.entity.LoaiTaiLieu;
import com.example.libman.service.LoaiTaiLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/getData")
public class ManDocTypeGetAPIController {
    @Autowired
    private LoaiTaiLieuService loaiTaiLieuService;

    //Trang quản lý loại tài liệu
    @GetMapping("/listDocType")
    public List<LoaiTaiLieu> manDocType_listDocType(){
        return loaiTaiLieuService.listAll();
    }

    //Trang quản lý loại tài liệu, hiển thị bảng sau khi đã tìm kiếm loại tài liệu
    @GetMapping("/searchDocType")
    public List<LoaiTaiLieu> searchDocuments(@RequestParam String name) {
        return loaiTaiLieuService.listAllByName(name);
    }
    //Xem thông tin chi tiết loại tài liệu
    @GetMapping("/detailDocType/{docTypeId}")
    public LoaiTaiLieu getDetailDocType(@PathVariable int docTypeId){
        return loaiTaiLieuService.getLoaiTaiLieuById(docTypeId);
    }
    //Sửa loại tài liệu
    @PutMapping("/editDocType/{id}")
    public ResponseEntity<LoaiTaiLieu> updateDocType(@PathVariable int id, @RequestBody LoaiTaiLieu docTypeEdited) {
        final LoaiTaiLieu updatedltl = loaiTaiLieuService.edit(id, docTypeEdited);
        return ResponseEntity.ok(updatedltl);
    }
    //Xóa loại tài liệu
    @DeleteMapping("/deleteDocType/{id}")
    public ResponseEntity<Void> deleteDocType(@PathVariable int id) {
        loaiTaiLieuService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
