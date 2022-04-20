package fruit.servlet;

import fruit.dao.FruitDAO;
import fruit.dao.FruitDAOImpl;
import myssm.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/del.do")
public class DelServlet extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer fid = Integer.parseInt(req.getParameter("fid"));
        FruitDAO fruitDAO = new FruitDAOImpl();
        try {
            fruitDAO.delFruitById(connection, fid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("/day2/client");
    }
}
