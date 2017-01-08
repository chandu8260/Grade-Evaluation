/**
 * 
 */
package com.mindtree.mce.dao.impl;

import java.util.Collection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.mindtree.mce.dao.GradeEvaluationDao;
import com.mindtree.mce.entity.Score;
import com.mindtree.mce.entity.Student;
import com.mindtree.mce.exception.DaoException;

/**
 * @author M1018211
 * 
 */
public class GradeEvaluationDaoImpl implements GradeEvaluationDao {

//	private static final org.apache.log4j.Logger LOG = org.apache.log4j.spi.LoggerFactory
//			.getLogger(GradeEvaluationDaoImpl.class);

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	@Autowired
	private HibernateTemplate ht;

	@Override
	public void addScore(Score score, String regdNo) throws DaoException {
		Student std = ht.get(Student.class, regdNo);
		if (std != null) {
			score.setStudent(std);
			ht.save(score);
		} else {
			throw new DaoException("Record for Student with regd-no: " + regdNo
					+ " is not available in table.");
		}
	}

	@Override
	public void addStudent(Student student) throws DaoException {
		try {
			ht.save(student);
		} catch (Exception e) {
			throw new DaoException("Unable to persist student details.",e);
		}
	}

	@Override
	public List<Student> getAllStudents(int begin, int length)
			throws DaoException {
		return ht.loadAll(Student.class);
	}

	@Override
	public Collection<Score> getAllTests(String regdNo) throws DaoException {
		Student std = ht.get(Student.class, regdNo);
		if (std != null) {
			//LOG.debug("Student: " + std);
			return std.getScores();
		} else {
			throw new DaoException("Student entry with regd no: " + regdNo
					+ " is not available in DB");
		}
	}

	@Override
	public List<String> getRegdNos() throws DaoException {
		String hql = "select regdNo from com.mindtree.mce.entity.Student";
		//LOG.debug("HQL Query: " + hql);
		List<String> regdnos = (List<String>) ht.find(hql);
		//LOG.debug("Regd no list: " + regdnos);
		return regdnos;
	}

	@Override
	public Student getStudent(String regdNo) throws DaoException {
		return ht.get(Student.class, regdNo);
	}

}
