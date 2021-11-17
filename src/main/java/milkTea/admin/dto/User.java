/**
 * (C) Copyright of Fresher FPT Software Academy. All Rights Reserved
 *
 * @author Minh
 * @date Aug 15, 2021
 * @version 1.0
 */
package milkTea.admin.dto;

public class User {
	private int id;
	private String userName;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String phone;
	private String description;
	private String createDate;
	private String updateDate;

	public User() {
		super();
	}

	public User(String userName, String email, String password, String firstName, String lastName, String phone,
			String description, String createDate, String updateDate) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.description = description;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public User(int id, String userName, String email, String password, String firstName, String lastName,
			String phone, String description, String createDate, String updateDate) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.description = description;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public void showInfo() {
		System.out.println(this.userName);
		System.out.println(this.email);
		System.out.println(this.password);
		System.out.println(this.firstName);
		System.out.println(this.lastName);
		System.out.println(this.phone);
		System.out.println(this.description);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

}
