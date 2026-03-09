package com.swiftbites.api.repository;

import com.swiftbites.api.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRespository extends JpaRepository<CartEntity, Long> {

    List<CartEntity> findByUserId(Long userId);

    void deleteByUserId(Long userId);

}