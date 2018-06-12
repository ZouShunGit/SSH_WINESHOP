package cn.shop.wineshop.util;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;

@SuppressWarnings("deprecation")
public class PageHibernateCallback<T> implements HibernateCallback<List<T>>{
	
	private String hql;
	private Object[] params;
	private int startIndex;//��ʼҳ
	private int pageSize;//ҳ��ߴ�
	

	public PageHibernateCallback(String hql, Object[] params,
			int startIndex, int pageSize) {
		super();
		this.hql = hql;
		this.params = params;
		this.startIndex = startIndex;
		this.pageSize = pageSize;
	}



	@SuppressWarnings("unchecked")
	public List<T> doInHibernate(Session session) throws HibernateException {
		//1 ִ��hql���
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery(hql);
		//2 ʵ�ʲ���
		if(params != null){
			for(int i = 0 ; i < params.length ; i ++){
				query.setParameter(i, params[i]);
			}
		}
		//3 ��ҳ
		query.setFirstResult(startIndex);
		query.setMaxResults(pageSize);
		
		return query.list();
	}
}
