

package org.globex.retail.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDto {
    private String name;
    
    @JsonProperty("customer_id")    
    private String customer_id;
    private String browser;
    private String region;

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}