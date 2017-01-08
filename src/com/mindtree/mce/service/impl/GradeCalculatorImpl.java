package com.mindtree.mce.service.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.mindtree.mce.entity.Score;
import com.mindtree.mce.exception.ServiceException;
import com.mindtree.mce.service.GradeCalculator;

public class GradeCalculatorImpl implements GradeCalculator {

	@Override
	public char calculateGrade(Collection<Score> scores) throws ServiceException {
		BigDecimal firstTestScore = new BigDecimal(0);
		BigDecimal count1 = new BigDecimal(1);
		BigDecimal secondTestScore = new BigDecimal(0);
		BigDecimal count2 = new BigDecimal(1);
		BigDecimal thirdTestScore = new BigDecimal(0);
		BigDecimal count3 = new BigDecimal(1);
		Calendar calDate = Calendar.getInstance();
		Date date = new Date();
		char grade='F';
		double sum=0.0;
		/*for (Score score : scores) {

			if (score.getTestDate().getMonth() - date.getMonth() <= 6) {
				firstTestScore = firstTestScore.add(score.getTestScore());
				count1.add(new BigDecimal(1));
			} else if (score.getTestDate().getMonth() - date.getMonth() <= 12
					&& score.getTestDate().getMonth() - date.getMonth() > 6) {
				secondTestScore = secondTestScore.add(score
						.getTestScore());
				count2.add(new BigDecimal(1));
			} else if (score.getTestDate().getMonth() - date.getMonth() <= 18
					&& score.getTestDate().getMonth() - date.getMonth() > 12) {
				thirdTestScore = thirdTestScore.add(score.getTestScore());
				count3.add(new BigDecimal(1));
			}
			BigDecimal gradePercent1 = firstTestScore.divide(count1).divide(
					new BigDecimal(2));
			BigDecimal gradePercent2 = secondTestScore.divide(count2).divide(
					new BigDecimal(4));
			BigDecimal gradePercent3 = thirdTestScore.divide(count3).divide(
					new BigDecimal(4));
			BigDecimal finalGradePercent = gradePercent1.add(gradePercent2)
					.add(gradePercent3);
			if (finalGradePercent.floatValue() >= 90
					&& finalGradePercent.floatValue() <= 100) {
				grade= 'O';
			} else if (finalGradePercent.floatValue() >= 80
					&& finalGradePercent.floatValue() < 90) {
				grade='E';
			} else if (finalGradePercent.floatValue() >= 70
					&& finalGradePercent.floatValue() < 80) {
				grade= 'A';
			} else if (finalGradePercent.floatValue() >= 60
					&& finalGradePercent.floatValue() < 70) {
				grade= 'B';
			} else if (finalGradePercent.floatValue() >= 50
					&& finalGradePercent.floatValue() < 60) {
				grade= 'C';
			} 
		}*/
		for (Score score : scores) {
			sum += score.getTestScore().floatValue();
		}
		if(sum > 0){
			sum=sum/scores.size();
		}
		if (sum >= 90 && sum <= 100) {
			grade = 'O';
		} else if (sum >= 80 && sum < 90) {
			grade = 'E';
		} else if (sum >= 70 && sum < 80) {
			grade = 'A';
		} else if (sum >= 60 && sum < 70) {
			grade = 'B';
		} else if (sum >= 50 && sum < 60) {
			grade = 'C';
		}
		return grade;
	}


}
