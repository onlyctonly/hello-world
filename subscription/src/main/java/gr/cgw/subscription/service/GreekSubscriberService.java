package gr.cgw.subscription.service;

import java.util.List;

import gr.cgw.subscription.model.GreekSubscriber;

public interface GreekSubscriberService {
	public List<GreekSubscriber> getGreekSubscribers();
	
	public void saveGreekSubscriber(GreekSubscriber g);
	
	public GreekSubscriber getGreekSubscriber(int id);
	
	public void disableGreekSubscriber(int id);

}
