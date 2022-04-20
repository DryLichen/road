package fruit.servlet;

import fruit.bean.Fruit;
import fruit.dao.FruitDAO;
import fruit.dao.FruitDAOImpl;
import myssm.JDBCUtils;
import myssm.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/add.do")
public class AddServlet extends ViewBaseServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        //根据request参数创造fruit对象
        String fname = req.getParameter("fname");
        Integer price = Integer.parseInt(req.getParameter("price"));
        Integer fcount = Integer.parseInt(req.getParameter("fcount"));
        String remark = req.getParameter("remark");
        Fruit fruit = new Fruit(0, fname, price, fcount, remark);

        // 添加到数据库
        FruitDAO fruitDAO = new FruitDAOImpl();
        try {
            fruitDAO.addFruit(connection, fruit);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("/day2/client");
    }
}
