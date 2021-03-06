package com.campusconnect.neo4j.types.neo4j;


import com.campusconnect.neo4j.util.Constants;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

/**
 * Created by sn1 on 1/19/15.
 */
@RelationshipEntity(type = Constants.CONNECTED_RELATION)
public class UserRelation {
    @GraphId
    private Long id;
    @StartNode
    private User user1;
    @EndNode
    private User user2;
    private String type;
    @CreatedDate
    private Long createdDate;

    public UserRelation(User user1, User user2, Long createdDate, String type) {
        this.type = type;
        this.user1 = user1;
        this.user2 = user2;
        this.createdDate = createdDate;
    }

    public UserRelation() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }
}
