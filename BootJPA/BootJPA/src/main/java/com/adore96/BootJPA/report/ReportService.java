package com.adore96.BootJPA.report;

import com.adore96.BootJPA.bean.DataBean;
import com.adore96.BootJPA.dao.StudentRepo;
import com.adore96.BootJPA.model.Roledetails;
import com.adore96.BootJPA.model.Users;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    StudentRepo studentRepo;

    public String ExportReport(String reporttype) throws FileNotFoundException, JRException {
        String path = "C:\\Users\\Kasun_k\\Desktop";

        File file = ResourceUtils.getFile("classpath:UserReport.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        List<Users> users = studentRepo.findAll();
        List<DataBean> dataBeans = new ArrayList<>();

        for (int i = 0; i < users.size(); i++) {
            DataBean dBean = new DataBean();
            dBean.setId(String.valueOf(users.get(i).getId()).trim());
            dBean.setFname(users.get(i).getFname().trim());
            dBean.setLname(users.get(i).getLname().trim());
            dBean.setUsername(users.get(i).getUsername().trim());
            dBean.setPassword(users.get(i).getPassword().trim());
            dBean.setTelephone(String.valueOf(users.get(i).getTelephone()).trim());

            Roledetails roledetails = users.get(i).getRoleid();
            dBean.setRoleid(roledetails.getRolename());

            dataBeans.add(dBean);
        }

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dataBeans);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("Created by ", "XYZ");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if (reporttype.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\students.html");
        }
        if (reporttype.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\students.pdf");
        }
        return "Report Generated.";
    }
}
