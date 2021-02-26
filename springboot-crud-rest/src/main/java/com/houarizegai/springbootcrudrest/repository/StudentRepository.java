package com.houarizegai.springbootcrudrest.repository;

import com.houarizegai.springbootcrudrest.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
