/**
 * 
 */
package com.mindtree.mce.vo;

/**
 * @author m1018211
 * 
 */
public class ResultVo {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + grade;
		result = prime * result + ((regdNo == null) ? 0 : regdNo.hashCode());
		result = prime * result
				+ ((studentName == null) ? 0 : studentName.hashCode());
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
		ResultVo other = (ResultVo) obj;
		if (grade != other.grade)
			return false;
		if (regdNo == null) {
			if (other.regdNo != null)
				return false;
		} else if (!regdNo.equals(other.regdNo))
			return false;
		if (studentName == null) {
			if (other.studentName != null)
				return false;
		} else if (!studentName.equals(other.studentName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ResultVo [grade=" + grade + ", regdNo=" + regdNo
				+ ", studentName=" + studentName + "]";
	}

	private String regdNo;
	private String studentName;
	private char grade;

	public String getRegdNo() {
		return regdNo;
	}

	public void setRegdNo(String regdNo) {
		this.regdNo = regdNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

}
