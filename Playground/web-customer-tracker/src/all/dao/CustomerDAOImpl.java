package all.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import all.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> theQuery =  session.createQuery("from Customer order by lastName", Customer.class);
		
		List<Customer> customers = theQuery.getResultList();
		return customers;
	}

	@Override
	public void saveCustomer(Customer c) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(c);
	}

	@Override
	public Customer getCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Customer c = session.get(Customer.class, id);
		return c;
	}

	@Override
	public void deleteCustomer(int id) {
		Session s = sessionFactory.getCurrentSession();
//		Customer c = s.get(Customer.class, id);
//		s.delete(c);
//		TODO:make above work
		Query q = s.createQuery("delete from Customer where id=:customerId");
		q.setParameter("customerId", id);
		q.executeUpdate();
	}

}
