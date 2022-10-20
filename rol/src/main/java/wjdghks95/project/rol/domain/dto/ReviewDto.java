package wjdghks95.project.rol.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class ReviewDto {

    private List<MultipartFile> multipartFiles = new ArrayList<>();

    private String title;

    private String categoryName;

    private String content;

//    private String thumbnailImage;
//
//    private int rating;

}
