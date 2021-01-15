package com.prokarma.poc.publisher.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * Attributes of an address.
 */
@ApiModel(description = "Attributes of an address.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-01-11T11:44:45.746Z")


public class Address implements Serializable {
    @JsonProperty("addressLine1")
    @NotBlank(message = "addressLine1 is required")
    private String addressLine1 = null;

    @JsonProperty("addressLine2")
    private String addressLine2 = null;

    @JsonProperty("street")
    private String street = null;

    @JsonProperty("postalCode")
    @NotBlank(message = "postalCode is required")
    private String postalCode = null;

    public Address addressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
        return this;
    }

    /**
     * Customer Address Line 1
     *
     * @return addressLine1
     **/
    @ApiModelProperty(required = true, value = "Customer Address Line 1")
    @NotNull

    @Size(min = 1, max = 50)
    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public Address addressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
        return this;
    }

    /**
     * Customer Address Line 2
     *
     * @return addressLine2
     **/
    @ApiModelProperty(value = "Customer Address Line 2")


    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public Address street(String street) {
        this.street = street;
        return this;
    }

    /**
     * Customer Address street
     *
     * @return street
     **/
    @ApiModelProperty(value = "Customer Address street")


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Address postalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    /**
     * Customer Address postal code
     *
     * @return postalCode
     **/
    @ApiModelProperty(example = "50827", required = true, value = "Customer Address postal code")
    @NotNull

    @Size(min = 5, max = 5)
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return Objects.equals(this.addressLine1, address.addressLine1) &&
                Objects.equals(this.addressLine2, address.addressLine2) &&
                Objects.equals(this.street, address.street) &&
                Objects.equals(this.postalCode, address.postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressLine1, addressLine2, street, postalCode);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Address {\n");

        sb.append("    addressLine1: ").append(toIndentedString(addressLine1)).append("\n");
        sb.append("    addressLine2: ").append(toIndentedString(addressLine2)).append("\n");
        sb.append("    street: ").append(toIndentedString(street)).append("\n");
        sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

