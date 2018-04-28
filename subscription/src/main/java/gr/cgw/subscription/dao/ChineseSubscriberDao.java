package gr.cgw.subscription.dao;

import java.util.List;

import gr.cgw.subscription.model.ChineseSubscriber;

public interface ChineseSubscriberDao {
	public List<ChineseSubscriber> getChineseSubscribers();
	public void saveChineseSubscriber(ChineseSubscriber c);
	public ChineseSubscriber getChineseSubscriber(int id);
	public void disableChineseSubscriber(int id);

}
