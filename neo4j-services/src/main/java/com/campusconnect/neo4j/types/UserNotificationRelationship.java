package com.campusconnect.neo4j.types;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

@RelationshipEntity(type = "NOTIFICATION")
public class UserNotificationRelationship {

	@GraphId
	private Long id;

	@EndNode
	private NotificationEntity notifictionEntity;

	private String type;
	
	@StartNode
	private User user;

	public UserNotificationRelationship() {
		super();
	}

	public UserNotificationRelationship(User user,NotificationEntity notifictionEntity,String type) {
		super();
		this.notifictionEntity = notifictionEntity;
		this.user = user;
		this.type = type;
	} 

	public Long getId() {
		return id;
	}

	public NotificationEntity getNotifictionEntity() {
		return notifictionEntity;
	}

	public String getType() {
		return type;
	}

	public User getUser() {
		return user;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNotifictionEntity(NotificationEntity notifictionEntity) {
		this.notifictionEntity = notifictionEntity;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}