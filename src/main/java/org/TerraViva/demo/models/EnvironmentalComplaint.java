package org.TerraViva.demo.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;


import java.util.Date;



@Entity
@Table(name = "environmental_complaint")
public class EnvironmentalComplaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description_column")  // Define o nome da coluna no banco de dados
    private String description;

    @Column(name = "location_column", nullable = false)  // Define o nome da coluna no banco de dados
    private String location;


    @Column(name = "date_column", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;

    @Column(name = "url_column")
    private String url;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public EnvironmentalComplaint() {

    }

    public EnvironmentalComplaint(Long id, String description, String location, Date date, String url) {
        this.id = id;
        this.description = description;
        this.location = location;
        this.date = date;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
