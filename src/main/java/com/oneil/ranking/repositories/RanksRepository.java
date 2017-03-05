package com.oneil.ranking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oneil.ranking.model.Ranks;
@Repository
public interface RanksRepository extends JpaRepository<Ranks, Long>,RanksRepositoryCustom {
	Ranks findByWebsite(String website);

}
