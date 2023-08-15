package com.example.JpaDemoMain.demo.Controller;

import com.example.JpaDemoMain.demo.DataAccessLayer.IDataAccessLayer;
import com.example.JpaDemoMain.demo.Exception.ResourceNotFoundException;
import com.example.JpaDemoMain.demo.Model.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/people")
public class ApiService {

    @Autowired
    private IDataAccessLayer IDataAccessLayer;

    @GetMapping
    public List<People> getAllPeople() {
        return IDataAccessLayer.findAll();
    }


    @PostMapping("/create")
    public String createPeople(@RequestBody People people) {
        IDataAccessLayer.save(people);

        return "Successfully Added.";
    }

    @PutMapping("/update/{userId}")
    public String updatePeople(@RequestBody People people, @PathVariable long userId) {
        People updatePeople = IDataAccessLayer.findById(userId).orElseThrow(() -> new ResourceNotFoundException("People Not Found."));

        updatePeople.setName(people.getName());
        updatePeople.setEmail(people.getEmail());

        IDataAccessLayer.save(updatePeople);

        return "Updated Successfully.";
    }

    @GetMapping("/{userId}")
    public ResponseEntity<People> getById(@PathVariable long userId) {
        People people = IDataAccessLayer.findById(userId).orElseThrow(() -> new ResourceNotFoundException("People Not Found."));

        return ResponseEntity.ok(people);
    }

    @DeleteMapping("/delete/{userId}")
    public String deletePeople(@PathVariable long userId) {
        IDataAccessLayer.deleteById(userId);

        return "Deleted";
    }
}
