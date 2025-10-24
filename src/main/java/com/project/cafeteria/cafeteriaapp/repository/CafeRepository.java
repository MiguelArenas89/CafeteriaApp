package com.project.cafeteria.cafeteriaapp.repository;

import com.project.cafeteria.cafeteriaapp.entity.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// JpaRepository nos da acceso a CRUD
public interface CafeRepository extends JpaRepository<Cafe, Long> {
}
