package online.store.services;

import online.store.entities.ProductEntity;
import online.store.repositories.ProductDetailedService;
import online.store.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements ProductDetailedService {

        @Autowired
        private ProductRepository productRepository;

        public List<ProductEntity> readAllProduct(){
           return productRepository.findAll();
        }

}
