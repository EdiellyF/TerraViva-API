package org.TerraViva.demo.controllers;

import org.TerraViva.demo.models.EnvironmentalComplaint;

import org.TerraViva.demo.services.EnvComplaintService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/envcomplaint")
public class EnvComplaintController {

    private final EnvComplaintService envService;


    public EnvComplaintController( EnvComplaintService envService) {
        this.envService = envService;
    }


    @PostMapping
    @Transactional
    public void createEnvComplaint(@RequestBody EnvironmentalComplaint env) {
        System.out.println("Received Environmental Complaint: " + env);
        envService.createEnv(env);
    }

    @GetMapping
    public List<EnvironmentalComplaint> getAllEnvComplaints() {
        return envService.findAllEnv();
    }

    @GetMapping("/{id}")
    public EnvironmentalComplaint getEnvComplaintsByEnvId(@PathVariable long id) {
        return envService.findEnvById(id);
    }

    @DeleteMapping("/{id}")// nome tem que ser igual ao parametro...
    public void deleteEnvComplaintsByEnvId(@PathVariable long id) {
        envService.deleteEnv(id);
    }


}
