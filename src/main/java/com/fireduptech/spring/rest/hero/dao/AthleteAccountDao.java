package com.fireduptech.spring.rest.hero.dao;

import com.fireduptech.spring.rest.hero.domain.AthleteAccount;

public interface AthleteAccountDao {

    AthleteAccount getAthleteAccount( int athleteAccountId );
}