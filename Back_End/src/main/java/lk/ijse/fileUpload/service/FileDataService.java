package lk.ijse.fileUpload.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileDataService {
    String uploadImage(MultipartFile file) throws IOException;
    byte[] downloadImage(String fileName) throws IOException;
}
