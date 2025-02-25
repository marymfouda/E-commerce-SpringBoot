package com.example.Alfayomi.service.ServiceImpl;
import com.example.Alfayomi.entity.Product;
import com.example.Alfayomi.exceptions.RecordNotFoundException;
import com.example.Alfayomi.repo.ProductRepo;
import com.example.Alfayomi.service.ProductServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServicesImpl implements ProductServices {

    private final ProductRepo productRepo;
    private final ResourceLoader resourceLoader;

    @Override
    @Transactional(readOnly = true)
    public List<Product> getAllProduct() {
        log.info("Fetching all Product");
        return productRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Product> findAllWithPaginationAndSort(int offset, int pageSize, String field) {
        log.info("Fetching all product by pagination and sort");
        Page<Product> products = productRepo.findAll(PageRequest.of(offset , pageSize).withSort(Sort.by(field)));

        return products;
    }

    @Override
    @Transactional(readOnly = true)
    public Product getProduct(Long id) {
        log.info("Fetching product with id : {} ", id);
        Optional<Product> product = productRepo.findById(id);
        if (product.isPresent()) {
            log.info("Product found with id : {} ", id);
            return product.get();
        } else {
            log.warn("product with id {} is not found", id);
            throw new RecordNotFoundException("Product with id " + id + "is not found");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getProductByCategory(String type) {
        log.info("fetching product by category");
        return productRepo.findByCategory(type);
    }
//    @Override
//    public Product createProduct(Product product) throws IOException{
//        if (
//                product.getName() == null ||
//                product.getDescription() == null ||
//                product.getPrice() == null ||
//                product.getStock() == null ||
//                product.getProductImages().isEmpty())
//            {
//                throw new IllegalStateException("Provide all required info");
//            }
//            List<String> imagesPath = new ArrayList<>();
//
//            for (MultipartFile productImage : product.getProductImages()) {
//                File staticFolder = resourceLoader.getResource("classpath:static/").getFile();
//                String filename = productImage.getOriginalFilename();
//                Path targetFilePath = Path.of(staticFolder.getAbsolutePath() + "/" +  filename);
//                log.info("target file path: {} " , targetFilePath);
//                Files.copy(productImage.getInputStream(), targetFilePath, StandardCopyOption.REPLACE_EXISTING);
//                imagesPath.add("/images/" + filename);
//        }
//            return productRepo.save(new Product(product.getName() , product.getDescription() , product.getPrice() , product.getStock() , imagesPath));
//
//    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getProductByCategoryAndPrice(String type, float minPrice, float maxPrice) {
        log.info("Fetching product by category and price");
        return productRepo.findByCategoryIdAndPriceBetween(type , minPrice , maxPrice);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getProductByPrice(float minPrice, float maxPrice) {
        log.info("Fetching product by price");
        return productRepo.findByPriceBetween(minPrice , maxPrice);
    }

    @Override
    @Transactional
    public Product createProduct(Product product) {
        log.info("Insert new product");
        Optional<Product> product1 = productRepo.findByName(product.getName());
        if (product1.isPresent()){
            log.info("product already exist");
            throw new IllegalStateException("Product already exist");
        }else{
            log.info("Product created successfully");
            return productRepo.save(product);
        }
    }

    @Override
    @Transactional
    public Product updateProduct(Long id, Product product) {
        log.info("update Product");
        Product product1 = productRepo.findById(id).orElseThrow(
                () -> new RecordNotFoundException("Product not found")
        );
        product1.setName(product.getName());
        product1.setDescription(product.getDescription());
        product1.setPrice(product.getPrice());
        product1.setProductImages(product.getProductImages());
        product1.setStock(product.getStock());
        product1.setCategory(product.getCategory());

        log.info("Product updated Successfully");
        return productRepo.save(product);
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {
        log.info("Using delete method to delete product");
        Product product = productRepo.findById(id).orElseThrow(() -> new IllegalStateException("Product not exist"));
        productRepo.deleteById(id);
        log.info("Product Deleted successfully");

    }
}
