package com.Nest.ComplaintBackend.Controller;


import com.Nest.ComplaintBackend.dao.ComplaintDao;
import com.Nest.ComplaintBackend.model.Complaint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class ComplaintController {


    @Autowired
    private ComplaintDao dao;
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/complaints", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> addCompliant(@RequestBody Complaint c){

        dao.save(c);

        HashMap<String, String>  map = new HashMap<>();
        map.put("status", "success");

        return map;
    }
}
