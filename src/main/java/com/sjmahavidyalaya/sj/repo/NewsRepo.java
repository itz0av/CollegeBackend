package com.sjmahavidyalaya.sj.repo;
import com.sjmahavidyalaya.sj.model.CollegeNews;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepo extends JpaRepository<CollegeNews, Long> {
}

