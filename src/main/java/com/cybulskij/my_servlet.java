package com.cybulskij;

import com.cybulskij.Dao.User;
import com.cybulskij.Dao.UserDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.omg.DynamicAny._DynAnyFactoryStub;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: NAZAR
 * Date: 03/11/13
 * Time: 11:25
 * To change this template use File | Settings | File Templates.
 */
public class my_servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       /* req.setCharacterEncoding("Cp1251");



        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();


        Gson gson=new GsonBuilder().create();
        try {
            out.println(gson.toJson(new UserDao().selectAll()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
           */
       String lastname=req.getParameter("lastname");
        System.out.println(req.getParameter("lastname"));
       String firstname=req.getParameter("firstname");
        System.out.println(req.getParameter("firstname"));
        try {
            new  UserDao().Insert(new User(lastname,firstname));
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        //System.out.println(lastname+" "+firstname);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doPost(req, resp);

        req.setCharacterEncoding("Cp1251");



        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();


        Gson gson=new GsonBuilder().create();
        try {
            out.println(gson.toJson(new UserDao().selectAll()));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
