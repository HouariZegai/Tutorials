package com.houarizegai.springbootcrudrest.service;

import com.houarizegai.springbootcrudrest.model.Student;
import com.houarizegai.springbootcrudrest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author HouariZegai, created on 26/02/2021
 */
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(long idStudent) {
        return studentRepository.findById(idStudent);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteById(long idStudent) {
        studentRepository.deleteById(idStudent);
    }
}
