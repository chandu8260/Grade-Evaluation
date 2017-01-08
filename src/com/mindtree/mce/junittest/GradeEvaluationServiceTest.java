package com.mindtree.mce.junittest;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.mindtree.mce.exception.ServiceException;
import com.mindtree.mce.service.GradeEvaluationService;
import com.mindtree.mce.vo.StudentVo;

/**
 * @author CHANDU
 *
 */
@ContextConfiguration("classpath:/gradeEvaluation-junit.xml")
public class GradeEvaluationServiceTest extends AbstractTransactionalJUnit4SpringContextTests{
	
	@Autowired
	GradeEvaluationService service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testAddScore() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddStudent() {
		StudentVo student = new StudentVo();
		student.setRegdNo("M1018201");
		student.setStudentName("Sanit Kumar Swain");
		student.setAddress("MTC-10F-447");
		student.setPhoneNo(9566031346L);
		try {
//			System.out.println(service.addStudent(student));
			Assert.assertTrue("Student added.",service.addStudent(student));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Ignore
	@Test
	public void testGetAllGrades() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRegdNos() {
		List<String> expected = Arrays.asList(new String[] { "M1018211",
				"M1018150", "M1018XXX" });
		Collections.sort(expected);
		try {
			List<String> actual = service.getRegdNos();
			if (actual != null) {
				Collections.sort(actual);
			}
			Assert.assertEquals("Junit Run: ", expected, actual);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAllTests() {
		fail("Not yet implemented");
	}

}
