package lk.ijse.fileUpload.controller;

import lk.ijse.fileUpload.service.FileDataService;
import lk.ijse.fileUpload.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("/image")
public class FileUploadController {

    @Autowired
    private FileDataService service;

    @PostMapping
    public ResponseUtil saveImage(@RequestParam("file") MultipartFile file) throws IOException {
        String fileData = service.uploadImage(file);
        return new ResponseUtil("OK","Image Saved",fileData);
    }

    @GetMapping(params = {"fileName"})
    public ResponseEntity<?> getImage(@RequestParam String fileName) throws IOException {
        byte[] imageData = service.downloadImage(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);
    }
}
