package wjdghks95.project.rol.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import wjdghks95.project.rol.domain.BaseEntity;

import javax.validation.constraints.NotBlank;

@Getter @Setter
@NoArgsConstructor
public class CommentDto extends BaseEntity {

    @NotBlank(message = "댓글을 입력해주세요.")
    private String content;
}
