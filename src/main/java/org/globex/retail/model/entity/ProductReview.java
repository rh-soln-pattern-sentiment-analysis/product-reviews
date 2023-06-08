package org.globex.retail.model.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.common.Parameters;

import java.util.List;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "ProductReview")
@Table(name = "product_reviews")
@Cacheable
@NamedQueries({
    @NamedQuery(name = "Reviews.findByProductId", query = "from ProductReview where product_id in :productId")
})
public class ProductReview extends PanacheEntityBase {

    @Id
    @Column(name = "review_id")
    public long reviewId;

    @Column(name = "product_id")
    public String productId;

    @Column(name = "user_id")
    public String userId;

    @Column(name = "user_name")
    public String userName;

    @Column(name = "rating")
    public Integer rating;

    @Column(name = "review_date")
    public LocalDateTime reviewDate;

    @Column(name = "review_text")
    public String reviewText;

    public static List<ProductReview> findByProductId(String  id) {
        return find("#Reviews.findByProductId", Parameters.with("productId", id)).list();
    }


}