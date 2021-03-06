package com.campusconnect.neo4j.repositories;

import com.campusconnect.neo4j.types.neo4j.AuditEvent;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import java.util.List;

public interface AuditEventRepository extends GraphRepository<AuditEvent> {

    @Query(value = "MATCH (user:User {id:{0}})-[:ACTIVITY]-(auditEvent:AuditEvent) return auditEvent")
    AuditEvent getAuditEventForUser(String userId);

    @Query(value = "match (user:User {id:{0}}) - [r:CONNECTED {type:\"FRIEND\"}] - (users:User) - [aer:ACTIVITY] -> (auditEvents:AuditEvent) return auditEvents")
    List<AuditEvent> getAuditEventsForFriends(String userId);

    @Query(value = "match (user:User {id:{0}}) - [r:CONNECTED {type:\"FOLLOWING\"}] -> (users:User) - [aer:ACTIVITY] -> (auditEvents:AuditEvent) return auditEvents")
    List<AuditEvent> getAuditEventsForFollowers(String userId);

}
