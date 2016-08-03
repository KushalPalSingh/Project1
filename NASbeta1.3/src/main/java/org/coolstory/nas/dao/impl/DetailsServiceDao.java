package org.coolstory.nas.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.coolstory.nas.dao.DetailsService;
import org.coolstory.nas.domain.Sport;
import org.coolstory.nas.domain.Student;
import org.coolstory.nas.domain.StudentSportMapping;
import org.coolstory.nas.dto.StudentSportsDto;
import org.coolstory.nas.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

@Component
public class DetailsServiceDao implements DetailsService
{

	@Override
	public StudentSportsDto getStudentSportsDetails(Integer studentId)
	{
		Session session = HibernateUtil.INSTANCE.getSession();
		session.beginTransaction();
		StudentSportsDto studentSportsDto = null;
		Student student = (Student) session.get(Student.class, 1);
		if (student != null)
		{

			Criteria cr = session.createCriteria(StudentSportMapping.class);
			cr.add(Restrictions.eq("student", studentId));
			@SuppressWarnings("unchecked")
			List<StudentSportMapping> studentMappings = cr.list();
			List<Sport> sports = new ArrayList<>();
			if (studentMappings != null && !studentMappings.isEmpty())
			{
				for (StudentSportMapping sportMapping : studentMappings)
				{
					Sport sport = (Sport) session.get(Sport.class, sportMapping.getSport());
					sports.add(sport);
				}
			}

			studentSportsDto = populateStuDentSportsDetails(student, sports);
		}
		session.getTransaction().commit();

		return studentSportsDto;
	}

	private static StudentSportsDto populateStuDentSportsDetails(Student student, List<Sport> sports)
	{
		StudentSportsDto studentSportsDto = null;
		if (student != null)
		{
			studentSportsDto = new StudentSportsDto();
			studentSportsDto.setStudentName(student.getName());
			studentSportsDto.setStudentId(student.getId());
			List<String> sportList = new ArrayList<>();
			for (Sport sport : sports)
			{
				sportList.add(sport.getSportName());
			}
			studentSportsDto.setSportsName(sportList);
		}
		return studentSportsDto;
	}

}
