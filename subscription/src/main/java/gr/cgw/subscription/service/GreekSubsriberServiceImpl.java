package gr.cgw.subscription.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gr.cgw.subscription.dao.GreekSubscriberDao;
import gr.cgw.subscription.model.GreekSubscriber;

@Service
public class GreekSubsriberServiceImpl implements GreekSubscriberService {

	@Autowired
	private GreekSubscriberDao greekSubscriberDao;
	
	@Override
	@Transactional
	public List<GreekSubscriber> getGreekSubscribers() {
		
		return greekSubscriberDao.getGreekSubscribers();
	}

	@Override
	@Transactional
	public void saveGreekSubscriber(GreekSubscriber g) {
		greekSubscriberDao.saveGreekSubscriber(g);
	}

	@Override
	@Transactional
	public GreekSubscriber getGreekSubscriber(int id) {
		return greekSubscriberDao.getGreekSubscriber(id);
	}

	@Override
	@Transactional
	public void disableGreekSubscriber(int id) {
		greekSubscriberDao.disableGreekSubscriber(id);
	}

}
