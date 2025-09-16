package com.xworkz.rpapp.repo.impl;

import com.xworkz.rpapp.entity.UserEntity;
import com.xworkz.rpapp.repo.RPRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Repository
public class RPRepoImpl implements RPRepo {
    @Autowired
    EntityManagerFactory factory;
    UserEntity entity = new UserEntity();
    @Override
    public boolean save(UserEntity entity) {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(entity);
        manager.getTransaction().commit();
        manager.close();
        return true;
    }

    @Override
    public UserEntity isEmailAvailable(String email) {

        try {
            EntityManager manager = factory.createEntityManager();
            Query query=manager.createNamedQuery("getDetailsByEmail");
            query.setParameter("mail",email);
            return (UserEntity) query.getSingleResult();
        }catch (NoResultException e){
            return entity;
        }

    }

    @Override
    public UserEntity isMobileNumberAvailable(Long mobileNumber) {
        try {
            EntityManager manager = factory.createEntityManager();
            Query query =manager.createNamedQuery("getDetailsByMobileNumber");
            query.setParameter("mobileNumber",mobileNumber);
            return (UserEntity) query.getSingleResult();
        }catch (NoResultException e){

            return new UserEntity();
        }
    }
}
