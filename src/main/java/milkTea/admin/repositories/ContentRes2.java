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

import milkTea.admin.dto.ContentDto;
import milkTea.admin.utils.DBUtils;
import milkTea.admin.utils.FormatDate;

public class ContentRes2 {
	public List<ContentDto> findAll() {
		List<ContentDto> result = new ArrayList<>();

		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "SELECT * FROM ContentTable";
			PreparedStatement pStm = conn.prepareStatement(sql);
			ResultSet rs = pStm.executeQuery();
			ContentDto content;
			while (rs.next()) {
				content = new ContentDto();
				content.setId(rs.getInt(1));
				content.setTitle(rs.getString(2));
				content.setBrief(rs.getString(3));
				content.setContent(rs.getString(4));
				content.setCreateDate(rs.getString(5));
				
				result.add(content);
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
		System.out.println("return list content");
		return result;
	}
	public ContentDto findId(int id) {
		Connection conn = null;
		ContentDto content = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "SELECT * FROM ContentTable WHERE id = ?";
			PreparedStatement pStm = conn.prepareStatement(sql);
			pStm.setInt(1, id);
			ResultSet rs = pStm.executeQuery();
			if (rs.next()) {
				content = new ContentDto();
				content.setId(rs.getInt(1));
				content.setTitle(rs.getString(2));
				content.setBrief(rs.getString(3));
				content.setContent(rs.getString(4));
				content.setCreateDate(rs.getString(5));
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
		System.out.println("return content");
		return content;
	}

	public List<ContentDto> find(String title) {
		List<ContentDto> result = new ArrayList<ContentDto>();
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			title = "%" + title + "%";
			String sql = "SELECT * FROM ContentTable WHERE title like ?";
			PreparedStatement pStm = conn.prepareStatement(sql);
			pStm.setString(1, title);
			ResultSet rs = pStm.executeQuery();
			ContentDto content;
			while (rs.next()) {
				content = new ContentDto();
				content.setId(rs.getInt(1));
				content.setTitle(rs.getString(2));
				content.setBrief(rs.getString(3));
				content.setContent(rs.getString(4));
				content.setCreateDate(rs.getString(5));
				result.add(content);
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
		System.out.println("return list content");
		return result;
	}

	public boolean add(ContentDto content) {
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "INSERT INTO ContentTable (title, brief, contents, createDate)" + "VALUES(?,?,?,?)";
			PreparedStatement pStm = conn.prepareStatement(sql);
			pStm.setString(1, content.getTitle());
			pStm.setString(2, content.getBrief());
			pStm.setString(3, content.getContent());
			pStm.setString(4, content.getCreateDate());
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
		System.out.println("Add content successful");
		return true;
	}
	
	public boolean update(int id, ContentDto content) {
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "UPDATE ContentTable" + " SET title = ?" + " , brief = ?" + " , contents = ?"
					+ " , updateDate = ?" +" WHERE ID = ?";
			PreparedStatement pStm = conn.prepareStatement(sql);
			pStm.setString(1, content.getTitle());
			pStm.setString(2, content.getBrief());
			pStm.setString(3, content.getContent());
			Date date = new java.sql.Date((new java.util.Date().getTime()));
			pStm.setString(4, FormatDate.format(date));
			pStm.setInt(5, id);
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
		System.out.println("Update content successful");
		return true;
	}
	public boolean delete(int id) {

		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "DELETE ContentTable" + " WHERE ID = ?";
			PreparedStatement pStm = conn.prepareStatement(sql);
			pStm.setInt(1, id);
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
		System.out.println("Delete content successful");
		return true;
	}
}
