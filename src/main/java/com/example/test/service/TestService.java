package com.example.test.service;

import com.example.test.model.TestModel;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TestService {
    public String printPDF(TestModel latarWaktu) throws JRException {
        Map<String,Object> params = new HashMap<String, Object>();
        Date now = new Date();
        SimpleDateFormat date = new SimpleDateFormat("dd MMM yyyy");
        String now1 = date.format(now);

        String reportPath = "C:\\PDFS\\";
        JasperReport jasperReport = JasperCompileManager
                .compileReport(reportPath + "greetings.jrxml");
        params.put("tanggal",now1);
        params.put("latar_waktu",latarWaktu.getLatar_waktu());
        JasperPrint testPrint = JasperFillManager.fillReport(jasperReport, params,new JREmptyDataSource());

        JasperExportManager.exportReportToPdfFile(testPrint, reportPath + "Greetings "+now1+".pdf");
        return "Success Generated";
    }
}
