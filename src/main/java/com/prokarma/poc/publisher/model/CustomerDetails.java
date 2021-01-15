package com.prokarma.poc.publisher.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * CustomerDetails
 */
@ApiModel(description = "CustomerDetails")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-01-11T11:44:45.746Z")

public class CustomerDetails implements Serializable {
    @JsonProperty("customerNumber")
    @NotBlank(message = "customerNumber is required")
    private String customerNumber;

    @JsonProperty("firstName")
    @NotBlank(message = "firstName is required")
    private String firstName;

    @JsonProperty("lastName")
    @NotBlank(message = "lastName is required")
    private String lastName;

    @JsonProperty("birthDate")
    @NotNull(message = "birthDate is required")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date birthDate;

    @JsonProperty("country")
    @NotBlank(message = "country is required")
    private String country;

    @JsonProperty("countryCode")
    @NotBlank(message = "countryCode is required")
    private String countryCode;

    @JsonProperty("mobileNumber")
    @NotBlank(message = "mobileNumber is required")
    private String mobileNumber;

    @JsonProperty("email")
    @NotBlank(message = "email is required")
    private String email;

    @JsonProperty("customerStatus")
    @NotNull(message = "customerStatus is required")
    private CustomerStatusEnum customerStatus;

    @JsonProperty("address")
    @NotNull(message = "address is required")
    private Address address;

    public CustomerDetails customerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
        return this;
    }

    /**
     * Customer Number
     *
     * @return customerNumber
     **/
    @ApiModelProperty(example = "C000000001", required = true, value = "Customer Number")
    @NotNull

    @Size(min = 10, max = 10)
    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public CustomerDetails firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * First Name
     *
     * @return firstName
     **/
    @ApiModelProperty(required = true, value = "First Name")
    @NotNull

    @Size(min = 10, max = 50)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public CustomerDetails lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Last Name
     *
     * @return lastName
     **/
    @ApiModelProperty(required = true, value = "Last Name")
    @NotNull

    @Size(min = 10, max = 50)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public CustomerDetails birthDate(Date birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    /**
     * Birth date
     *
     * @return birthDate
     **/
    @ApiModelProperty(example = "25-09-1991", required = true, value = "Birth date")
    @NotNull

    @Valid

    public Date getBirthdate() {
        return birthDate;
    }

    public void setBirthdate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public CustomerDetails country(String country) {
        this.country = country;
        return this;
    }

    /**
     * country
     *
     * @return country
     **/
    @ApiModelProperty(example = "India", required = true, value = "country")
    @NotNull

    @Pattern(regexp = "^.*$")
    @Size(min = 2)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public CustomerDetails countryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    /**
     * Country Code
     *
     * @return countryCode
     **/
    @ApiModelProperty(example = "IN", required = true, value = "Country Code")
    @NotNull

    @Size(min = 2, max = 2)
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public CustomerDetails mobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
        return this;
    }

    /**
     * Mobile Number
     *
     * @return mobileNumber
     **/
    @ApiModelProperty(example = "9876543210", required = true, value = "Mobile Number")
    @NotNull

    @Size(min = 10, max = 10)
    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public CustomerDetails email(String email) {
        this.email = email;
        return this;
    }

    /**
     * Email
     *
     * @return email
     **/
    @ApiModelProperty(example = "abc@gmail.com", required = true, value = "Email")
    @NotNull

    @Size(max = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CustomerDetails customerStatus(CustomerStatusEnum customerStatus) {
        this.customerStatus = customerStatus;
        return this;
    }

    /**
     * Customer Status
     *
     * @return customerStatus
     **/
    @ApiModelProperty(example = "Open", required = true, value = "Customer Status")
    @NotNull


    public CustomerStatusEnum getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(CustomerStatusEnum customerStatus) {
        this.customerStatus = customerStatus;
    }

    public CustomerDetails address(Address address) {
        this.address = address;
        return this;
    }

    /**
     * Get address
     *
     * @return address
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomerDetails customerDetails = (CustomerDetails) o;
        return Objects.equals(this.customerNumber, customerDetails.customerNumber) &&
                Objects.equals(this.firstName, customerDetails.firstName) &&
                Objects.equals(this.lastName, customerDetails.lastName) &&
                Objects.equals(this.birthDate, customerDetails.birthDate) &&
                Objects.equals(this.country, customerDetails.country) &&
                Objects.equals(this.countryCode, customerDetails.countryCode) &&
                Objects.equals(this.mobileNumber, customerDetails.mobileNumber) &&
                Objects.equals(this.email, customerDetails.email) &&
                Objects.equals(this.customerStatus, customerDetails.customerStatus) &&
                Objects.equals(this.address, customerDetails.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerNumber, firstName, lastName, birthDate, country, countryCode, mobileNumber, email, customerStatus, address);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CustomerDetails {\n");

        sb.append("    customerNumber: ").append(toIndentedString(customerNumber)).append("\n");
        sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
        sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
        sb.append("    birthDate: ").append(toIntendedFormat(birthDate)).append("\n");
        sb.append("    country: ").append(toIndentedString(country)).append("\n");
        sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
        sb.append("    mobileNumber: ").append(toIndentedString(mobileNumber)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    customerStatus: ").append(toIndentedString(customerStatus)).append("\n");
        sb.append("    address: ").append(toIndentedString(address)).append("\n");
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

    /**
     * Convert the given date to intended format string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIntendedFormat(java.util.Date o) {
        if (o == null) {
            return "null";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(o).replace("\n", "\n    ");
    }

    /**
     * Customer Status
     */
    public enum CustomerStatusEnum {
        OPEN("O"),

        CLOSE("C"),

        SUSPENDED("S"),

        RESTORED("R");

        public String getValue() {
            return value;
        }

        private String value;

        CustomerStatusEnum(String value) {
            this.value = value;
        }

       /* @JsonCreator
        public static CustomerStatusEnum fromValue(String text) {
            for (CustomerStatusEnum b : CustomerStatusEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }*/


    }
}

