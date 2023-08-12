package com.brian.classes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.brian.classes.models.Class;

public interface ClassRepository2 extends JpaRepository<Class, Long> {
	@Query(value = "SELECT * FROM classes LEFT JOIN classes_students ON classes.id = classes_students.class_id",
				 nativeQuery = true)
		List<Class> findAllClassesWithStudents();

}
