package com.example.backend_filter.repository;

import com.example.backend_filter.entity.DetailCommon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailCommonRepository extends JpaRepository<DetailCommon, String> {
}
