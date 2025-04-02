package org.TerraViva.demo.services;

import org.TerraViva.demo.models.EnvironmentalComplaint;
import org.TerraViva.demo.repositories.EnvComplaintRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class EnvComplaintService {


    private final EnvComplaintRepository envComplaintRepository;

    public EnvComplaintService(EnvComplaintRepository envComplaintRepository) {
        this.envComplaintRepository = envComplaintRepository;
    }


    @Transactional
    public void createEnv(EnvironmentalComplaint env){
       envComplaintRepository.save(env);
    }

    @Transactional
    public EnvironmentalComplaint updateEnv(EnvironmentalComplaint env){
        EnvironmentalComplaint environmentalComplaint = findEnvById(env.getId());
        environmentalComplaint.setDescription(env.getDescription());
        return envComplaintRepository.save(env);

    }


    public EnvironmentalComplaint findEnvById(Long envId){
       return envComplaintRepository.findById(envId)
                .orElseThrow(()->new RuntimeException("Env id not found"));

   }

   public List<EnvironmentalComplaint> findAllEnv(){
        return envComplaintRepository.findAll();
   }

   @Transactional
   public void deleteEnv(Long envId){
        findEnvById(envId);
        try {
            envComplaintRepository.deleteById(envId);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting env id " + envId);
        }

   }



}
