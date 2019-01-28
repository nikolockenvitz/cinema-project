package com.fallstudie.cinemasystem.data.entity.dao;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.eclipse.persistence.config.CacheUsage;
import org.eclipse.persistence.config.QueryHints;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fallstudie.cinemasystem.data.entity.dao.intf.Dao;

public abstract class BaseDao<T> implements Dao<T>
{

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseDao.class);

    protected static String entityManagerName = "kinosystemdatawarehouse";

    private EntityManager em;

    public BaseDao( )
    {
        super();
    }

    public void setEntityManagerName ( String eManagerName )
    {
        entityManagerName = eManagerName;
    }

    @Override
    protected void finalize ( ) throws Throwable
    {
        if ( em != null && em.isOpen() )
        {
            em.close();
        }
        super.finalize();
    }

    public EntityManager getEm ( )
    {
        if ( null == em || !em.isOpen() )
        {
            EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(entityManagerName);
            em = emfactory.createEntityManager();
        }
        return em;
    }

    public Integer count ( String table )
    {
        Integer result = null;
        try
        {
            Query query = getEm().createNativeQuery("Select count(id) from KINOSYSTEM" + table.toUpperCase()).setHint(QueryHints.CACHE_USAGE,
                    CacheUsage.DoNotCheckCache);
            ;
            BigDecimal o = (BigDecimal) query.getSingleResult();
            result = new Integer(o.intValue());
        } catch (Exception e)
        {
            LOGGER.error(e.getMessage());
        }
        return result;
    }

    @Override
    public T persist ( T object )
    {
        EntityTransaction transaction = getEm().getTransaction();
        transaction.begin();
        try
        {
            getEm().persist(object);
            transaction.commit();
        } catch (Exception e)
        {
            transaction.rollback();
        }
        return object;
    }

    @Override
    public boolean contains ( T object )
    {
        return getEm().contains(object);
    }

    @Override
    public T merge ( T object )
    {
        EntityTransaction transaction = getEm().getTransaction();
        transaction.begin();
        try
        {
            T merge = getEm().merge(object);
            transaction.commit();
            return merge;
        } catch (Exception e)
        {
            transaction.rollback();
        }
        return object;
    }

    @Override
    public T remove ( T object )
    {
        EntityTransaction transaction = getEm().getTransaction();
        transaction.begin();
        try
        {
            if ( !getEm().contains(object) )
            {
                object = getEm().merge(object);
            }
            getEm().remove(object);
            transaction.commit();
        } catch (Exception e)
        {
            transaction.rollback();
        }
        return object;
    }
}
