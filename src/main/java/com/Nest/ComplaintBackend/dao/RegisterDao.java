package com.Nest.ComplaintBackend.dao;

import com.Nest.ComplaintBackend.model.Register;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RegisterDao extends CrudRepository<Register, Integer> {


    @Query(value = "SELECT `id`, `confirm_password`, `email_id`, `mob_no`, `name`, `password`, `username` FROM `register` WHERE `username`=:username AND `password`  = :password", nativeQuery = true)
    List<Register> userLogin(String username, String password);



    @Query(value = "SELECT `id`, `confirm_password`, `email_id`, `mob_no`, `name`, `password`, `username` FROM `register` WHERE `id` =  :id", nativeQuery = true)
    List<Register> viewUser(int id);
}
