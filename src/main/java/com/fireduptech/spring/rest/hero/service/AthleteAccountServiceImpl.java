package com.fireduptech.spring.rest.hero.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.fireduptech.spring.rest.hero.domain.AthleteAccount;
import com.fireduptech.spring.rest.hero.dao.AthleteAccountDao;

import com.fireduptech.spring.rest.hero.repository.AthleteAccountRepository;

@Service
public class AthleteAccountServiceImpl implements AthleteAccountService {

    @Autowired
    private AthleteAccountDao athleteAccountDao;

    @Autowired
    private AthleteAccountRepository athleteAccountRepository;


    @Override
    public AthleteAccount getAthleteAccount( int athleteAccountId ) {
        return athleteAccountDao.getAthleteAccount( athleteAccountId );
    }


    // JPA Retrieval
    @Override
    public AthleteAccount findByFirstName( String firstName ) {
        try {
            return athleteAccountRepository.findByFirstName( firstName );
        } catch ( RuntimeException e ) {
            e.printStackTrace();
            return new AthleteAccount();
        }

    }


    // JPA Retrieval
    @Override
    public AthleteAccount findById( int id ) {
        try {
            return athleteAccountRepository.findById( 35 );
        } catch ( RuntimeException e ) {
            e.printStackTrace();
            return new AthleteAccount();
        }

    }

}