package com.epam.data.homework2;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
class Complain {

    @Id
    @GeneratedValue(generator = "incremental")
    private Long id;
    @JsonProperty("Date Received")
    private String dateReceived;
    @JsonProperty("Product Name")
    private String productName;
    @JsonProperty("Sub Product")
    private String subProduct;
    @JsonProperty("Issue")
    private String issue;
    @JsonProperty("Sub Issue")
    private String subIssue;
    @JsonProperty("Consumer Complaint Narrative")
    private String consumerComplaintNarrative;
    @JsonProperty("Company Public Response")
    private String companyPublicResponse;
    @JsonProperty("Company")
    private String Company;
    @JsonProperty("State Name")
    private String stateName;
    @JsonProperty("Zip Code")
    private String zipCode;
    @JsonProperty("Tags")
    private String tags;
    @JsonProperty("Consumer Consent Provided")
    private String consumerConsentProvided;
    @JsonProperty("Submitted via")
    private String submittedVia;
    @JsonProperty("Date Sent to Company")
    private String dateSentToCompany;
    @JsonProperty("Company Response to Consumer")
    private String companyResponseToConsumer;
    @JsonProperty("Timely Response")
    private String timelyResponse;
    @JsonProperty("Consumer Disputed")
    private String consumerDisputed;
    @JsonProperty("Complaint ID")
    private String complaintID;
}
