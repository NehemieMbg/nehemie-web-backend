package com.nehemie.walkaround.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {
    private StudentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new StudentMapper();
    }

    @Test
    public void shouldMapStudentDtoToStudent() {
        StudentDto dto = new StudentDto(
                "John", 
                "Doe", 
                "john@mail.com", 
                1
        );
        
        Student student = mapper.toStudent(dto);
        assertEquals(dto.firstname(), student.getFirstname());
        assertEquals(dto.lastname(), student.getLastname());
        assertEquals(dto.email(), student.getEmail());
        assertNotNull(student.getSchool());
        assertEquals(dto.schoolId(), student.getSchool().getId());
    }
    
    @Test
    public void should_throw_null_pointer_exception_when_studentDto_is_null() {
        var exception = assertThrows(NullPointerException.class, () -> mapper.toStudent(null));
        assertEquals("The student Dto should not be null", exception.getMessage());
    }
    
    @Test
    public void shouldMapStudentToStudentResponseDto() {
        // Given
        Student student = new Student(
                "Nikola",
                "Tesla",
                "test@gmail.com",
                18
        );
        
        // When
        StudentResponseDto dto = mapper.toStudentResponseDto(student);
        
        // Then (Expect)
        assertEquals(dto.firstname(), student.getFirstname());
        assertEquals(dto.lastname(), student.getLastname());
        assertEquals(dto.email(), student.getEmail());
        assertEquals(student.getAge(), 18);
        
    }
}