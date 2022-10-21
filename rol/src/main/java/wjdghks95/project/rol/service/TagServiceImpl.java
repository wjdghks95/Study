package wjdghks95.project.rol.service;

import wjdghks95.project.rol.domain.dto.ReviewDto;

import java.util.regex.Pattern;

public class TagServiceImpl implements TagService{

    @Override
    public void createTagList(ReviewDto reviewDto) {
        Pattern pattern = Pattern.compile("#(\\S+)");
    }
}
