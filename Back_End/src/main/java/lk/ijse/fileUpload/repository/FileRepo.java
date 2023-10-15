package lk.ijse.fileUpload.repository;

import lk.ijse.fileUpload.entity.FileData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileRepo extends JpaRepository<FileData,Integer> {
    Optional<FileData> findByName(String fileName);
}
