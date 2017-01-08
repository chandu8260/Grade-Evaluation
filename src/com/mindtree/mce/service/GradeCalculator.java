package com.mindtree.mce.service;

import java.util.Collection;

import com.mindtree.mce.entity.Score;
import com.mindtree.mce.exception.ServiceException;

public interface GradeCalculator {

	public char calculateGrade(Collection<Score> scores) throws ServiceException;
}
