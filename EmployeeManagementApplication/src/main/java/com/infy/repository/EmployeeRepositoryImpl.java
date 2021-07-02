package com.infy.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

import com.infy.domain.Employee;

public class EmployeeRepositoryImpl implements IEmployeeRepository {

	private EntityManagerFactory emf;
	
	@Autowired
	public void setEntityManagerFactory(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@Override
	public List<Employee> searchEmployee(String eName, String eDept, String eBaseLocation, String eContactNumber) {
		EntityManager em = emf.createEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		
		CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
		Root<Employee> root = query.from(Employee.class);
		
		Predicate empName = builder.equal(root.get("empName"), eName);
		Predicate empDept = builder.equal(root.get("department"), eDept);
		
		Predicate exp1= builder.and(empName,empDept);
		
		Predicate empBaseLocation = builder.equal(root.get("baseLocation"), eBaseLocation);
		Predicate empContactNumber = builder.equal(root.get("empContactNumber"), eContactNumber);
		
		Predicate exp2 = builder.or(empBaseLocation,empContactNumber);
		
		query.where(builder.or(exp1,exp2));
		
		return em.createQuery(query.select(root)).getResultList();
	}

}
