package com.springboot.cityonlineassignmentbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import com.springboot.cityonlineassignmentbackend.dto.MovieDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movie implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false, length = 19)
    @CreationTimestamp
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated", nullable = false, length = 19)
    @UpdateTimestamp
    private Date updated;

    @Column
    private String name;

    @Column
    private  String releaseYear;
    
    @Column
    private String genreId;

    @Column
    private String rating;
    
    @Column
    private String imageUrl;
    
	
	public void update(Movie movie) {
		id = movie.getId();
		name = movie.getName();
		releaseYear = movie.getReleaseYear();
		genreId = movie.getGenreId();
		rating = movie.getRating();
		imageUrl = movie.getImageUrl();
	}
	
}
