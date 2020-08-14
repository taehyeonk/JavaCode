package com.hankki.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.hankki.app.model.MenuVO;
import com.hankki.app.model.ListVO;
import com.hankki.app.model.StoreVO;

@Repository
public class StoreRepository implements IStoreRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private class StoreMapper implements RowMapper<StoreVO> {
		@Override
		public StoreVO mapRow(ResultSet rs, int count) throws SQLException {
			StoreVO store = new StoreVO();
			store.setStoreId(rs.getInt("ID"));
			store.setImgStr(rs.getString("IMG_STR"));
			store.setStoreName(rs.getString("NAME"));
			store.setPosition(rs.getString("POSITION"));
			
			return store;
		}			
	}
	
	private class ListMapper implements RowMapper<ListVO> {
		@Override
		public ListVO mapRow(ResultSet rs, int count) throws SQLException {
			ListVO store = new ListVO();
			store.setStoreId(rs.getInt("ID"));
			store.setImgStr(rs.getString("IMG_STR"));
			store.setStoreName(rs.getString("NAME"));
			store.setPosition(rs.getString("POSITION"));
			store.setStar(rs.getDouble("AVG"));
			
			return store;
		}			
	}
	
	@Override
	public int getStoreCount() {
		String sql = "select count(*) from store";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public int getStoreCount(String name) {
		String sql = "select count(*) from store where name=?";
		return jdbcTemplate.queryForObject(sql, Integer.class, name);
	}

	@Override
	public List<StoreVO> getStoreList() {
		String sql = "select * from store order by id";
		return jdbcTemplate.query(sql, new RowMapper<StoreVO>() {
			@Override
			public StoreVO mapRow(ResultSet rs, int count) throws SQLException {
				StoreVO store = new StoreVO();
				store.setStoreId(rs.getInt("ID"));
				store.setImgStr(rs.getString("IMG_STR"));
				store.setStoreName(rs.getString("NAME"));
				store.setPosition(rs.getString("POSITION"));
				System.out.println(store);
				return store;
			}
		});
	}

	@Override
	public StoreVO getStoreInfo(int storeid) {
		String sql = "select id, img_str, name, position "
				+ "from store where id=?";		
		return jdbcTemplate.queryForObject(sql, new StoreMapper(), storeid);
	}
	
	@Override
	public int getStoreMenuCount(int storeId) {
		String sql = "select count(*) from menu where store_id=?";
		return jdbcTemplate.queryForObject(sql, Integer.class, storeId);
	}

	@Override
	public void updateStore(StoreVO store) {
		String sql = "update store "
				+ "set img_str=?, name=?, position=? where id=?";
		jdbcTemplate.update(sql, store.getImgStr(),
				store.getStoreName(),
				store.getPosition(),
				store.getStoreId()
		);
	}

	@Override
	public void insertStore(StoreVO store) {
		String sql = "insert into store (id, img_str, name, position) "
				+ "values (seq_id_store.nextval,?,?,?)";
		jdbcTemplate.update(sql,
				store.getImgStr(),
				store.getStoreName(),				
				store.getPosition()
		);
	}
	
	@Override
	public void deleteStore(int storeid) {
		String sql = "delete from store where id=?";
		jdbcTemplate.update(sql, storeid);
	}
	
	@Override
	public List<ListVO> getStaravg() {
		String sql = "SELECT S.ID, S.IMG_STR, S.NAME, S.POSITION, ROUND(AVG(M.STAR),2) AS AVG FROM STORE S LEFT OUTER JOIN MENU M ON (S.ID=M.STORE_ID) GROUP BY S.ID, S.IMG_STR, S.NAME, S.POSITION ORDER BY ID";
		return jdbcTemplate.query(sql, new RowMapper<ListVO>() {
			@Override
			public ListVO mapRow(ResultSet rs, int count) throws SQLException {
				ListVO list = new ListVO();
				list.setStoreId(rs.getInt("ID"));
				list.setImgStr(rs.getString("IMG_STR"));
				list.setStoreName(rs.getString("NAME"));
				list.setPosition(rs.getString("POSITION"));
				list.setStar(rs.getDouble("AVG"));
				System.out.println(list);
				return list;
			}
		});
	}
	
	@Override
	public ListVO getStarinfo(int storeid) {
		String sql = "SELECT S.ID, S.IMG_STR, S.NAME, S.POSITION, ROUND(AVG(M.STAR),2) AS AVG FROM STORE S JOIN MENU M ON (S.ID=M.STORE_ID) WHERE S.ID=? GROUP BY S.ID, S.IMG_STR, S.NAME, S.POSITION ORDER BY ID";
		return jdbcTemplate.queryForObject(sql, new ListMapper(), storeid);
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