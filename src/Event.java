import java.text.SimpleDateFormat;
import java.util.Date;

public class Event 
{
	//Event class attributes
	private String contactName;
	private String phoneNum;
	private String email;
	private String eventName;
	private String eventType;
	private String city;
	private Date date;
	private int attendance;
	
	//Empty Constructor, dont want this to be used so make it private
	private Event() {}
	
	//Main Constructor
	public Event(String eventName, String contactName, String phoneNum, String email, String eventType
			, String city, Date date, int attendance)
	{
		this.eventName = eventName;
		this.contactName = contactName;
		this.phoneNum = phoneNum;
		this.email = email;
		this.eventType = eventType;
		this.city = city;
		this.date = date;
		this.attendance = attendance;
	}
	
	//Getters and Setters for all attributes
	public String getEventName()
	{
		return eventName;
	}
	
	public void setEventName(String eventName)
	{
		this.eventName = eventName;
	}
	
	public String getContactName()
	{
		return contactName;
	}
	
	public void setContactName(String contactName)
	{
		this.contactName = contactName;
	}
	
	public String getPhoneNum()
	{
		return phoneNum;
	}
	
	public void setPhoneNum(String phoneNum)
	{
		this.phoneNum = phoneNum;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getAttendance() {
		return attendance;
	}

	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}

	/**
	 * This method is for calculating the events total estimate.
	 * @return - Returns the estimate for the event
	 */
	public int getEventEstimate() 
	{
		int estimate = 0;
		
		//Attendance calculations
		//head count, 0-100 price per person is $2000, 100-500 price is $1500, 500 and up is $1000
		if(getAttendance() <= 100)
		{
			estimate += (getAttendance() * 2000);
		}
		else if(getAttendance() > 100 && getAttendance() < 500)
		{
			estimate += (getAttendance() * 1500);
		}
		else
		{
			estimate += (getAttendance() * 1000);
		}
		
		//Weather Calculation
		
		
		//Month Calculation
		//Add extra 3000 fee if event is held in months Jan, Nov, or Dec
		if(getMonth(getDate()).equals("January") || getMonth(getDate()).equals("November")
				|| getMonth(getDate()).equals("December")) 
		{
			estimate += 3000;
		}
		
		//Event Type Calculation
		//If event type is Musical, then discount 1000
		if(getEventType().equals("Musical"))
		{
			estimate -= 1000;
		}
		
		return estimate;
	}
	
	/**
	 * 
	 * @param eventDate - Takes in a Date object to determine its month
	 * @return - Returns the string of the month that is in the Date object 
	 */
	private String getMonth(Date eventDate)
	{
		SimpleDateFormat formatNowMonth = new SimpleDateFormat("MM");
		return formatNowMonth.format(eventDate);
	}
}
