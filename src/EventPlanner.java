import java.util.ArrayList;
import java.util.Date;

public class EventPlanner 
{
	private ArrayList<Event> calendar = new ArrayList<Event>();
	
	/**
	 * 
	 * @param eventName - Name of the event
	 * @param contactName - Name of the contact for the event
	 * @param phoneNum - Phone number for the contact of the event
	 * @param email - Email for the contact of the event
	 * @param eventType - Type of event (Conference, Meeting, 
	 * 					  Musical, Family, Other)
	 * @param city - City where the event will take place
	 * @param date - Date the event will take place
	 * @param attendance - Planned attendance for the event
	 */
	public void createEvent(String eventName, String contactName, String phoneNum, String email, String eventType
			, String city, Date date, int attendance)
	{
		Event event = new Event(eventName, contactName, phoneNum, 
				email, eventType, city, date, attendance);
		addEventToCalendar(event);
	}
	
	/**
	 * This method will add an event to the calendar, calls checkEventClash
	 * to verify that two events are not held on the same date and location.
	 * @param event - Event that will be added to the calendar.
	 */
	private void addEventToCalendar(Event event)
	{
		if(checkEventClash(event) == true)
		{
			System.out.println("Unable to add event due to date"
					+ " and location clash");
		}
		else
		{
			calendar.add(event);
			System.out.println("Event " + event.getEventName() 
			+ " has been added to calendar.");
		}

	}
	
	/**
	 * Method to check whether two events are planned on the same date and city.
	 * @return - Returns true if there are two events that are planned for the
	 * 			 same date and city.
	 */
	private boolean checkEventClash(Event event)
	{
		boolean sameDateLoc = false;
		
		//Go through events and see if they have the same date and location
		for(int i = 0; i < calendar.size(); i++)
		{
			if(event.getCity().equals(calendar.get(i).getCity()) 
					|| event.getDate().equals(calendar.get(i).getDate()))
			{
				sameDateLoc = true;
				System.out.println("Event " + calendar.get(i).getContactName()
						+ " has same date and location.");
			}
		}
		
		return sameDateLoc;
	}

}
