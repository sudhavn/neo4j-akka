package com.campusconnect.neo4j.types.neo4j;

import com.campusconnect.neo4j.util.Constants;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

@RelationshipEntity(type = Constants.REMINDER_RELATION)
public class ReminderRelationShip {

    @CreatedBy
    private String createdBy;

    @CreatedDate
    private Long createdDate;

    @GraphId
    private Long id;

    private Long lastModified;

    @EndNode
    private Reminder reminder;

    @StartNode
    private User reminderFor;

    private String type;

    public ReminderRelationShip() {

    }

    public ReminderRelationShip(String createdBy, Long createdDate, User reminderFor,
                                Long lastModified, String type, Reminder reminder) {
        super();
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.reminderFor = reminderFor;
        this.lastModified = lastModified;
        this.type = type;
        this.reminder = reminder;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLastModified() {
        return lastModified;
    }

    public void setLastModified(Long lastModified) {
        this.lastModified = lastModified;
    }

    public Reminder getReminder() {
        return reminder;
    }

    public void setReminder(Reminder reminder) {
        this.reminder = reminder;
    }

    public User getReminderFor() {
        return reminderFor;
    }

    public void setReminderFor(User reminderFor) {
        this.reminderFor = reminderFor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
