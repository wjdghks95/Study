package wjdghks95.project.rol.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wjdghks95.project.rol.domain.entity.Category;
import wjdghks95.project.rol.domain.entity.CategoryName;
import wjdghks95.project.rol.repository.CategoryRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(String categoryValue) {

        CategoryName categoryName = CategoryName.valueOf(categoryValue.toUpperCase());

        Category category = categoryRepository.findByCategoryName(categoryName)
                .orElseGet(() -> Category.builder()
                        .categoryName(categoryName)
                        .build()
        );
        if (!categoryRepository.existsByCategoryName(categoryName)) {
            return categoryRepository.save(category);
        }

        return category;
    }
}
