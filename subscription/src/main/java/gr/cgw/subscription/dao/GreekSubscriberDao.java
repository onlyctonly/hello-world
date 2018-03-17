package gr.cgw.subscription.dao;

import java.util.List;

import gr.cgw.subscription.model.GreekSubscriber;

public interface GreekSubscriberDao {
	public List<GreekSubscriber> getGreekSubscribers();
	
	public void saveGreekSubscriber(GreekSubscriber g);
	
	public GreekSubscriber getGreekSubscriber(int id);
	
	public void disableGreekSubscriber(int id);
}
