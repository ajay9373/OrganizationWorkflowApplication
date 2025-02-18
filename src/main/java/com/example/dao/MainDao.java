package com.example.dao;

import java.util.List;

import org.aspectj.weaver.ast.Literal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.entity.Country;
import com.example.entity.Employee;

@Repository
public class MainDao {

	@Autowired
	SessionFactory factory;

	public String addCountry(Country c) {

		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.persist(c);
			tx.commit();
			msg = "Country Added Successfully.....";
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;
		// TODO Auto-generated method stub

	}

	public String updateCountry(Country c, int id) {

		Session session = null;
		Transaction tx = null;
		String msg = null;
		Country country = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			country = session.get(Country.class, id);
			country.setCname(c.getCname());
			session.merge(country);
			tx.commit();
			msg = "Country Update Successfully.....";
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	public String delateCountry(int id) {
		// TODO Auto-generated method stub

		Session session = null;
		Transaction tx = null;
		String msg = null;
		Country country = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			country = session.get(Country.class, id);

			session.remove(country);

			tx.commit();
			msg = "Country Delated Successfully.....";
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	public List<Country> getAllCountry() {
		Session session = null;
		Transaction tx = null;
		List<Country> list = null;
		String hqlQuery = "from Country";

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Query<Country> query = session.createQuery(hqlQuery, Country.class);
			list = query.list();
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	public Country getParticulerCountryById(int id) {

		Session session = null;
		Transaction tx = null;
		Country country = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			country = session.get(Country.class, id);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return country;

	}

	public String addEmployee(Employee emp) {
		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.persist(emp);
			tx.commit();
			msg = "Employee Added Successfully.....";
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	public String updatedEmployee(Employee emp, int id) {
	    Session session = null;
	    Transaction tx = null;
	    String msg = null;
	    Employee emp1 = null;

	    try {
	        session = factory.openSession();
	        tx = session.beginTransaction();
	        
	        emp1 = session.get(Employee.class, id);
	        if (emp1 != null) {
	            emp1.setName(emp.getName());
	            emp1.setStatus(emp.getStatus());
	            emp1.setDeparment(emp.getDeparment());
	            emp1.setMobileno(emp.getMobileno());
	            emp1.setEmailid(emp.getEmailid());
	            emp1.setUpdatedBy(emp.getUpdatedBy());
	            emp1.setUpdatedDate(emp.getUpdatedDate());
	            emp1.setSalary(emp.getSalary());
	            emp1.setCountry(emp.getCountry());

	            session.merge(emp1);  // Use merge to update
	            session.flush();  // Force Hibernate to push changes
	            session.clear();  // Clear cache to avoid stale data

	            tx.commit();
	            msg = "Employee Updated Successfully!";
	        } else {
	            msg = "Employee Not Found!";
	        }
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	    return msg;
	}


	public String delateEmployee(int id) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		Employee emp = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			emp = session.get(Employee.class, id);

			session.remove(emp);

			tx.commit();
			msg = "Employee Delated Successfully.....";
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;	
	}

	
}
