package org.coolstory.nas.dto;

import java.util.List;

public class StudentSportsDto
{

	private String			studentName;
	private Integer			studentId;
	private List<String>	sportsName;

	public String getStudentName()
	{
		return studentName;
	}

	public void setStudentName(String studentName)
	{
		this.studentName = studentName;
	}

	public Integer getStudentId()
	{
		return studentId;
	}

	public void setStudentId(Integer studentId)
	{
		this.studentId = studentId;
	}

	public List<String> getSportsName()
	{
		return sportsName;
	}

	public void setSportsName(List<String> sportsName)
	{
		this.sportsName = sportsName;
	}
}
