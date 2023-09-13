package com.springdatajpa.springdatajpacourse.repository;

import com.springdatajpa.springdatajpacourse.entity.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductRepositoryTest {
    private ProductRepository productRepository;
    @Autowired
    public ProductRepositoryTest(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @Test
    void saveMethod(){
        Product product = new Product();
            product.setName("product 1");
            product.setDescription("product 1 description");
            product.setSku("100ACB");
            product.setPrice(new BigDecimal(100));
            product.setActive(true);
            product.setImageUrl("product.png");
        Product savedObject = productRepository.save(product);
        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());
    }
    @Test
    void updateUsingSaveMethod(){
        Long id = 1l;
        Product product = productRepository.findById(id).get();
        product.setName("updated product 1");
        product.setDescription("updated description");
        productRepository.save(product);
    }
    @Test
    void findByIdMethod(){
        Long id = 1l;
        Product product = productRepository.findById(id).get();
    }
    @Test
    void saveAllMethod(){
        Product product = new Product();
        product.setName("product 2");
        product.setDescription("product 2 description");
        product.setSku("111MCA");
        product.setPrice(new BigDecimal(200));
        product.setActive(true);
        product.setImageUrl("product2.png");

        Product product2 = new Product();
        product2.setName("product 3");
        product2.setDescription("product 3 description");
        product2.setSku("111CAM");
        product2.setPrice(new BigDecimal(300));
        product2.setActive(true);
        product2.setImageUrl("product3.png");
        productRepository.saveAll(List.of(product , product2));
    }
    @Test
    void findAll(){
        List<Product> products = productRepository.findAll();
        products.forEach((p) ->{
            System.out.println(p.getName());
        });
    }
    @Test
    void deleteById(){
        Long id = 1l;
        productRepository.deleteById(id);
    }
    @Test
    void deleteMethod(){
        Long id = 2L;
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
    }
    @Test
    void deleteAllMethod(){
        Product product1 = productRepository.findById(1l).get();
        Product product2 = productRepository.findById(2l).get();
        productRepository.deleteAll(List.of(product1 , product2));
    }
    @Test
    void deleteAll(){
        productRepository.deleteAll();
    }
}