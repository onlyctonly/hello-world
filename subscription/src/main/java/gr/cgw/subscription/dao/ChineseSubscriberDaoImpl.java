package gr.cgw.subscription.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.cgw.subscription.model.ChineseSubscriber;

@Repository
public class ChineseSubscriberDaoImpl implements ChineseSubscriberDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<ChineseSubscriber> getChineseSubscribers() {
		Session session= sessionFactory.getCurrentSession();
		Query<ChineseSubscriber> q= session.createQuery("from ChineseSubscriber order by id", ChineseSubscriber.class);
		List<ChineseSubscriber> ss = q.getResultList();
		return ss;
	}

	@Override
	public void saveChineseSubscriber(ChineseSubscriber c) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(c);
	}

	@Override
	public ChineseSubscriber getChineseSubscriber(int id) {
		Session session = sessionFactory.getCurrentSession();
		ChineseSubscriber c = session.get(ChineseSubscriber.class, id);
		return c;
	}

	@Override
	public void disableChineseSubscriber(int id) {
		Session s = sessionFactory.getCurrentSession();
		Query<?> q = s.createQuery("delete from ChineseSubscriber where id=:id");
		q.setParameter("id", id);
		q.executeUpdate();
	}

}
