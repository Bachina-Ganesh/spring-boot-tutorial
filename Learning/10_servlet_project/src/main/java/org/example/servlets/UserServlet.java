package org.example.servlets;

import org.example.model.User;
import org.example.repository.UserRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    private final UserRepository userRepository;

    public UserServlet() {
        userRepository = new UserRepository();
    }

    @Override
    public void init() {
        System.out.println("UserServlet has been initialized");
    }

    @Override
    public void destroy() {
        System.out.println("UserServlet has been destroyed");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        Integer age = Integer.valueOf(req.getParameter("age"));

        User user = new User(id, name, email, age);
        String message = userRepository.createUser(user);
        resp.setStatus(HttpServletResponse.SC_CREATED);
        resp.setContentType("application/json");
        resp.getWriter().write("{\n"+"message: "+message+"\n"+"}");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id =  req.getParameter("id");
        if(id == null) {
            // fetch all the users
            List<User> users = userRepository.getAllUsers();
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for(int i=0; i<users.size(); i++) {
                sb.append(userToJson(users.get(i)));
                if(i != users.size()-1) {
                    sb.append(",");
                }
            }
            sb.append("]");
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().write(sb.toString());
        }
        else {
//            fetch specific user
            User user = userRepository.getUserById(Integer.parseInt(id));
            resp.setContentType("application/json");
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().write(userToJson(user));
        }
    }

    private String userToJson(User user) {
        return "{\n" + "id : "+user.getId()+",\n"+"name : "+user.getName()+", \n" + "email : "+user.getEmail()+",\n"+"age : "+user.getAge()+"\n"+"}";
    }
}
