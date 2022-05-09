package com.example.controller;


import com.example.entity.Laptop;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.repository.LaptopRepository;

import java.util.List;

@RestController
public class LaptopController {


    private LaptopRepository laptopRepository;

    @Value("${app.message}")
    private String message;

    @Autowired
    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @ApiOperation("Method where any people have access")
    @GetMapping("/")
    public String open(){
        return message;
    }

    //url: http://localhost:8080/api/laptops
    @ApiOperation("Method to get a list of the laptops")
    @GetMapping("/api/laptops")
    public ResponseEntity<List<Laptop>> findAll(){

        if(laptopRepository.findAll().size()>0){
            return new ResponseEntity(laptopRepository.findAll(),HttpStatus.OK);
        }else{
            return new ResponseEntity(laptopRepository.findAll(),HttpStatus.NO_CONTENT);
        }
    }

    //url: http://localhost:8080/api/create
    @ApiOperation("Method to create a new laptop")
    @PostMapping("/api/laptop/create")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop){

        if (laptop.getId()==null){//not exist
            System.out.println("guardo");
            return new ResponseEntity(laptopRepository.save(laptop),HttpStatus.CREATED);
        }else{
            System.out.println("no guardo");
            return  new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    //url: http://localhost:8080/api/laptop/id
    @ApiOperation("Method to get a laptop by its id")
    @GetMapping("/api/laptop/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable("id") Long id){

        if(laptopRepository.findById(id)!=null){//exist the laptop
            return new ResponseEntity(laptopRepository.findById(id),HttpStatus.FOUND);
        }else{//not exist the laptop
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //url: http://localhost:8080/api/delete/id
    @ApiOperation("Method to delete a laptop by id")
    @DeleteMapping("/api/laptop/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){

        if(laptopRepository.findById(id).get()!=null){//exist the laptop
            laptopRepository.delete(laptopRepository.findById(id).get());
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    //url: http://localhost:8080/api/laptop/delete
    @ApiOperation("Method to delete all laptops")
    @DeleteMapping("/api/laptop/delete/all")
    public ResponseEntity deleteAll(){

        if (laptopRepository.findAll().size()>0){//exist the list
            laptopRepository.deleteAll();
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //url://localhost:8080/api/laptop/update
    @ApiOperation("Method to update a laptop")
    @PutMapping("/api/laptop/update")
    public ResponseEntity<Laptop> update(Laptop laptop){

        if(laptop.getId()!=null){//the laptop exist, we can update it
            Laptop laptopUpdate = findOneById(laptop.getId()).getBody();
            laptopUpdate.setBrand(laptop.getBrand());
            laptopUpdate.setMemory(laptop.getMemory());
            laptopUpdate.setProcessor(laptop.getProcessor());
            return new ResponseEntity<>(HttpStatus.OK);
        }else{//the laptop not exist, not can create the laptop here
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
