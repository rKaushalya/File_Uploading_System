package lk.ijse.fileUpload.service.impl;

import lk.ijse.fileUpload.entity.FileData;
import lk.ijse.fileUpload.repository.FileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service
public class FileDataService implements lk.ijse.fileUpload.service.FileDataService {

    @Autowired
    private FileRepo repo;

    private final String FOLDER_PATH = "C:\\Users\\ASUS\\IdeaProjects\\File_Uploading_System\\Front_End\\assets\\img\\";

    @Override
    public String uploadImage(MultipartFile file) throws IOException {
        String filePath = FOLDER_PATH+file.getOriginalFilename();
        FileData fileData = repo.save(FileData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .filePath(filePath).build());

        file.transferTo(new File(filePath));

        if (fileData != null){
            return "file Upload Success.! " + fileData;
        }
        return null;
    }

    @Override
    public byte[] downloadImage(String fileName) throws IOException {
        Optional<FileData> fileData = repo.findByName(fileName);
        String filePath = fileData.get().getFilePath();
        byte[] image = Files.readAllBytes(new File(filePath).toPath());
        return image;
    }
}
