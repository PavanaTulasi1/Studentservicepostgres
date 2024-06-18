package com.pavana.student.service;

import com.pavana.student.entity.Student;

import com.pavana.student.repo.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);


    @Autowired
    private  StudentRepository studentRepository;


    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Integer id) {
        return studentRepository.findById(id);
    }

    public Student saveStudent(Student student) {
        logger.info("saveStudent(-) Started");
        return studentRepository.save(student);
    }

    public Student updateStudent(Integer id, Student studentDetails) {
        logger.info("updateStudent(-) Started");
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        student.setFirst_name(studentDetails.getFirst_name());
        student.setLast_name(studentDetails.getLast_name());
        student.setAge(studentDetails.getAge());
        return studentRepository.save(student);
    }

    public void deleteStudent(Integer id) {
        logger.info("deleteStudent(-) Started");
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        studentRepository.delete(student);
    }
    public void deleteAllStudent() {
        logger.info("deleteStudent(-) Started");
        studentRepository.deleteAll();
    }
}