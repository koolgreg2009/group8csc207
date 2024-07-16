package entity.User;

import utils.IdCounter;

/**
 * Represents a common user with attributes such as a user ID, username, password, name, email, and phone.
 * This class implements the {@link User} interface.
 *
 * @version 1.0
 * @since 2024-07-12
 */

public class CommonUser implements User {
	/**
	 * The unique identification for the user.
	 */
	private final long userId;

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
	 *
	 * @param username the username of the user
	 * @param password the password of the user
	 * @param name the name of the person the user belongs to
	 * @param email the email of the user
	 * @param phone the phone number of the user
	 */
	public CommonUser(String username, String password, String name, String email, String phone) {
		this(IdCounter.getNextID(), username, password, name, email, phone);
	}

	/**
	 *
	 * @param userId the unique identification for the user
	 * @param username the username of the user
	 * @param password the password of the user
	 * @param name the password of the user
	 * @param email the email of the user
	 * @param phone the phone number of the user
	 */
	public CommonUser(long userId, String username, String password, String name, String email, String phone) {
		this.userId = userId; // for json file processor to use -- tells it to use this to convert
		//it into a java object. In addition, this constructor is made to use for the above constructor as well
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	/**
	 * Gets the identification of the user.
	 *
	 * @return the identifier of the user
	 */
	@Override
	public long getUserId() {
		return userId;
	}

	/**
	 * Gets the username of the user.
	 *
	 * @return username of the user
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

}
