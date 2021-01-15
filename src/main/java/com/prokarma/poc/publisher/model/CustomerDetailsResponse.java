package com.prokarma.poc.publisher.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * CustomerDetailsResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-01-11T11:44:45.746Z")


public class CustomerDetailsResponse {
    @JsonProperty("status")
    private String status;

    @JsonProperty("message")
    private String message;

    public CustomerDetailsResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    /**
     * success
     *
     * @return status
     **/
    @ApiModelProperty(value = "success")


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CustomerDetailsResponse message(String message) {
        this.message = message;
        return this;
    }

    /**
     * Customer Address postal code
     *
     * @return message
     **/
    @ApiModelProperty(value = "Customer Address postal code")


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomerDetailsResponse response = (CustomerDetailsResponse) o;
        return Objects.equals(this.status, response.status) &&
                Objects.equals(this.message, response.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, message);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CustomerDetailsResponse {\n");

        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

