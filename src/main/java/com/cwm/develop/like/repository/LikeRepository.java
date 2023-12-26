package com.cwm.develop.like.repository;

import com.cwm.develop.like.Like_TB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like_TB, Long> {
}