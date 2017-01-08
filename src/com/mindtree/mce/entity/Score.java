/**
 * 
 */
package com.mindtree.mce.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author m1018211
 * 
 */
public class Score implements Comparable<Score> {
	private int testId;
	private String testName;
	private BigDecimal maxScore;
	private BigDecimal testScore;
	private Date testDate;
	private Student student;

	/**
	 * Default Constructor
	 */
	public Score() {
		super();
	}

	/**
	 * @return the testId
	 */
	public int getTestId() {
		return testId;
	}

	/**
	 * @param testId
	 *            the testId to set
	 */
	public void setTestId(int testId) {
		this.testId = testId;
	}

	/**
	 * @return the testName
	 */
	public String getTestName() {
		return testName;
	}

	/**
	 * @param testName
	 *            the testName to set
	 */
	public void setTestName(String testName) {
		this.testName = testName;
	}

	/**
	 * @return the maxScore
	 */
	public BigDecimal getMaxScore() {
		return maxScore;
	}

	/**
	 * @param maxScore
	 *            the maxScore to set
	 */
	public void setMaxScore(BigDecimal maxScore) {
		this.maxScore = maxScore;
	}

	/**
	 * @return the testScore
	 */
	public BigDecimal getTestScore() {
		return testScore;
	}

	/**
	 * @param testScore
	 *            the testScore to set
	 */
	public void setTestScore(BigDecimal testScore) {
		this.testScore = testScore;
	}

	/**
	 * @return the testDate
	 */
	public Date getTestDate() {
		return testDate;
	}

	/**
	 * @param testDate
	 *            the testDate to set
	 */
	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	/**
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * @param student
	 *            the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + testId;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		if (testId != other.testId)
			return false;
		return true;
	}

	@Override
	public int compareTo(Score test) {
		return this.getTestDate().compareTo(test.getTestDate());
	}

}
