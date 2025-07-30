package com.dilshanmp.pahana_edu.controller.features;

import com.dilshanmp.pahana_edu.model.Bill;
import com.dilshanmp.pahana_edu.model.BillItem;
import com.dilshanmp.pahana_edu.model.Customer;
import com.dilshanmp.pahana_edu.model.Item;
import com.dilshanmp.pahana_edu.service.*;
import com.dilshanmp.pahana_edu.service.EmailService;
import com.dilshanmp.pahana_edu.service.ExcelExportService;
import com.dilshanmp.pahana_edu.service.impl.BillServiceImpl;
import com.dilshanmp.pahana_edu.service.impl.CustomerServiceImpl;
import com.dilshanmp.pahana_edu.service.impl.ItemServiceImpl;
import com.dilshanmp.pahana_edu.util.PDFGenerator;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@WebServlet(name = "ExportServlet", urlPatterns = {"/export"})
public class ExportServlet extends HttpServlet {

    private CustomerService customerService;
    private ItemService itemService;
    private BillService billService;
    private EmailService emailService;

    @Override
    public void init() throws ServletException {
        super.init();
        customerService = new CustomerServiceImpl();
        itemService = new ItemServiceImpl();
        billService = new BillServiceImpl();
        emailService = new EmailService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String type = request.getParameter("type");
        String format = request.getParameter("format");

        try {
            if ("pdf".equalsIgnoreCase(format)) {
                handlePDFExport(type, request, response);
            } else if ("excel".equalsIgnoreCase(format)) {
                handleExcelExport(type, request, response);
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid format");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    private void handlePDFExport(String type, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {

        if ("bill".equalsIgnoreCase(type)) {
            // Export single bill as PDF
            int billId = Integer.parseInt(request.getParameter("id"));
            Bill bill = billService.findById(billId);

            if (bill != null) {
                // Load bill items
                List<BillItem> billItems = billService.getBillItems(billId);
                bill.setBillItems(billItems);

                // Generate PDF
                byte[] pdfBytes = PDFGenerator.generateBillPDF(bill);

                // Set response headers
                response.setContentType("application/pdf");
                response.setHeader("Content-Disposition",
                        "attachment; filename=Bill_" + bill.getBillNumber() + ".pdf");
                response.setContentLength(pdfBytes.length);

                // Write PDF to response
                OutputStream out = response.getOutputStream();
                out.write(pdfBytes);
                out.flush();

                // Optionally send email with PDF
                String sendEmail = request.getParameter("email");
                if ("true".equals(sendEmail) && bill.getCustomer().getEmail() != null) {
                    emailService.sendBillReceipt(bill, pdfBytes);
                }
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Bill not found");
            }
        }
    }

    private void handleExcelExport(String type, HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {

        byte[] excelBytes = null;
        String fileName = "";

        switch (type.toLowerCase()) {
            case "customers":
                List<Customer> customers = customerService.findAll();
                excelBytes = ExcelExportService.exportCustomers(customers);
                fileName = "Customers_Export.xlsx";
                break;

            case "items":
                List<Item> items = itemService.findAll();
                excelBytes = ExcelExportService.exportItems(items);
                fileName = "Inventory_Export.xlsx";
                break;

            case "sales":
                List<Bill> bills = billService.findAll();
                // Load bill items for each bill
                for (Bill bill : bills) {
                    List<BillItem> billItems = billService.getBillItems(bill.getId());
                    bill.setBillItems(billItems);
                }
                excelBytes = ExcelExportService.exportSalesReport(bills);
                fileName = "Sales_Report.xlsx";
                break;

            default:
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid export type");
                return;
        }

        if (excelBytes != null) {
            // Set response headers
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
            response.setContentLength(excelBytes.length);

            // Write Excel to response
            OutputStream out = response.getOutputStream();
            out.write(excelBytes);
            out.flush();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        try {
            if ("sendLowStockAlert".equals(action)) {
                // Send low stock alert email
                List<Item> lowStockItems = itemService.getLowStockItems();
                if (!lowStockItems.isEmpty()) {
                    String adminEmail = "admin@pahanaedu.com"; // Get from config
                    emailService.sendLowStockAlert(lowStockItems, adminEmail);
                    response.getWriter().write("Low stock alert sent successfully");
                } else {
                    response.getWriter().write("No low stock items found");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}