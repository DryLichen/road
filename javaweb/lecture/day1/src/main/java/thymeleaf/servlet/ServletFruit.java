package thymeleaf.servlet;

import thymeleaf.bean.Fruit;
import thymeleaf.dao.FruitDAO;
import thymeleaf.dao.FruitDAOImpl;
import thymeleaf.utils.JDBCUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletFruit", value = "/thTest")
public class ServletFruit extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取fruit的list
        FruitDAO fruitDAO = new FruitDAOImpl();
        List<Fruit> fruitList = null;
        try {
            fruitList = fruitDAO.getFruitList(JDBCUtils.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 2.将fruitList数据保存到session中
        HttpSession session = request.getSession();
        session.setAttribute("fruitList", fruitList);

        // 3.调用父类模板方法
        processTemplate("thTest", request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
