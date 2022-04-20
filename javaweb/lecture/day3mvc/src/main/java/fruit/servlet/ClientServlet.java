package fruit.servlet;

import fruit.bean.Fruit;
import fruit.dao.FruitDAO;
import fruit.dao.FruitDAOImpl;
import myssm.StringUtils;
import myssm.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/client")
public class ClientServlet extends ViewBaseServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();

        // 判断是否为关键词搜索
        String keySearch = req.getParameter("keySearch");
        String keyword = req.getParameter("keyword");

        if("true".equals(keySearch)){
            Integer pageNo = 1;

        }


        // 1.获取请求页数
        Integer pageNo = 1;
        String pageNoStr = req.getParameter("pageNo");
        if(!StringUtils.isEmpty(pageNoStr)){
            pageNo = Integer.parseInt(pageNoStr);
        }

        // 2.查询指定页码数据
        FruitDAO fruitDAO = new FruitDAOImpl();
        List<Fruit> fruitList = null;
        try {
            fruitList = fruitDAO.getFruitList(connection, pageNo, );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 3.获取总页数
        int pageCount = 1;
        try {
            int number = fruitDAO.getTotalCount(connection, );
            pageCount = (number+5-1)/5;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        session.setAttribute("fruitList", fruitList);
        session.setAttribute("pageCount", pageCount);
        session.setAttribute("pageNo", pageNo);

        processTemplate("client", req, resp);
    }
}
