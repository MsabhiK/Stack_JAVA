package com.example.lookify.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.lookify.models.Song;

@Repository
public interface SongRepo extends CrudRepository<Song, Long> {
	
	List<Song> findAll();
	
	@Query(value = "SELECT * FROM songs", nativeQuery = true) 
	List<Song> getTopTen();
	
	// this method finds books with descriptions containing the search string
    List<Song> findByArtistContaining(String artist);
    
    // this method counts how many titles contain a certain string
    Long countByTitleContaining(String search);
    
    // this method deletes a book that starts with a specific title
    Long deleteByTitleStartingWith(String search);
}
