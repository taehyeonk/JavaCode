package com.hankki.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.hankki.app.model.MenuVO;

@Repository
public class MenuRepository implements IMenuRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private class MenuMapper implements RowMapper<MenuVO> {
		@Override
		public MenuVO mapRow(ResultSet rs, int count) throws SQLException {
			MenuVO menu = new MenuVO();
			menu.setMenuId(rs.getInt("ID"));
			menu.setStoreId(rs.getInt("STORE_ID"));
			menu.setMenuName(rs.getString("NAME"));
			menu.setCost(rs.getInt("COST"));
			menu.setImgStr(rs.getString("IMG_STR"));
			menu.setStar(rs.getDouble("STAR"));
			menu.setComments(rs.getString("COMMENTS"));
			
			return menu;
		}			
	}
	
	@Override
	public int getMenuCount() {
		String sql = "select count(*) from menu";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public int getMenuCount(String name) {
		String sql = "select count(*) from menu where name=?";
		return jdbcTemplate.queryForObject(sql, Integer.class, name);
	}

	@Override
	public List<MenuVO> getMenuList(int storeid) {
		String sql = "select * from menu where store_id=? order by id";
		return jdbcTemplate.query(sql, new RowMapper<MenuVO>() {
			@Override
			public MenuVO mapRow(ResultSet rs, int count) throws SQLException {
				MenuVO menu = new MenuVO();
				menu.setMenuId(rs.getInt("ID"));
				menu.setStoreId(rs.getInt("STORE_ID"));
				menu.setMenuName(rs.getString("NAME"));
				menu.setCost(rs.getInt("COST"));
				menu.setImgStr(rs.getString("IMG_STR"));
				menu.setStar(rs.getDouble("STAR"));
				menu.setComments(rs.getString("COMMENTS")); 
				return menu;
			}
		}, storeid);
	}

	@Override
	public MenuVO getMenuInfo(int menuid) {
		String sql = "select id, img_str, name, position, img_str, star, comments "
				+ "from menu where id=?";		
		return jdbcTemplate.queryForObject(sql, new MenuMapper(), menuid);
	}

	@Override
	public void updateMenu(MenuVO menu) {
		String sql = "update menu "
				+ "set store_id=?, name=?, cost=?, img_str=?, star=?, comments=? where id=?";
		jdbcTemplate.update(sql, menu.getMenuName(),
				menu.getStoreId(),
				menu.getCost(),
				menu.getImgStr(),
				menu.getMenuId(),
				menu.getStar(),
				menu.getComments()
		);
	}

	@Override
	public void insertMenu(MenuVO menu) {
		String sql = "insert into menu (id, store_id, name, cost, img_str, star, comments) "
				+ "values (seq_id_menu.nextval,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,
				menu.getStoreId(),
				menu.getMenuName(),				
				menu.getCost(),
				menu.getImgStr(),
				menu.getStar(),
				menu.getComments()
		);
	}
	
	@Override
	public void deleteMenu(int menuid) {
		String sql = "delete from menu where id=?";
		jdbcTemplate.update(sql, menuid);
	}
	
}//end class

/*
@Override
public List<Map<Integer, String>> getAllDeptId() {
	String sql = "select department_id, department_name from departments";
	return jdbcTemplate.query(sql, new RowMapper<Map<Integer, String>>() {
		@Override
		public Map<Integer, String> mapRow(ResultSet rs, int count) throws SQLException {
			Map<Integer, String> deptMap = new HashMap<Integer, String>();
			deptMap.put(rs.getInt("department_id"), rs.getString("department_name"));
			return deptMap;
		};
	});
}
*/