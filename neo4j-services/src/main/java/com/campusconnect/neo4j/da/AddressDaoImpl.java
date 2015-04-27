package com.campusconnect.neo4j.da;

import com.campusconnect.neo4j.da.iface.AddressDao;
import com.campusconnect.neo4j.da.iface.AuditEventDao;
import com.campusconnect.neo4j.repositories.AddressRepository;
import com.campusconnect.neo4j.types.Address;
import com.campusconnect.neo4j.types.AuditEventType;
import com.campusconnect.neo4j.types.Event;
import com.campusconnect.neo4j.types.IdType;
import com.campusconnect.neo4j.types.Target;
import com.googlecode.ehcache.annotations.KeyGenerator;
import com.googlecode.ehcache.annotations.PartialCacheKey;
import com.googlecode.ehcache.annotations.Property;
import com.googlecode.ehcache.annotations.TriggersRemove;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by sn1 on 4/16/15.
 */
public class AddressDaoImpl implements AddressDao {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private  AuditEventDao auditEventDao; 
    
    @Override
    public List<Address> getAddresses(String userId) {
        return addressRepository.getAddressForUser(userId);    
    }
    
    @Override
    public Address getAddress(String addressId) {
        return addressRepository.findOne(Long.parseLong(addressId));
    }

    @Override
    @TriggersRemove(cacheName = "userIdCache", keyGenerator = @KeyGenerator(name = "HashCodeCacheKeyGenerator", properties = @Property(name = "includeMethod", value = "false")))
    public Address createAddress(Address address, @PartialCacheKey String userId) {
        return addressRepository.save(address);
    }
    
    @Override
    @TriggersRemove(cacheName = "userIdCache", keyGenerator = @KeyGenerator(name = "HashCodeCacheKeyGenerator", properties = @Property(name = "includeMethod", value = "false")))
    public Address updateAddress(Address address, @PartialCacheKey String userId) {
    	
    	Address updatedAddress = addressRepository.save(address);
    	ObjectMapper objectMapper = new ObjectMapper();
    	try
    	{
    	Long currentTime = System.currentTimeMillis();
    	
    	String targetEvent = objectMapper.writeValueAsString(updatedAddress);
    	
    	Target target = new Target(IdType.USER_ID.toString(), targetEvent, null);	
    	Event updatedAddressUserEvent = new Event(AuditEventType.UPDATED_ADDRESS.toString(), target,currentTime);
    	auditEventDao.addEvent(userId, updatedAddressUserEvent);
    	
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
        return updatedAddress;
    }
    
    @Override
    @TriggersRemove(cacheName = "userIdCache", keyGenerator = @KeyGenerator(name = "HashCodeCacheKeyGenerator", properties = @Property(name = "includeMethod", value = "false")))
    public void deleteAddress(String addressId, @PartialCacheKey String userId) {
        addressRepository.delete(Long.parseLong(addressId));
    }
}
