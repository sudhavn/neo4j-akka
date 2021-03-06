package com.campusconnect.neo4j.types.web;


/**
 * Created by sn1 on 2/26/15.
 */
public class BorrowRequest {

    private String ownerUserId;
    private String borrowerUserId;
    private int contractPeriodInDays;
    private Long borrowDate;
    private String additionalMessage;

    public BorrowRequest() {
    }

    public BorrowRequest(String ownerUserId, String borrowerUserId, int contractPeriodInDays, Long borrowDate, String additionalMessage) {

        this.ownerUserId = ownerUserId;
        this.borrowerUserId = borrowerUserId;
        this.contractPeriodInDays = contractPeriodInDays;
        this.borrowDate = borrowDate;
        this.additionalMessage = additionalMessage;
    }


    public String getOwnerUserId() {

        return ownerUserId;
    }

    public void setOwnerUserId(String ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

    public String getBorrowerUserId() {
        return borrowerUserId;
    }

    public void setBorrowerUserId(String borrowerUserId) {
        this.borrowerUserId = borrowerUserId;
    }

    public int getContractPeriodInDays() {
        return contractPeriodInDays;
    }

    public void setContractPeriodInDays(int contractPeriodInDays) {
        this.contractPeriodInDays = contractPeriodInDays;
    }

    public Long getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Long borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getAdditionalMessage() {
        return additionalMessage;
    }

    public void setAdditionalMessage(String additionalMessage) {
        this.additionalMessage = additionalMessage;
    }
}
