package com.travel.proj.app.twit.repository;

import com.travel.proj.app.twit.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BoardRepository extends JpaRepository<Board,Integer> {

}
