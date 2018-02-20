package com.app.proj.backend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.proj.backend.entity.Status;
import com.app.proj.backend.repositories.StatusRepository;

/**
 * @author HsuWaiWaiTun
 *
 */

@Service("statusService")
public class StatusService {

	@Autowired
	private StatusRepository statusRepository;
	
	public List<Status> findAllStatus(){
		return (List<Status>) statusRepository.findAll();
	}
	
	public Status addStatus(Status status){
		return statusRepository.save(status);
	}
	
	public Status updateStatus(Status status){
		return statusRepository.save(status);
	}
	
	public void deleteStatus(int id){
		statusRepository.delete(id);
	}
	
	public Status findByStatusId(int statusId){
		return statusRepository.findByStatusId(statusId);
	}
	
	public Status findByStatusName(String statusName){
		return statusRepository.findByStatusName(statusName);
	}
}
