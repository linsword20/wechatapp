package info.linsword20.weather.dao.impl;

import info.linsword20.weather.dao.CityInfoDAO;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CityInfoDAOImpl extends HibernateDaoSupport implements CityInfoDAO
{
	@SuppressWarnings("unchecked")
	public String findBycity(String city)
	{
		String hql = "select c.code from CityInfo c where c.city=?";
		List<String> codes = this.getHibernateTemplate().find(hql, city);
		if (codes.isEmpty())
		{
			return null;
		}
		else return codes.get(0);
	}
}
