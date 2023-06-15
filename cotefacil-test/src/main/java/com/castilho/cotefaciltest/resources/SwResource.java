package com.castilho.cotefaciltest.resources;

import com.castilho.cotefaciltest.entities.SwInfo;
import com.castilho.cotefaciltest.services.SwService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sw")
public class SwResource {

    @Autowired
    private SwService service;

    @GetMapping
    public ResponseEntity<List<SwInfo>> findAll(){
        List<SwInfo> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "id/{id}")
    public ResponseEntity<SwInfo> findById(@PathVariable Integer id){
        SwInfo obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "name/{name}")
    public ResponseEntity<SwInfo> findByName(@PathVariable String name){
        SwInfo obj = service.findByName(name);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<SwInfo> save(@RequestBody SwInfo swInfo){
        SwInfo obj = service.save(swInfo);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Integer id){
        service.deleteById(id);
    }
}
