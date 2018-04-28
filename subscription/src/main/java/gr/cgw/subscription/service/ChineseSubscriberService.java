package gr.cgw.subscription.service;

import java.util.List;

import gr.cgw.subscription.model.ChineseSubscriber;

public interface ChineseSubscriberService {
	public List<ChineseSubscriber> getChineseSubscribers();
	public void saveChineseSubscriber(ChineseSubscriber c);
	public ChineseSubscriber getChineseSubscriber(int id);
	public void disableChineseSubscriber(int id);
}
