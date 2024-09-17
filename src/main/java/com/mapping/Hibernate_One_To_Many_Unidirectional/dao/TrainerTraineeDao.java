package com.mapping.Hibernate_One_To_Many_Unidirectional.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.mapping.Hibernate_One_To_Many_Unidirectional.dto.Trainee;
import com.mapping.Hibernate_One_To_Many_Unidirectional.dto.Trainer;

public class TrainerTraineeDao {

	EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	public Trainer saveTrainerTaineeDao(Trainer trainer,List<Trainee> trainees) {
		
		et.begin();
		em.persist(trainer);
//		for (Trainee trainee : trainees) {
//			em.persist(trainee);
//		}
		
		et.commit();
		return trainer;
	}
	public Trainer getTrainerById(int id) {
		return em.find(Trainer.class, id);
	}
	public Trainer associateTrianerTraineeDao(int trainerId,int traineeId) {
		Trainer t=getTrainerById(trainerId);
		if(t!=null) {
			
			String insertQuery="INSERT INTO trainer_trainee (Trainer_id, trainees_id) VALUES (?1, ?2)";
			
			Query query=em.createNativeQuery(insertQuery);
			query.setParameter(1,t.getId());
			query.setParameter(2, traineeId);
			et.begin();
			query.executeUpdate();
			et.commit();
			return t;
		}
		return null;
		
	}
//	public Trainer getTrainerAndAllTraineeByTrainerIdDao(int traineeId) {
//		
//	}


}
