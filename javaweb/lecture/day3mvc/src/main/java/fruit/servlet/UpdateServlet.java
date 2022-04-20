package fruit.servlet;

import fruit.bean.Fruit;
import fruit.dao.FruitDAO;
import fruit.dao.FruitDAOImpl;
import myssm.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/update.do")
public class UpdateServlet extends ViewBaseServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        Integer fid = Integer.parseInt(req.getParameter("fid"));
        String fname = req.getParameter("fname");
        Integer price = Integer.parseInt(req.getParameter("price"));
        Integer fcount = Integer.parseInt(req.getParameter("fcount"));
        String remark = req.getParameter("remark");
        Fruit fruit = new Fruit(fid, fname, price, fcount, remark);

        FruitDAO fruitDAO = new FruitDAOImpl();
        try {
            fruitDAO.updateFruit(connection, fruit);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("/day2/client");
    }
}
