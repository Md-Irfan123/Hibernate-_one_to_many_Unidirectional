package com.mapping.Hibernate_One_To_Many_Unidirectional.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.mapping.Hibernate_One_To_Many_Unidirectional.dao.TraineeDao;
import com.mapping.Hibernate_One_To_Many_Unidirectional.dao.TrainerTraineeDao;
import com.mapping.Hibernate_One_To_Many_Unidirectional.dto.Trainee;
import com.mapping.Hibernate_One_To_Many_Unidirectional.dto.Trainer;

public class TrainerTraineeInsertController {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		TraineeDao dao1=new TraineeDao();
		TrainerTraineeDao dao=new TrainerTraineeDao();
//		Trainee trainee1 =new Trainee(123, "Saurabh", "Noida", 4858495);
//		Trainee trainee2=new Trainee(124, "Mohan", "delhi", 85945794);
//		List<Trainee> trainees=Arrays.asList(trainee1,trainee2);
//		Trainer trainer=new Trainer(999, "Rohan", 35, "rohan@gmail.com", trainees);
//		
//		dao.saveTrainerTaineeDao(trainer, trainees);
		
		
		
		char p;
		
			do {
				System.out.println("Enter your option....");
				System.out.println("1.INSERT\n2.GetById\n3.DELETE\n4.UPDATE\n5.DISPLAY\n6.DeleteByJPQL\n7.UpdateByJPQL");
				int key=sc.nextInt();
				switch(key) {
			case 1:{
				sc.nextLine();
				System.out.println("Enter Trainee name");
				String name =sc.nextLine();
				
				System.out.println("Enter Trainee address");
				String address=sc.nextLine();
				System.out.println("Enter Trainee phone ");
				long phone =sc.nextLong();
				
				Trainee trainee1=new Trainee(name, address, phone);
				
				sc.nextLine();
				System.out.println("Enter Trainee name");
				String name1 =sc.nextLine();
				
				System.out.println("Enter Trainee address");
				String addres1=sc.nextLine();
				System.out.println("Enter Trainee phone ");
				long phone1 =sc.nextLong();
				
				Trainee trainee2=new Trainee(name1, addres1, phone1);
				
				List<Trainee> trainees=Arrays.asList(trainee1,trainee2);
				
				
				System.out.println("Enter Trainer id");
				
				int id=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Trainer name");
				String name2=sc.nextLine();
				System.out.println("Enter Trainer age");
				int age=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Trainer email");
				String email=sc.nextLine();
				Trainer trainer=new Trainer(id, name2, age, email, trainees);
				
				dao.saveTrainerTaineeDao(trainer, trainees);
				
			
			
			
			
			}
			break;
			case 2:{
				System.out.println("Enter the id to display");
				int id=sc.nextInt();
				Trainee trainee=dao1.getByIdDao(id);
				
			
																											
				if(trainee!=null) {
					System.out.println(trainee);
					
					}
				
				
			
				
			
			
		}
		break;

			case 3:{
				System.out.println("Enter Trainee id to delete");
				int id=sc.nextInt();
				Trainee trainee=dao1.deleteTraineeByIdDao(id);
				
				System.out.println(trainee);
			}
			break;
				
			
			case 4:{
				Trainer t=dao.associateTrianerTraineeDao(101, 123);
				if(t!=null) {
					System.out.println("success");
				}else {
					System.out.println("failed to update");
				}
			}break;
		}System.out.println("Press Y/y to continue");
		p=sc.next().charAt(0);
		
		}while(p=='Y'|| p== 'y');
	System.out.println("Program ends");

	}

}
