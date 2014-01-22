package com.travelsky.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.travelsky.bean.IpAdress;

public class IpDaoImpl extends JdbcDaoSupport implements IpDao {
	private IpAdress ipAd;

	@Override
	public int insert(IpAdress entity) {
		String sql = "insert into ipadress(adress,port,speed,country,province,city,isp,isDomestic,isAlive,collectDate) "
				+ "values(?,?,?,?,?,?,?,?,?,now())";
		Object[] params = new Object[] { entity.getAdress(), entity.getPort(),
				entity.getSpeed(), entity.getCountry(), entity.getProvince(),
				entity.getCity(), entity.getIsp(), entity.isDomestic(),
				entity.isAlive() };
		int[] types = new int[] { Types.VARCHAR, Types.INTEGER, Types.VARCHAR,
				Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
				Types.BOOLEAN, Types.BOOLEAN };
		return getJdbcTemplate().update(sql, params, types);
	}

	/**
	 * 删除重复IP
	 */
	@Override
	public int deleteRep() {
		String sql = "delete from ipadress  where id not in "
				+ " (select a.asset from (select max(id) as asset from ipadress  group by adress) a)";
		return getJdbcTemplate().update(sql);
	}

	/**
	 * 将暂时失效的Ip删除
	 */
	@Override
	public int deleteByIsAlive() {
		String sql = "delete from ipadress where isAlive=0";
		return getJdbcTemplate().update(sql);
	}

	@Override
	public int update(IpAdress entity) {
		String sql = "update ipadress set speed=?,country=?,province=?,city=?,isp=?,isDomestic=?,isAlive=?,collectDate=now()" +
				"where adress=? and port=?";
		Object[] params = new Object[] {entity.getSpeed(), entity.getCountry(), entity.getProvince(),
				entity.getCity(), entity.getIsp(), entity.isDomestic(),
				entity.isAlive(),entity.getAdress(),entity.getPort()};
		int[] types = new int[] { Types.VARCHAR,Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, 
				Types.VARCHAR, Types.BOOLEAN, Types.BOOLEAN , Types.VARCHAR, Types.INTEGER};
		return getJdbcTemplate().update(sql, params, types);
	}

