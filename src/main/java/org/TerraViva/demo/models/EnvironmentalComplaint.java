package org.TerraViva.demo.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.net.URL;
import java.util.Date;


@Entity
@Data
public class EnvironmentalComplaint {

    @Id
    private Long id;


    private String description;
    private String location;
    private Date date;
    private Long userId;
    private URL url;



}
