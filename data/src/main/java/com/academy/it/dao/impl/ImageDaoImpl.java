package com.academy.it.dao.impl;

import com.academy.it.dao.ImageDao;
import com.academy.it.entity.Image;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ImageDaoImpl extends BaseDao<Image, String> implements ImageDao {

    private static final String FIND_BY_USER_ID_QUERY = "SELECT img FROM Image img WHERE img.appUser.id=:user_id";

    public ImageDaoImpl() {
        super(Image.class);
    }

    @Override
    public List<Image> findByUserId(String userId) {
        Session session = getSession();
        Query<Image> query = session.createQuery(FIND_BY_USER_ID_QUERY, Image.class);
        query.setParameter("user_id", userId);
        return query.list();
    }
}