	@Override
	public void BatchInsert(final List<IpAdress> ipAdressList) {
		String sql = "insert into ipadress(adress,port,speed,country,province,city,isp,isDomestic,isAlive,collectDate) "
				+ "values(?,?,?,?,?,?,?,?,?,now())";
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			public int getBatchSize() {
				return ipAdressList.size();
			}

			@Override
			public void setValues(PreparedStatement ps, int i)
					throws SQLException {
				IpAdress ipAd = (IpAdress) ipAdressList.get(i);
				ps.setString(1, ipAd.getAdress());
				ps.setInt(2, ipAd.getPort());
				ps.setString(3, ipAd.getSpeed());
				ps.setString(4, ipAd.getCountry());
				ps.setString(5, ipAd.getProvince());
				ps.setString(6, ipAd.getCity());
				ps.setString(7, ipAd.getIsp());
				ps.setBoolean(8, ipAd.isDomestic());
				ps.setBoolean(9, ipAd.isAlive());
			}
		});
	}

	@Override
	public int[] BatchUpdate(final List<IpAdress> ipAdressList) {
		String sql = "update ipadress set adress=?,port=?,speed=?,country=?,province=?,city=?,isp=?,isDomestic=?,isAlive=?,collectDate=?"
				+ " where id=?";
		return getJdbcTemplate().batchUpdate(sql,
				new BatchPreparedStatementSetter() {
					public int getBatchSize() {
						return ipAdressList.size();
					}

					@Override
					public void setValues(PreparedStatement ps, int i)
							throws SQLException {
						IpAdress ipAd = (IpAdress) ipAdressList.get(i);
						ps.setString(1, ipAd.getAdress());
						ps.setInt(2, ipAd.getPort());
						ps.setString(3, ipAd.getSpeed());
						ps.setString(4, ipAd.getCountry());
						ps.setString(5, ipAd.getProvince());
						ps.setString(6, ipAd.getCity());
						ps.setString(7, ipAd.getIsp());
						ps.setBoolean(8, ipAd.isDomestic());
						ps.setBoolean(9, ipAd.isAlive());
						ps.setDate(10, ipAd.getCollectDate());
						ps.setInt(11, ipAd.getId());
					}
				});
	}

	@Override
	public void VerifyInsert(List<IpAdress> ipAdressList) {
		int updateCount = 0;
		int insertCount = 0;
		int size = ipAdressList.size();
		try {
			for (int i = 0; i < size; i++) {
				ipAd = ipAdressList.get(i);
				int  count = queryCount(ipAd.getAdress(),ipAd.getPort());
				if (count > 0) {
					updateCount += update(ipAd);
				} else {
					insertCount += insert(ipAd);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("更新了" + updateCount + "条记录！");
			System.out.println("插入了" + insertCount + "条新记录！");
		}
	}

	private int queryCount(String adress, int port) {
		String sql = "select count(*) from ipadress where adress=? and port=?";
		Object[] params = new Object[] { adress, port};
		int[] types = new int[] { Types.VARCHAR,Types.INTEGER };
		return getJdbcTemplate().queryForInt(sql, params, types);
	}

	@Override
	public boolean deleteById() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteByDate(Date date) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public IpAdress queryById(Integer id) {
		String sql = "select * from ipadress where id=?";
		Object[] params = new Object[] { id };
		int[] types = new int[] { Types.INTEGER };
		return (IpAdress) getJdbcTemplate().query(sql, params, types,
				new IpAdressMapper()).get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<IpAdress> queryAll() {
		String sql = "select * from ipadress order by collectDate DESC";
		return (ArrayList<IpAdress>) getJdbcTemplate().query(sql,
				new IpAdressMapper());
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<IpAdress> queryIp(IpAdress entity) {
		String sql = "select * from ipadress where adress=? and port=? and speed=? and country=? and province=? "
				+ "and city=? and isp=? and isDomestic=? and isAlive=? and collectDate=? order by collectDate DESC";
		Object[] params = new Object[] { entity.getAdress(), entity.getPort(),
				entity.getSpeed(), entity.getCountry(), entity.getProvince(),
				entity.getCity(), entity.getIsp(), entity.isDomestic(),
				entity.isAlive(), entity.getCollectDate() };
		int[] types = new int[] { Types.VARCHAR, Types.INTEGER, Types.VARCHAR,
				Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
				Types.BOOLEAN, Types.BOOLEAN, Types.DATE };
		return (ArrayList<IpAdress>) getJdbcTemplate().query(sql, params,
				types, new IpAdressMapper());
	}

	@SuppressWarnings("deprecation")
	@Override
	public int getRecordCount() {
		return getJdbcTemplate().queryForInt(
				"select count(*) as rowcount from ipadress");
	}

	@SuppressWarnings("rawtypes")
	protected class IpAdressMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			IpAdress ipAd = new IpAdress();
			ipAd.setId(rs.getInt("id"));
			ipAd.setAdress(rs.getString("adress"));
			ipAd.setPort(rs.getInt("port"));
			ipAd.setSpeed(rs.getString("speed"));
			ipAd.setCountry(rs.getString("country"));
			ipAd.setProvince(rs.getString("province"));
			ipAd.setCity(rs.getString("city"));
			ipAd.setIsp(rs.getString("isp"));
			ipAd.setDomestic(rs.getBoolean("isDomestic"));
			ipAd.setAlive(rs.getBoolean("isAlive"));
			ipAd.setCollectDate(rs.getDate("collectDate"));
			return ipAd;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<IpAdress> queryIsDomestic(boolean flag) {
		String sql = "select * from  ipadress where isDomestic=?";
		Object[] params = new Object[] {flag};
		int[] types = new int[] { Types.BOOLEAN };
		return (ArrayList<IpAdress>) getJdbcTemplate().query(sql, params, types, new IpAdressMapper());
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<IpAdress> queryIsAlived(boolean flag) {
		String sql = "select * from  ipadress where isAlive=? ";
		Object[] params = new Object[] {flag};
		int[] types = new int[] { Types.BOOLEAN };
		return (ArrayList<IpAdress>) getJdbcTemplate().query(sql, params, types, new IpAdressMapper());
	}


}
