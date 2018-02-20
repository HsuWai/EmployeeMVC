package com.app.proj.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.app.proj.backend.entity.Status;

/**
 * @author HsuWaiWaiTun
 *
 */
@Repository
public interface StatusRepository extends CrudRepository<Status, Integer>{
	
	public Status findByStatusId(Integer statusId);
	public Status findByStatusName(String statusNames);

}
