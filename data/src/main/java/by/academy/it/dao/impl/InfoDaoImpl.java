package by.academy.it.dao.impl;

import by.academy.it.dao.InfoDao;
import by.academy.it.entity.Info;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class InfoDaoImpl extends BaseDao<Info, String> implements InfoDao {

    /*private static final String UPDATE_QUERY = "UPDATE Info SET " +
            "firstname=:name, lastname=:surname, email=:email, birthday=:birthday, gender=:gender " +
            "WHERE id=:info_id";
*/
    public InfoDaoImpl() {
        super(Info.class);
    }

}
