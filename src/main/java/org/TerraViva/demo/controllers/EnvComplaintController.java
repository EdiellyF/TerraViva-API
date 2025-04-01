package org.TerraViva.demo.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.TerraViva.demo.models.EnvironmentalComplaint;
import org.TerraViva.demo.repositories.EnvComplaintRepository;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/envcomplaint")
public class EnvComplaintController {

    private final EnvComplaintRepository envComplaintRepository;


    public EnvComplaintController(EnvComplaintRepository envComplaintRepository) {
        this.envComplaintRepository = envComplaintRepository;
    }


    @PostMapping
    @Transactional
    public void createEnvComplaint(@RequestBody EnvironmentalComplaint env) {
        System.out.println("Received Environmental Complaint: " + env);
        this.envComplaintRepository.save(env);
    }
}
