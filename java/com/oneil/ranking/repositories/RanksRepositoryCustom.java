package com.oneil.ranking.repositories;

import java.util.Date;
import java.util.List;

import com.oneil.ranking.model.Ranks;

public interface RanksRepositoryCustom {
    public List<Ranks> retrieveTop5Ranks(Date recDate);
	public List<Ranks> retrieveTop10Ranks(Date recDate);
}
