package gr.cgw.subscription.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gr.cgw.subscription.dao.ChineseSubscriberDao;
import gr.cgw.subscription.model.ChineseSubscriber;

@Service
public class ChineseSubscriberServiceImpl implements ChineseSubscriberService {
	
	@Autowired
	private ChineseSubscriberDao chineseSubscriberDao;

	@Override
	@Transactional
	public List<ChineseSubscriber> getChineseSubscribers() {
		return chineseSubscriberDao.getChineseSubscribers();
	}

	@Override
	@Transactional
	public void saveChineseSubscriber(ChineseSubscriber c) {
		chineseSubscriberDao.saveChineseSubscriber(c);

	}

	@Override
	@Transactional
	public ChineseSubscriber getChineseSubscriber(int id) {
		
		return chineseSubscriberDao.getChineseSubscriber(id);
	}

	@Override
	@Transactional
	public void disableChineseSubscriber(int id) {
		chineseSubscriberDao.disableChineseSubscriber(id);
	}

}
