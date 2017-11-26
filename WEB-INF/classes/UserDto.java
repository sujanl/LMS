public class UserDto{
	private String fullName;
	private String course;
	private String contact;
	private String email;
	private String userName;
	private String password;

	public void setFullName(String fullName){
		this.fullName = fullName;
	}
	public void setContact(String contact){
		this.contact = contact;
	}
	public void setCourse(String course){
		this.course = course;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}
	public void setPassword(String password){
		this.password = password;
	}

	
	public String getFullName(){
		return fullName;
	}
	public String getContact(){
		return contact;
	}
	public String getCourse(){
		return course;
	}
	public String getEmail(){
		return email;
	}
	public String getUserName(){
		return userName;
	}
	public String getPassword(){
		return password;
	}
}