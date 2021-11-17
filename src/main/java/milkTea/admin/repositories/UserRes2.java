/**
 * (C) Copyright of Fresher FPT Software Academy. All Rights Reserved
 *
 * @author Minh
 * @date Aug 15, 2021
 * @version 1.0
 */
package milkTea.admin.repositories;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import milkTea.admin.dto.User;
import milkTea.admin.utils.DBUtils;
import milkTea.admin.utils.FormatDate;

public class UserRes2 {
//	public static void main(String[] args) {
//		UserRes sRes = new UserRes();
//		User user = sRes.findOne("user1@gmail.com");
//		user.showInfo();
//	}

	public List<User> findAll() {
		List<User> result = new ArrayList<User>();

		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "SELECT * FROM UserTable";
			PreparedStatement pStm = conn.prepareStatement(sql);
			ResultSet rs = pStm.executeQuery();
			User user;
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setFirstName(rs.getString(5));
				user.setLastName(rs.getString(6));
				user.setPhone(rs.getString(7));
				user.setDescription(rs.getString(8));
				result.add(user);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

		return result;
	}

	public User findOne(String email) {
		User user = null;
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();

			String sql = "SELECT * FROM UserTable WHERE email = ?";
			PreparedStatement pStm = conn.prepareStatement(sql);
			pStm.setString(1, email);
			ResultSet rs = pStm.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setFirstName(rs.getString(5));
				user.setLastName(rs.getString(6));
				user.setPhone(rs.getString(7));
				user.setDescription(rs.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

		return user;
	}

	public User findOne(int id) {
		User user = null;
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();

			String sql = "SELECT * FROM UserTable WHERE id = ?";
			PreparedStatement pStm = conn.prepareStatement(sql);
			pStm.setInt(1, id);
			ResultSet rs = pStm.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setFirstName(rs.getString(5));
				user.setLastName(rs.getString(6));
				user.setPhone(rs.getString(7));
				user.setDescription(rs.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

		return user;
	}

	public boolean add(User user) {
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "INSERT INTO UserTable (userName, email, password, firstName, lastName, phone, description, createDate)"
					+ "VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement pStm = conn.prepareStatement(sql);
			pStm.setString(1, user.getUserName());
			pStm.setString(2, user.getEmail());
			pStm.setString(3, user.getPassword());
			pStm.setString(4, user.getFirstName());
			pStm.setString(5, user.getLastName());
			pStm.setString(6, user.getPhone());
			pStm.setString(7, user.getDescription());
			Date date = new java.sql.Date((new java.util.Date().getTime()));
			System.out.println(date+"--"+FormatDate.format(date));
			pStm.setString(8, FormatDate.format(date));
			pStm.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		System.out.println("Add user successful");
		return true;
	}

	public boolean update(int userId, User user) {

		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "UPDATE UserTable" + " SET username = ?" + " , email = ?" + " , password = ?"
					+ " , firstName = ?" + " , lastName = ?" + " , phone = ?" + " , description = ?"
					+ " , updateDate = ?" + " WHERE ID = ?";
			PreparedStatement pStm = conn.prepareStatement(sql);
			pStm.setString(1, user.getUserName());
			pStm.setString(2, user.getEmail());
			pStm.setString(3, user.getPassword());
			pStm.setString(4, user.getFirstName());
			pStm.setString(5, user.getLastName());
			pStm.setString(6, user.getPhone());
			pStm.setString(7, user.getDescription());
			Date date = new java.sql.Date((new java.util.Date().getTime()));
			pStm.setString(8, FormatDate.format(date));
			pStm.setInt(9, userId);
			pStm.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		System.out.println("Update user successful");
		return true;
	}

	public boolean delete(int userId) {

		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "DELETE UserTable" + " WHERE ID = ?";
			PreparedStatement pStm = conn.prepareStatement(sql);
			pStm.setInt(1, userId);
			pStm.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		System.out.println("Delete user successful");
		return true;
	}

}
