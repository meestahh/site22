package com.example.site;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TheaterRepository extends JpaRepository<Theater,Long>{
    @Query("SELECT p FROM Theater p WHERE concat(p.name_, '', p.actors_name, '', p.date_theater, '', p.time_theater, '', p.all_ticket, '', p.purchased_ticket) LIKE %?1%")
    List<Theater> search(String keyword);
}
