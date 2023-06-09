package org.globex.retail.service;


import javax.enterprise.context.ApplicationScoped;

import org.globex.retail.model.entity.ProductReview;

import java.util.List;

@ApplicationScoped
public class ProductReviewService {

    public List<ProductReview> getProductRreviewsList(String id) {
        return ProductReview.findByProductId(id);
    }

}
