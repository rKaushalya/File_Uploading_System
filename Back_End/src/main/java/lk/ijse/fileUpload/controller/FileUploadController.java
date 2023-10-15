package lk.ijse.fileUpload.controller;

import lk.ijse.fileUpload.service.FileDataService;
import lk.ijse.fileUpload.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseUtil saveImage(@RequestParam("file")MultipartFile file) throws IOException {
        String fileData = service.uploadImage(file);
        return new ResponseUtil("OK","Image Saved",fileData);
    }

    @GetMapping(params = {"fileName"})
    public ResponseUtil getImage(@RequestParam String fileName) throws IOException {
        byte[] bytes = service.downloadImage(fileName);
        return new ResponseUtil("OK","Image Loaded",bytes);
    }
}
