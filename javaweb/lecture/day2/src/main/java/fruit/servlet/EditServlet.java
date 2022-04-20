package fruit.servlet;

import fruit.bean.Fruit;
import fruit.dao.FruitDAO;
import fruit.dao.FruitDAOImpl;
import myssm.JDBCUtils;
import myssm.StringUtils;
import myssm.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/edit.do")
public class EditServlet extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取从request中发送的参数
        req.setCharacterEncoding("UTF-8");
        String fidStr = req.getParameter("fid");

        // 2.防止空指针异常 null pointer exception
        if(!StringUtils.isEmpty(fidStr)){
            // 3.获取单个fruit对象
            Integer fid = Integer.parseInt(fidStr);
            FruitDAO fruitDAO = new FruitDAOImpl();
            Fruit fruit = null;
            try {
                fruit = fruitDAO.getFruitById(connection, fid);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            req.setAttribute("fruit", fruit);
            processTemplate("edit", req, resp);
        }
    }
}
