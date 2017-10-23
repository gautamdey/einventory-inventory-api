package com.technath.einventory.rest.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.Column;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigInteger;

@JsonRootName(value = "product")
@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductDTO {

    @XmlElement(name = "id")
    @JsonProperty("supplierid")
    private long id;

    @XmlElement(name = "productcode")
    @JsonProperty("productcode")
    private String productCode;

    @XmlElement(name = "name")
    @JsonProperty("name")
    private String name;


    @XmlElement(name = "description")
    @JsonProperty("description")
    private String description;

    @XmlElement(name = "categoryid")
    @JsonProperty("categoryid")
    private BigInteger categoryId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(BigInteger categoryId) {
        this.categoryId = categoryId;
    }
}
