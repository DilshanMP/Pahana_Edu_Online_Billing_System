package com.dilshanmp.pahana_edu.controller;

import com.dilshanmp.pahana_edu.service.BillService;
import com.dilshanmp.pahana_edu.service.CustomerService;
import com.dilshanmp.pahana_edu.service.ItemService;
import com.dilshanmp.pahana_edu.service.impl.BillServiceImpl;
import com.dilshanmp.pahana_edu.service.impl.CustomerServiceImpl;
import com.dilshanmp.pahana_edu.service.impl.ItemServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
@WebServlet(name = "DashboardServlet", urlPatterns = {"/dashboard", "/"})
public class DashboardServlet extends HttpServlet {

    private CustomerService customerService;
    private ItemService itemService;
    private BillService billService;

    @Override
    public void init() throws ServletException {
        super.init();
        customerService = new CustomerServiceImpl();
        itemService = new ItemServiceImpl();
        billService = new BillServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // Get summary statistics
            int totalCustomers = customerService.getTotalCustomers();
            int totalItems = itemService.findAll().size();
            int totalBills = billService.findAll().size();
            double totalRevenue = billService.calculateTotalRevenue();

            // Get sales summary
            Map<String, Object> salesSummary = billService.getSalesSummary();

            // Get low stock items
            int lowStockCount = itemService.getLowStockItems().size();

            // Set attributes
            request.setAttribute("totalCustomers", totalCustomers);
            request.setAttribute("totalItems", totalItems);
            request.setAttribute("totalBills", totalBills);
            request.setAttribute("totalRevenue", totalRevenue);
            request.setAttribute("salesSummary", salesSummary);
            request.setAttribute("lowStockCount", lowStockCount);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error loading dashboard data: " + e.getMessage());
        }

        // Forward to dashboard page
        request.getRequestDispatcher("/jsp/dashboard.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
