package com.mindtree.mce.dao;

import java.util.Collection;
import java.util.List;

import com.mindtree.mce.entity.Score;
import com.mindtree.mce.entity.Student;
import com.mindtree.mce.exception.DaoException;

public interface GradeEvaluationDao {

	/**
	 * Method to add the Student details to DB
	 * 
	 * @param student
	 * @throws DaoException
	 */
	public void addStudent(Student student) throws DaoException;

	/**
	 * Method to get all the students
	 * 
	 * @param begin
	 * @param length
	 * @return 
	 * @throws DaoException
	 */
	public List<Student> getAllStudents(int begin,int length) throws DaoException;

	/**
	 * Method to add the test details to DB
	 * 
	 * @param test
	 * @param regdNo
	 * @throws DaoException
	 */
	public void addScore(Score score, String regdNo) throws DaoException;

	/**
	 * Method to fetch the student details based on Registration Number
	 * 
	 * @param stdRegNo
	 * @return
	 * @throws DaoException
	 */
	public Student getStudent(String regdNo) throws DaoException;

	/**
	 * Method to get all test details
	 * 
	 * @param studentId
	 * @return
	 * @throws DaoException
	 */
	public Collection<Score> getAllTests(String regdNo) throws DaoException;
	
	/**
	 * Method to get all registration numbers of students
	 * 
	 * @return
	 * @throws DaoException
	 */
	public List<String> getRegdNos() throws DaoException;

}
