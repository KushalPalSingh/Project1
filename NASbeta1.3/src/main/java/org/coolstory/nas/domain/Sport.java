package org.coolstory.nas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sports")
public class Sport
{

	@Id
	@GeneratedValue
	@Column(name = "SPORT_ID")
	private Integer	sportId;
	
	@Column(name = "SPORT_NAME")
	private String	sportName;

	public Integer getSportId()
	{
		return sportId;
	}

	public void setSportId(Integer sportId)
	{
		this.sportId = sportId;
	}

	public String getSportName()
	{
		return sportName;
	}

	public void setSportName(String sportName)
	{
		this.sportName = sportName;
	}

}
