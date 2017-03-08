package com.oneil.ranking.repositories;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.Temporal;

import com.oneil.ranking.model.Ranks;

public class RanksRepositoryImpl implements RanksRepositoryCustom{
	private static final Logger logger = LoggerFactory.getLogger(RanksRepositoryImpl.class);
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Ranks> retrieveTop5Ranks( Date recDate) {
		logger.info("RanksRepositoryImpl-----------retrieveTop5Ranks---");
		String sql = "SELECT r FROM Ranks r where r.recDate=:recDate";
		Query query = entityManager.createQuery(sql);
		query.setParameter("recDate", recDate, TemporalType.DATE);
		query.setFirstResult(0);
		query.setMaxResults(5);
		
		List<Ranks> result = query.getResultList();
		logger.info("RanksRepositoryImpl---------results---"+result.size());
		return result;
	}

	@Override
	public List<Ranks> retrieveTop10Ranks(Date recDate) {
		String sql = "SELECT r FROM Ranks r where r.recDate=:recDate order by r.visits ";
		Query query = entityManager.createQuery(sql);
		query.setParameter("recDate", recDate);
		query.setFirstResult(0);
		query.setMaxResults(9);
		List<Ranks> result = query.getResultList();
		return result;
	}

}
