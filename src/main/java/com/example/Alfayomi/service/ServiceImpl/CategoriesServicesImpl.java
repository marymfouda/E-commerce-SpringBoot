package com.example.Alfayomi.service.ServiceImpl;

import com.example.Alfayomi.entity.Categories;
import com.example.Alfayomi.exceptions.RecordNotFoundException;
import com.example.Alfayomi.repo.CategoriesRepo;
import com.example.Alfayomi.service.CategoriesServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CategoriesServicesImpl implements CategoriesServices {

    private final CategoriesRepo categoriesRepo;

    public CategoriesServicesImpl(CategoriesRepo categoriesRepo) {
        this.categoriesRepo = categoriesRepo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Categories> getAllCategories() {
        log.info("Fetching all categories");
        return categoriesRepo.findAll();
    }

    @Override
    public Categories createCategories(Categories categories) {
        log.info("use create method to add new category");
        Optional<Categories> category = categoriesRepo.findByType(categories.getType());
        if (category.isPresent()){
            log.warn("category already exist");
            throw new IllegalStateException("category already exist");
        }else {
            log.info("category created successfully");
            return categoriesRepo.save(categories);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Categories getCategory(Long id) {
        Optional<Categories> categories = categoriesRepo.findById(id);
        if(categories.isPresent()){
            log.info("Fetching category with id {}" , id);
            return categories.get();
        }else
            log.info("category with id {} is not found " , id );
        throw new RecordNotFoundException("category with id " +  id + "is not found");
    }

    @Override
    public Categories updateCategories(Long id, Categories categories) {
        log.info("using update method to update category");
        Categories categories1 = categoriesRepo.findById(id).orElseThrow(
                () -> new RecordNotFoundException("category with id " +  id + "is not found")
        );
        categories1.setType(categories.getType());
        categories1.setProducts(categories.getProducts());

        log.info("category updated successfully");
        return categoriesRepo.save(categories);

    }

    @Override
    public void deleteCategories(Long id) {
        log.info("using delete method to delete category");
        Categories categories = categoriesRepo.findById(id).orElseThrow(
                ()-> new RecordNotFoundException("category with id " +  id + "is not found")
        );
        categoriesRepo.deleteById(id);
        log.info("category with id {} deleted successfully" , id );
    }
}
