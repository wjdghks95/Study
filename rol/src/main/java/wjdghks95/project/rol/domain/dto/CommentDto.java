package wjdghks95.project.rol.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import wjdghks95.project.rol.domain.BaseEntity;

@Getter @Setter
@NoArgsConstructor
public class CommentDto extends BaseEntity {

    private String content;
}
