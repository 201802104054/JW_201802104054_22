package cn.edu.sdjzu.xg.bysj.controller.basic.school;

import cn.edu.sdjzu.xg.bysj.service.SchoolService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

//@WebServlet("/school_json/delete.ctl")
public class DeleteSchoolControl_bak extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        try{String id_str = request.getParameter("id");
            int id = Integer.parseInt(id_str);
            String result = SchoolService.getInstance().delete(id);
            System.out.println("delete doGet");
            if(result.equals("DELETED")){
                System.out.println("DELETED");
                response.sendRedirect("/school_json/list.ctl");}
            else {
                System.out.println("Cannot delete");

                System.out.println(result);

                response.getWriter().println(result);}
        }catch (SQLException e){
            e.getStackTrace();
        }


//            response.getWriter().flush();

//        response.sendRedirect(WebHelper.getContextPath(request)+"/school_json/list.ctl");
    }
}
