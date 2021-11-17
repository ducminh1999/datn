/**
 * (C) Copyright of Fresher FPT Software Academy. All Rights Reserved
 *
 * @author Minh
 * @date Aug 23, 2021
 * @version 1.0
 */
package milkTea.admin.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "UserTable")
@Entity(name = "User")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "userName", columnDefinition = "nvarchar(50)", unique = true, nullable = false)
	private String userName;

	@Column(name = "email", columnDefinition = "nvarchar(50)", nullable = false)
	private String email;

	@Column(name = "password", columnDefinition = "nvarchar(50)", nullable = false)
	private String password;

	@Column(name = "firstName", columnDefinition = "nvarchar(50)", nullable = true)
	private String firstName;

	@Column(name = "lastName", columnDefinition = "nvarchar(50)", nullable = true)
	private String lastName;

	@Column(name = "phone", columnDefinition = "nvarchar(13)", nullable = true)
	private String phone;

	@Column(name = "description", columnDefinition = "nvarchar(150)", nullable = true)
	private String description;

	@Column(name = "createDate", columnDefinition = "nvarchar(50)", nullable = true)
	private String createDate;

	@Column(name = "updateDate", columnDefinition = "nvarchar(50)", nullable = true)
	private String updateDate;

	@OneToMany(mappedBy = "userEntity")
	private List<ContentEntity> contentList;

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
