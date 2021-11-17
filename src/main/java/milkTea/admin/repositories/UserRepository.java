/**
 * (C) Copyright of Fresher FPT Software Academy. All Rights Reserved
 *
 * @author Minh
 * @date Aug 15, 2021
 * @version 1.0
 */
package milkTea.admin.repositories;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import milkTea.admin.entities.UserEntity;

@Repository
public class UserRepository {

	@Autowired
	@Qualifier(value = "sessionFactory")
	SessionFactory sf;

	public List<UserEntity> findAll() {
//		EntityManager em = sf.createEntityManager();
		Session session = sf.openSession();

		String strHql = "FROM User";
		Query<UserEntity> hql = session.createQuery(strHql, UserEntity.class);
		List<UserEntity> result = hql.getResultList();

//		String strSql = "SELECT * FROM Fr2107User";
//		NativeQuery<UserEntity> sql = session.createNativeQuery(strSql, UserEntity.class);
//		List<UserEntity> result = sql.getResultList();

		session.close();
		return result;
	}

	public List<UserEntity> findByEmail(String email) {
//		EntityManager em = sf.createEntityManager();
		Session session = sf.openSession();

		String strHql = "FROM User u where u.email=?1";
		Query<UserEntity> hql = session.createQuery(strHql, UserEntity.class);
		hql.setParameter(1, email);
		List<UserEntity> result = hql.getResultList();

//		String strSql = "SELECT * FROM Fr2107User";
//		NativeQuery<UserEntity> sql = session.createNativeQuery(strSql, UserEntity.class);
//		List<UserEntity> result = sql.getResultList();

		session.close();
		return result;
	}

	public Optional<UserEntity> findById(int userId) {
		Session session = sf.openSession();
		UserEntity obj = session.get(UserEntity.class, userId);
		Optional<UserEntity> result = Optional.ofNullable(obj);
		session.close();
		return result;
	}

	public boolean save(UserEntity entity) {
		Session session = sf.openSession();
		session.beginTransaction();

		// session.get(entity.getClass(), id); // reflection
		// session.save(entity);
		// session.update(entity);
		session.saveOrUpdate(entity);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	public boolean deleteById(int userId) {
		Session session = sf.openSession();
		session.beginTransaction();
		UserEntity obj = session.get(UserEntity.class, userId);
		if (obj != null) {
			session.delete(obj);
			session.getTransaction().commit();
			session.close();
		}
		return true;
	}
}
