package entity.user;

import utils.IdCounter;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a common user with attributes such as a user ID, username, password, name, email, and phone.
 * This class implements the {@link User} interface.
 *
 * @version 1.0
 * @since 2024-07-12
 */

public class CommonUser implements User {


	/**
	 * Username of the user.
	 */
	private String username;

	/**
	 * Password of the user.
	 */
	private String password;

	/**
	 * The name of the person the user belongs to.
	 */
	private String name;

	/**
	 * The email of the user.
	 */
	private String email;

	/**
	 * The phone number of the user
	 */
	private String phone;

	/**
	 * The user's notifications
	 */
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
	 * Gets the username of the user.
	 *
	 * @return name the name of person the user belongs to
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the user.
	 *
	 * @param name the name of the user
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the username of the user.
	 *
	 * @return email the email of the user
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
	 * Gets the phone of the user.
	 *
	 * @return phone the phone number of the user
	 */
	@Override
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the phone of the user.
	 *
	 * @param num the phone number of the user
	 */
	@Override
	public void setPhone(String num) {
		this.phone = num;
	}

	/**
	 * Adds to the user's notifications
	 */
	@Override
	public void addNotif(String notif) {
		notifications.add(notif);
	}

}
