package com.stackroute.repository;

import com.stackroute.domain.Track;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicAlbum extends CrudRepository<Track, Integer> {
//    @Query
//    public List<Track> findByNameAndAge(String userName, int age);

}
