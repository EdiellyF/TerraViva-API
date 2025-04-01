package org.TerraViva.demo.repositories;

import org.TerraViva.demo.models.EnvironmentalComplaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvComplaintRepository extends JpaRepository<EnvironmentalComplaint, Long> {
}
