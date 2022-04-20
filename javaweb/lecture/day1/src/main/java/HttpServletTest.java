import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "HttpServletTest", value = "/HttpST")
public class HttpServletTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("尼玛");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("doGet method processed 好的");

        //获取请求的form值
        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<String> keySet = parameterMap.keySet();
        for(String key : keySet){
            String[] values = parameterMap.get(key);
            System.out.println(key + "=" + Arrays.asList(values));
        }

        String seasonValues = req.getParameter("season");
        System.out.println("season = " + Arrays.asList(seasonValues));

        String[] teamValues = req.getParameterValues("team");
        System.out.println("team = " + Arrays.asList(teamValues));

    }
}
