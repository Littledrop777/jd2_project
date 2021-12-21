package by.academy.it;

import by.academy.it.dao.UserDao;
import by.academy.it.dao.impl.UserDaoImpl;
import by.academy.it.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    UserDao userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("pass");
        Optional<User> user = userDao.findByLogin(login);
        if (user.isPresent()) {
            resp.sendRedirect("/profile.jsp");
        }else{
            req.getRequestDispatcher("/WEB-INF/registration.jsp").forward(req, resp);
        }

    }
}
