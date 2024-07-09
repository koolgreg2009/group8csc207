package entity.User;

import utils.IdCounter;


public class CommonUser implements User {
	private final long userId;
	private String username;
	private String password;
	private String name;
	private String email;
	private String phone;

	public CommonUser(String username, String password, String name, String email, String phone) {
		this(IdCounter.getNextID(), username, password, name, email, phone);
	}

	public CommonUser(long userId, String username, String password, String name, String email, String phone) {
		this.userId = userId; // for json file processor to use -- tells it to use this to convert
		//it into a java object. In addition, this constructor is made to use for the above constructor as well
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	@Override
	public long getUserId() {
		return userId;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getPhone() {
		return phone;
	}

	@Override
	public void setPhone(String num) {
		this.phone = num;
	}

}
