package gr.cgw.subscription.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.cgw.subscription.model.GreekSubscriber;

@Repository
public class GreekSubscriberDaoImpl implements GreekSubscriberDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<GreekSubscriber> getGreekSubscribers() {
		Session session = sessionFactory.getCurrentSession();
		Query<GreekSubscriber> q = session.createQuery("from GreekSubscriber order by id", GreekSubscriber.class);
		List<GreekSubscriber> greekSubscribers = q.getResultList();
		return greekSubscribers;
	}

	@Override
	public void saveGreekSubscriber(GreekSubscriber g) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(g);
	}

	@Override
	public GreekSubscriber getGreekSubscriber(int id) {
		Session session = sessionFactory.getCurrentSession();
		GreekSubscriber greekSubscriber = session.get(GreekSubscriber.class,id);
		return greekSubscriber;
	}

	@Override
	public void disableGreekSubscriber(int id) {
		Session s = sessionFactory.getCurrentSession();
		Query<?> q = s.createQuery("delete from GreekSubscriber where id=:id");
		// TODO create stored procedure to transfer deleted entries to new table GreekSubscriber_deleted
		q.setParameter("id", id);
		q.executeUpdate();
	}


}
