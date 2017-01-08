/**
 * 
 */
package com.mindtree.mce.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author m1018211
 * 
 */
public class ScoreVo implements Comparable<ScoreVo> {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((maxScore == null) ? 0 : maxScore.hashCode());
		result = prime * result + ((regdNo == null) ? 0 : regdNo.hashCode());
		result = prime * result
				+ ((testDate == null) ? 0 : testDate.hashCode());
		result = prime * result
				+ ((testName == null) ? 0 : testName.hashCode());
		result = prime * result
				+ ((testScore == null) ? 0 : testScore.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScoreVo other = (ScoreVo) obj;
		if (maxScore == null) {
			if (other.maxScore != null)
				return false;
		} else if (!maxScore.equals(other.maxScore))
			return false;
		if (regdNo == null) {
			if (other.regdNo != null)
				return false;
		} else if (!regdNo.equals(other.regdNo))
			return false;
		if (testDate == null) {
			if (other.testDate != null)
				return false;
		} else if (!testDate.equals(other.testDate))
			return false;
		if (testName == null) {
			if (other.testName != null)
				return false;
		} else if (!testName.equals(other.testName))
			return false;
		if (testScore == null) {
			if (other.testScore != null)
				return false;
		} else if (!testScore.equals(other.testScore))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ScoreVo [maxScore=" + maxScore + ", regdNo=" + regdNo
				+ ", testDate=" + testDate + ", testName=" + testName
				+ ", testScore=" + testScore + "]";
	}

	private String regdNo;
	private String testName;
	private BigDecimal maxScore;
	private BigDecimal testScore;
	private Date testDate;

	public String getRegdNo() {
		return regdNo;
	}

	public void setRegdNo(String regdNo) {
		this.regdNo = regdNo;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public BigDecimal getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(BigDecimal maxScore) {
		this.maxScore = maxScore;
	}

	public BigDecimal getTestScore() {
		return testScore;
	}

	public void setTestScore(BigDecimal testScore) {
		this.testScore = testScore;
	}

	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	@Override
	public int compareTo(ScoreVo o) {
		return this.getTestDate().compareTo(o.getTestDate());
	}

}
