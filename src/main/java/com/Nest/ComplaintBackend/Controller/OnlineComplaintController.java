package com.Nest.ComplaintBackend.Controller;

import com.Nest.ComplaintBackend.dao.RegisterDao;
import com.Nest.ComplaintBackend.model.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;


@RestController
public class OnlineComplaintController {


    @Autowired
    private RegisterDao dao;
    @CrossOrigin(origins = "*")
    @PostMapping("/")
    public HashMap<String, String> adminLogin(){

        HashMap<String, String> map = new HashMap<>();
        map.put("status","success");
        return map;

    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/register", consumes = "application/json" , produces = "application/json")
    public HashMap<String, String> userRegister(@RequestBody Register r){

        dao.save(r);
        HashMap<String, String> map = new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userLogin",consumes = "application/json", produces = "application/json")
    public HashMap<String,String> userLogin(@RequestBody Register r){

        HashMap<String , String> map = new HashMap<>();
        List<Register> result = dao.userLogin(r.getUsername(), r.getPassword());

        if(result.size()==0){

            map.put("status", "failed");
        }
        else {

            int id = result.get(0).getId();
            map.put("message","user login success");
            map.put("userId", String.valueOf(id));
            map.put("status","success");
        }
        return map;

        }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/viewProfile", consumes = "application/json", produces = "application/json")
    public List<Register> viewProfile(@RequestBody Register r){

        return dao.viewUser(r.getId());
    }


    }



