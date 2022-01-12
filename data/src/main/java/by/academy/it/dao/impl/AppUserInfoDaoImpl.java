package by.academy.it.dao.impl;

import by.academy.it.dao.AppUserInfoDao;
import by.academy.it.entity.AppUserInfo;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class AppUserInfoDaoImpl extends BaseDao<AppUserInfo, String> implements AppUserInfoDao {

    //public static final String UPDATE_QUERY = "UPDATE AppUserInfo SET updateDate=:update WHERE id=:user_info_id";

    public AppUserInfoDaoImpl() {
        super(AppUserInfo.class);
    }

}
