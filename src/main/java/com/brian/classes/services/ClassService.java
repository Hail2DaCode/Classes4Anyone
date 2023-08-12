package com.brian.classes.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.brian.classes.models.Class;
import com.brian.classes.models.User;
import com.brian.classes.repositories.ClassRepository;
@Service
public class ClassService {
	private final ClassRepository classRepo;
	public ClassService(ClassRepository classRepo) {
		this.classRepo = classRepo;
	}
	public List<Class> allClasses() {
		return classRepo.findAll();
		
	}
	public List<Class> allClassesITeach(Long id) {
		return classRepo.findByTeacherId(id);
	}
	public List<Class> allClassesIStudy(Long teacherId, Long studentId) {
		return classRepo.findByTeacherIdIsNotAndStudentsIdIs(teacherId, studentId);
	}
	public List<Class> availableClasses(Long teacherId, Long studentId) {
		List<Class> classes = classRepo.availableClasses(teacherId, studentId);
		ArrayList<Class> classes2 = new ArrayList<Class>();
		//System.out.println(studentId);
		//System.out.println(classes);
		for(Class klass : classes) {
			for(User student : klass.getStudents()) {
				//System.out.println(student.getUserName());
				//System.out.println(student.getId());
				if(student.getId() == studentId) {
					//System.out.println("Inside if");
					classes2.add(klass);
				}
			}
		}
		classes.removeAll(classes2);
		//System.out.println(classes);
		return classes;
	}
//	public List<Class> allClassesIStudy2(Long id) {
//		List<Class> allClassesWithStudents = classRepo.findAllClassesWithStudents();
//		for(Class klass : allClassesWithStudents) {
//			if(klass.getTeacher().getId() == id || klass.) {
//				
//			}
//		}
//	}
	public Class createClass(Class c) {
		return classRepo.save(c);
	}
	public void addStudent (Class klass, User student) {
		List<User> students = klass.getStudents();
		students.add(student);
		klass.setStudents(students);
		classRepo.save(klass);
	}
	public void removeStudent(Class klass, User student) {
		List<User> students = klass.getStudents();
		students.remove(student);
		klass.setStudents(students);
		classRepo.save(klass);
	}
	public Class findClass(Long id) {
		Optional<Class> optionalClass = classRepo.findById(id);
		if(optionalClass.isPresent()) {
			return optionalClass.get();
		}
		else {
			return null;
		}
	}
	public boolean isTitle(Class c) {
		Optional<Class> potentialClass = classRepo.findByTitle(c.getTitle());
		if (potentialClass.isPresent()) {
			return true;
		}
		else { 
			return false;
		}
	}
	public void deleteClass(Long id) {
		classRepo.deleteById(id);
	}
}
