package edu.maor.bank;

import java.io.*;

import edu.maor.bank.domain.Account;
import edu.maor.bank.domain.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "ActionMyBankRegister", value = "/ActionMyBankRegister")
public class ActionMyBankRegister extends HttpServlet {

    public void init() throws ServletException {
        BankApp.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        int mount = Integer.parseInt(req.getParameter("mount"));

        Client client = new Client(id, name, email, country);
        Account account = new Account(id, mount);

        BankApp.clientDao.post(client);
        BankApp.accountDAO.post(account);
    }
}