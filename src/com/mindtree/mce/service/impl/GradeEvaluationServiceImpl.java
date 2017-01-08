package com.mindtree.mce.service.impl;

import java.util.ArrayList;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mindtree.mce.dao.GradeEvaluationDao;
import com.mindtree.mce.entity.Score;
import com.mindtree.mce.entity.Student;
import com.mindtree.mce.exception.DaoException;
import com.mindtree.mce.exception.ServiceException;
import com.mindtree.mce.service.GradeCalculator;
import com.mindtree.mce.service.GradeEvaluationService;
import com.mindtree.mce.vo.ResultVo;
import com.mindtree.mce.vo.ScoreVo;
import com.mindtree.mce.vo.StudentVo;

public class GradeEvaluationServiceImpl implements GradeEvaluationService {

//	private static final Logger LOG = LoggerFactory
//			.getLogger(GradeEvaluationServiceImpl.class);

	@Autowired
	private GradeEvaluationDao dao;

	@Autowired
	private GradeCalculator calculator;

	public void setDao(GradeEvaluationDao dao) {
		this.dao = dao;
	}

	public void setCalculator(GradeCalculator calculator) {
		this.calculator = calculator;
	}

	@Override
	public boolean addScore(ScoreVo score) throws ServiceException {
		boolean status = false;
		Score scr = new Score();
		scr.setTestName(score.getTestName());
		scr.setTestScore(score.getTestScore());
		scr.setMaxScore(score.getMaxScore());
		scr.setTestDate(score.getTestDate());
		//LOG.debug("Score Entity: "+scr);
		try {
			dao.addScore(scr, score.getRegdNo());
			status=true;
		} catch (DaoException e) {
			//LOG.error("Error occured while persisting score details.", e);
			throw new ServiceException(
					"Error occured while persisting score details.", e);
		}
		return status;
	}

	@Override
	public boolean addStudent(StudentVo student) throws ServiceException {
		boolean status = false;
		Student std = new Student();
		std.setRegdNo(student.getRegdNo());
		std.setStudentName(student.getStudentName());
		std.setAddress(student.getAddress());
		std.setPhoneNo(student.getPhoneNo());
		//LOG.debug("Student Entity: "+std);
		try {
			dao.addStudent(std);
			status=true;
		} catch (DaoException e) {
			//LOG.error("Error occured while persisting student details.", e);
			throw new ServiceException(
					"Error occured while persisting student details.", e);
		}
		return status;
	}

	@Override
	public List<ResultVo> getAllGrades(int begin, int fetchSize)
			throws ServiceException {
		List<ResultVo> results = new ArrayList<ResultVo>();
		try {
			List<Student> list = dao.getAllStudents(begin, fetchSize);
			for (Student std : list) {
				ResultVo result = new ResultVo();
				result.setRegdNo(std.getRegdNo());
				result.setStudentName(std.getStudentName());
				result.setGrade(calculator.calculateGrade(std.getScores()));
				results.add(result);
			}
			//LOG.info("Grade List created from Student list.");
		} catch (DaoException e) {
			//LOG.error("Error occured while retrieving grades.", e);
			throw new ServiceException(
					"Error occured while retrieving grades.", e);
		}
		return results;
	}

	@Override
	public List<String> getRegdNos() throws ServiceException {
		List<String> regdnos = null;
		try {
			regdnos = dao.getRegdNos();
		} catch (DaoException e) {
			//LOG.error("Error occured while fetching all registration numbers.",
					//e);
			throw new ServiceException(
					"Error occured while fetching all registration numbers.", e);
		}
		//LOG.debug("Registration numbers: "+regdnos);
		return regdnos;
	}

	@Override
	public Student getStudent(String regdNo) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<ScoreVo> getAllTests(String regdno)
			throws ServiceException {
		List<ScoreVo> scores = new ArrayList<ScoreVo>();
		try {
			Collection<Score> list = dao.getAllTests(regdno);
			for (Score score : list) {
				ScoreVo vo = new ScoreVo();
				vo.setTestName(score.getTestName());
				vo.setMaxScore(score.getMaxScore());
				vo.setTestScore(score.getTestScore());
				vo.setTestDate(score.getTestDate());
				scores.add(vo);
			}
		} catch (DaoException e) {
			//LOG.error("Could not fetch score details", e);
			throw new ServiceException("Could not fetch score details", e);
		}
		//LOG.debug("Score List: "+scores);
		return scores;
	}

}
