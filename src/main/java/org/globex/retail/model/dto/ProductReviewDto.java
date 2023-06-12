package org.globex.retail.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductReviewDto {
    private ProductDto product;
    private int rating;
    private long timestamp;
    
    @JsonProperty("review_text")
    private String reviewText;
    
    private UserDto user;

    
    // Getters and setters

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }
}


