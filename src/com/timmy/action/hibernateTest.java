package com.timmy.action;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.timmy.advanced.Employee;
import com.timmy.advanced.User;
import com.timmy.utils.Utils;

public class hibernateTest {
	private Session session=null;
	private Transaction tx=null;
   
	 @Test
	   public void updateRelation()
	   {
		   try {
			   //直接放入，会自动移动
				 session=Utils.getSessionFactory().openSession();
				 tx=session.beginTransaction();
				User user=(User) session.get(User.class, 13);
				Employee role=(Employee) session.get(Employee.class, 1);
				
				user.getRoles().add(role);
			//	session.delete(user);//持久层数据自动更新
				role.setUser(user);
				tx.commit();

		} catch (Exception e) {
			tx.rollback();
		}finally{
			session.close();
		}
			
	   
	   
	   
	   
	   
 }
	   
	   @Test
	   public void delete()
	   {
		   try {
			   //一个用户被删除，他的所有的员工也将会被删除。
				 session=Utils.getSessionFactory().openSession();
				 tx=session.beginTransaction();
				User user=(User) session.get(User.class, 11);
				session.delete(user);
				tx.commit();

		} catch (Exception e) {
			tx.rollback();
		}finally{
			session.close();
		}
			
	   
	   
	   
	   
	   
   }
	   
	   @Test
	   public void add()
	   {
		   try {
				 session=Utils.getSessionFactory().openSession();
				 tx=session.beginTransaction();
				  User user=new User();
				  user.setUsername("百度");
				  user.setPassword("123456");
				  
				  
				  User user1=new User();
				  user1.setUsername("alibaba");
				  user1.setPassword("123456");
				  
				  User user2=new User();
				  user2.setUsername("腾讯");
				  user2.setPassword("123456");
				  
				  Employee employee=new Employee();
				  employee.setEmname("小芳");
				  
				  Employee employee1=new Employee();
				  employee1.setEmname("小明");
				  
				  
				  Employee employee2=new Employee();
				  employee2.setEmname("小李");
				  
				  user1.getRoles().add(employee1);
				  user1.getRoles().add(employee2);
				  user1.getRoles().add(employee);
				  
				  session.save(user);
				  session.save(user1);
				  session.save(user2);



				tx.commit();

		} catch (Exception e) {
			tx.rollback();
		}finally{
			//session.close();
		}
	   }
	
	   
	
	
}
