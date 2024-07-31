package entity.user;

import utils.IdCounter;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a common user with attributes such as a user ID, username, password, name, email, and phone.
 * This class implements the {@link User} interface.
 */

public class CommonUser implements User {
	private String username;
	private String password;
	private String name;
	private String email;
	private String phone;
	private List<String> notifications;

	/**
	 *
	 * @param username the username of the user
	 * @param password the password of the user
	 * @param name the name of the person the user belongs to
	 * @param email the email of the user
	 * @param phone the phone number of the user
	 */
	public CommonUser(String username, String password, String name, String email, String phone) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.notifications = new ArrayList<String>();
	}

	/**
	 * Gets the username of the user.
	 *
	 * @return the username of the user
	 */
	@Override
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username of the user.
	 *
	 * @param username the username of the user
	 */
	@Override
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the password of the user.
	 *
	 * @return password of the user
	 */
	@Override
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password of the user.
	 *
	 * @param password the password of the user
	 */
	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the name of the person associated with the user.
	 *
	 * @return the name of the user.
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the user.
	 *
	 * @param name the name of the user.
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the email address of the user.
	 *
	 * @return the email address of the user
	 */
	@Override
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email of the user.
	 *
	 * @param email the email of the user
	 */
	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the phone number of the user.
	 *
	 * @return phone the phone number of the user
	 */
	@Override
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the phone number of the user.
	 *
	 * @param num the phone number of the user
	 */
	@Override
	public void setPhone(String num) {
		this.phone = num;
	}

	/**
	 * Adds a notification to the user's list of notifications.
	 *
	 * @param notif the notification to be added
	 */
	@Override
	public void addNotif(String notif) {
		notifications.add(notif);
	}

	/**
	 * Gets the list of notifications for the user.
	 *
	 * @return a list of notifications
	 */
	public List<String> getNotifications() {
		return notifications;
	}

	/**
	 * Returns a string representation of the user, including class name, username, password, name, and email.
	 *
	 * @return a string representation of the user
	 */
	@Override
	public String toString(){
		return this.getClass() + "username: " + this.getUsername()+"\npassword: " + this.getPassword()+"\nname: " + this.getName()+"\nemail: " + this.getEmail();
	}

}
