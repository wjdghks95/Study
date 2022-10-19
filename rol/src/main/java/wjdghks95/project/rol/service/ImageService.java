package wjdghks95.project.rol.service;

import org.springframework.web.multipart.MultipartFile;
import wjdghks95.project.rol.domain.entity.Image;

import java.io.IOException;
import java.util.List;

public interface ImageService {

    public List<Image> saveImages(List<MultipartFile> multipartFileList) throws IOException;

    public List<Image> findImages();
}
