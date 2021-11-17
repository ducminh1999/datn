/**
 * (C) Copyright of Fresher FPT Software Academy. All Rights Reserved
 *
 * @author Minh
 * @date Aug 15, 2021
 * @version 1.0
 */
package milkTea.admin.services;

import java.util.List;

import milkTea.admin.dto.User;
import milkTea.admin.repositories.UserRes2;

public class UserService2 {
	public static void main(String[] args) {

		UserRes2 UserRes2 = new UserRes2();
		User user = UserRes2.findOne("user1@gmail.com");
		user.showInfo();
	}

	public List<User> findAll() {
		UserRes2 UserRes2 = new UserRes2();
		return UserRes2.findAll();
	}

	public User findOne(String email) {
		UserRes2 UserRes2 = new UserRes2();
		return UserRes2.findOne(email);
	}

	public User findOne(int id) {
		UserRes2 UserRes2 = new UserRes2();
		return UserRes2.findOne(id);
	}

	public boolean add(User user) {
		UserRes2 UserRes2 = new UserRes2();
		return UserRes2.add(user);
	}

	public boolean update(int userId, User user) {
		UserRes2 UserRes2 = new UserRes2();
		return UserRes2.update(userId, user);
	}

	public boolean delete(int userId) {
		UserRes2 UserRes2 = new UserRes2();
		return UserRes2.delete(userId);
	}

}
