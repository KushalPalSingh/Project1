package org.coolstory.nas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_sport_mapping")
public class StudentSportMapping
{

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "STUDENT_ID")
	private Integer student;
	
	@Column(name = "SPORT_ID")
	private Integer sport;

	
	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getStudent()
	{
		return student;
	}

	public void setStudent(Integer student)
	{
		this.student = student;
	}

	public Integer getSport()
	{
		return sport;
	}

	public void setSport(Integer sport)
	{
		this.sport = sport;
	}
	
}
