package pe.edu.vallegrande.app.service.impl;

import lombok.extern.slf4j.Slf4j;
import pe.edu.vallegrande.app.model.Product;
import pe.edu.vallegrande.app.repository.ProductRepository;
import pe.edu.vallegrande.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Flux<Product> findAll() {
        log.info("Listando productos");
        return productRepository.findAll();
    }

    @Override
    public Mono<Product> findById(String id) {
        log.info("Buscando producto por ID: {}", id);
        return productRepository.findById(id);
    }

    @Override
    public Mono<Product> save(Product product) {
        log.info("Guardando producto: {}", product);
        product.setStatus("A");
        product.setCreatedAt(LocalDateTime.now());
        return productRepository.save(product);
    }

    @Override
    public Mono<Product> update(String id, Product product) {
        log.info("Actualizando producto ID: {}", id);
        return productRepository.findById(id)
                .flatMap(existing -> {
                    product.setId(existing.getId());
                    product.setCreatedAt(existing.getCreatedAt());
                    return productRepository.save(product);
                });
    }

    @Override
    public Mono<Void> delete(String id) {
        log.info("Eliminando producto ID: {}", id);
        return productRepository.deleteById(id);
    }

}
