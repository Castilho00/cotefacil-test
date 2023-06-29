package com.castilho.cotefaciltest.repository;

import com.castilho.cotefaciltest.entities.SwInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SwRepository extends JpaRepository<SwInfo, Integer> {
    SwInfo findByNameContainingIgnoreCase(String name);
}
