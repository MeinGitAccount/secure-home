package com.jku.at.securehome.repos;

import com.jku.at.securehome.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer> {

    Video findByName(String name);

    boolean existsByName(String name);

    @Query(nativeQuery = true, value="SELECT name FROM video")
    List<String> getAllEntryNames();

    @Query("SELECT name FROM Video WHERE room = :room")
    List<String> getAllVideoNamesByRoom(@Param("room") String room);
}
