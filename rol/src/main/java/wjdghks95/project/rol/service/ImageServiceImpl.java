package wjdghks95.project.rol.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import wjdghks95.project.rol.domain.FileStore;
import wjdghks95.project.rol.domain.entity.Image;
import wjdghks95.project.rol.repository.ImageRepository;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService{

    private final ImageRepository imageRepository;
    private final FileStore fileStore;

    @Override
    public List<Image> saveImages(List<MultipartFile> multipartFileList) throws IOException {
        List<Image> images = fileStore.storeFiles(multipartFileList);
        return images;
    }

    @Override
    public List<Image> findImages() {
        return null;
    }
}
