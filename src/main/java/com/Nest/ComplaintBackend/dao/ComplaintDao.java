package com.Nest.ComplaintBackend.dao;

import com.Nest.ComplaintBackend.model.Complaint;
import org.springframework.data.repository.CrudRepository;

public interface ComplaintDao extends CrudRepository<Complaint, Integer> {
}
