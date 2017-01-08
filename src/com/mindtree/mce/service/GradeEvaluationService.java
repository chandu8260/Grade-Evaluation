package com.mindtree.mce.service;

import java.util.Collection;
import java.util.List;

import com.mindtree.mce.entity.Student;
import com.mindtree.mce.exception.ServiceException;
import com.mindtree.mce.vo.ResultVo;
import com.mindtree.mce.vo.ScoreVo;
import com.mindtree.mce.vo.StudentVo;

public interface GradeEvaluationService {

	/**
	 * Method to add the Student details to DB
	 * 
	 * @param student
	 * @throws ServiceException
	 */
	public boolean addStudent(StudentVo student) throws ServiceException;

	/**
	 * Method to get all the students
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public List<ResultVo> getAllGrades(int begin, int fetchSize)
			throws ServiceException;

	/**
	 * Method to add the test details to DB
	 * 
	 * @param test
	 * @param regdNo
	 * @throws ServiceException
	 */
	public boolean addScore(ScoreVo score) throws ServiceException;

	/**
	 * Method to fetch the student details based on Registration Number
	 * 
	 * @param stdRegNo
	 * @return
	 * @throws ServiceException
	 */
	public Student getStudent(String regdNo) throws ServiceException;

	/**
	 * Method to get all registration numbers of students
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public List<String> getRegdNos() throws ServiceException;
	
	/**
	 * Method to get all test details
	 * 
	 * @param regdno
	 * @return
	 * @throws ServiceException
	 */
	public Collection<ScoreVo> getAllTests(String regdno) throws ServiceException;
}
