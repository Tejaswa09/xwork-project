package com.xworkz.rpapp.repo.impl;

import com.xworkz.rpapp.entity.LoginEntity;
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
    public UserEntity entityByEmail(String email) {

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
    public UserEntity entityByMobile(Long mobileNumber) {
        try {
            EntityManager manager = factory.createEntityManager();
            Query query =manager.createNamedQuery("getDetailsByMobileNumber");
            query.setParameter("mobileNumber",mobileNumber);
            entity=(UserEntity) query.getSingleResult();

            return entity;
        }catch (NoResultException e){

            return new UserEntity();
        }
    }

    @Override
    public void loginInfoSave(LoginEntity loginEntity) {

        try{
            EntityManager manager = factory.createEntityManager();
            manager.getTransaction().begin();
            manager.persist(loginEntity);
            manager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void updateOtp(String email,String generatedOtp) {
        try {
            EntityManager manager = factory.createEntityManager();
            UserEntity entity =entityByEmail(email);

            if (entity!= null){
                manager.getTransaction().begin();
                entity.setOtp(generatedOtp);
                manager.merge(entity);
                manager.getTransaction().commit();
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
