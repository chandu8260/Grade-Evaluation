/**
 * 
 */
package com.mindtree.mce.entity;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author m1018211
 * 
 */
public class Student implements Comparable<Student> {
	private String regdNo;
	private String studentName;
	private String address;
	private long phoneNo;
	private Set<Score> scores = new TreeSet<Score>();

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Set<Score> getScores() {
		return scores;
	}

	public void setScores(Set<Score> scores) {
		this.scores = scores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + (int) (phoneNo ^ (phoneNo >>> 32));
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
		Student other = (Student) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (phoneNo != other.phoneNo)
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
	public int compareTo(Student o) {
		return this.getRegdNo().compareTo(o.getRegdNo());
	}

}
