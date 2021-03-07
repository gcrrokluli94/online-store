package online.store.services;

public class Kot {

//    public Product updateProduct(final ProductDTO productDTO, final Long productId){
//        Product product = this.productRepository.findById(productId)
//                .orElseThrow(()-> new NotFoundException(ErrorMessages.ID_NOT_FOUND_EXCEPTION));
//        product.setProductName(productDTO.getProductName());
//        product.setDescription(productDTO.getDescription());
//        product.setPrice(productDTO.getPrice());
//        product.setImageUrl(productDTO.getImageUrl());
//        product.setProductType(productDTO.getProductType());
//        return product;
//    }


//    public Product saveProduct(final ProductDTO productDTO) {
//        Product product = new Product();
//        ProductCategory category = this.productCategoryRepository.findById(productDTO.getCategoryId())
//                .orElseThrow(() -> new NotFoundException(ErrorMessages.ID_NOT_FOUND_EXCEPTION));
//        Author author = this.authorRepository.findById(productDTO.getAuthorId())
//                .orElseThrow(() -> new NotFoundException(ErrorMessages.ID_NOT_FOUND_EXCEPTION));
//        product.setProductName(productDTO.getProductName());
//        product.setDescription(productDTO.getDescription());
//        product.setPrice(productDTO.getPrice());
//        product.setImageUrl(productDTO.getImageUrl());
//        product.setProductStatus(productDTO.getProductStatus());
//        product.setProductType(productDTO.getProductType());
//        product.setAuthor(author);
//        product.setProductCategory(category);
//        return this.productRepository.save(product);
//    }

    /// controller per update the product
//    @PutMapping("/product/{productId}")
//    public ResponseEntity<Product> putProduct(@RequestBody final ProductDTO productDTO, @PathVariable("productId") final Long productId) throws NotFoundException {
//        Product product = this.productService.updateProduct(productDTO, productId);
//        return ResponseEntity.ok(product);
//    }

}
