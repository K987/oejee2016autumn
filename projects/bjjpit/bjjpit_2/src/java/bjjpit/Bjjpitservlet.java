package bjjpit;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nut
 */
@WebServlet(name = "Bjjpitservlet", urlPatterns = {"/bjjpeople"})

public class Bjjpitservlet extends HttpServlet {
    
    
    BjjpeopleService bjjpeopleservice = new BjjpeopleService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("searchAction");
        if (action!=null){
            switch (action) {           
            case "searchById":
                searchEmployeeById(req, resp);
                break;           
            case "searchByName":
                searchEmployeeByName(req, resp);
                break;
            }
        }else{
            List<people> listofppl = bjjpeopleservice.bjjppllist();
            forwardListEmployees(req, resp, listofppl);
        }
    }

    private void searchEmployeeById(HttpServletRequest req, HttpServletResponse resp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void searchEmployeeByName(HttpServletRequest req, HttpServletResponse resp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void forwardListEmployees(HttpServletRequest req, HttpServletResponse resp, List bjjpeopleList)
            throws ServletException, IOException {
        String nextJSP = "/jsp/ppl_list.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        req.setAttribute("bjjpeopleList", bjjpeopleList);
        dispatcher.forward(req, resp);
    }   


}
