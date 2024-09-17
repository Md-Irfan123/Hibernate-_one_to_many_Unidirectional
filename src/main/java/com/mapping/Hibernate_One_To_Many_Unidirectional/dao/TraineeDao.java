package com.mapping.Hibernate_One_To_Many_Unidirectional.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.mapping.Hibernate_One_To_Many_Unidirectional.dto.Trainee;

public class TraineeDao {
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	public Trainee saveTraineeDao(Trainee trainees) {
		et.begin();
		em.persist(trainees);
		et.commit();
		return trainees;
		
		
	}
	public Trainee getByIdDao(int traineeId) {
		return	em.find(Trainee.class, traineeId);
	}
	
	public Trainee deleteTraineeByIdDao(int traineeId ) {
//		Trainee trainee=em.find(Trainee.class, traineeId);
		Trainee trainee=getByIdDao( traineeId);
		
		
		if(trainee!=null) {

			String deleteQuery="delete from  trainer_trainee  where trainees_id=?1";
			Query query=em.createNativeQuery(deleteQuery);
			query.setParameter(1, traineeId);
			
			et.begin();
			query.executeUpdate();
			
			et.commit();
			return trainee;
		}else {
			return null;
		}
		
	}

}
