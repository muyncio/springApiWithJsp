package com.example.api.controller;

import com.example.api.database.utils.HibernateFactory;
import com.example.api.model.TestTable;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class TestTableController {

    @GetMapping({"/", "/hello"})
    public String hello (){
        return "index";
    }

    @GetMapping({"/table"})
    public String listTestTables( @RequestParam(value = "code", defaultValue = "bigos")String code, Model model){
        Session session = HibernateFactory.getInstance().getSessionFactory().getCurrentSession();
        Transaction tx = null;
        List<String> htmlList = new ArrayList<>();

        try {
            tx = session.beginTransaction();
            List employees = session.createQuery("FROM TestTable").list();
            for (Iterator iterator = employees.iterator(); iterator.hasNext();){
                TestTable testTable = (TestTable) iterator.next();
                htmlList.add("<tr> " +
                        "<td>" + testTable.getId() + "</td> " +
                        "<td>" + testTable.getKolumna1() + "</td> " +
                        "<td>" + testTable.getKolumna2() + "</td> " +
                        "<td>" + testTable.getKolumna3() + "</td> " +
                        "<td>" + testTable.getKolumna4() + "</td> " +
                        "</tr>");
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        htmlList.add("</tbody>");

        String records = htmlList.toString();

        model.addAttribute("code", records);
        return "table";
    }
    @GetMapping({"/tablewithdifferent"})
    public String listTestTablesWitchTheSameVariables( @RequestParam(value = "code", defaultValue = "bigos")String code, Model model){
        Session session = HibernateFactory.getInstance().getSessionFactory().getCurrentSession();
        Transaction tx = null;
        List<String> htmlList = new ArrayList<>();

        try {
            tx = session.beginTransaction();
            List employees = session.createQuery("FROM TestTable ").list();
            for (Iterator iterator = employees.iterator(); iterator.hasNext();){
                TestTable testTable = (TestTable) iterator.next();
                htmlList.add("<tr> " +
                        "<td>" + testTable.getId() + "</td> " +
                        "<td>" + testTable.getKolumna1() + "</td> " +
                        "<td>" + testTable.getKolumna2() + "</td> " +
                        "<td>" + testTable.getKolumna3() + "</td> " +
                        "<td>" + testTable.getKolumna4() + "</td> " +
                        "</tr>");
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        htmlList.add("</tbody>");

        String records = htmlList.toString();

        model.addAttribute("code", records);
        return "tablewithdifferent";
    }
    @GetMapping({"/tablewiththesame"})
    public String listTestTablesWithTheSameVariables( @RequestParam(value = "code", defaultValue = "bigos")String code, Model model){
        Session session = HibernateFactory.getInstance().getSessionFactory().getCurrentSession();
        Transaction tx = null;
        List<String> htmlList = new ArrayList<>();

        try {
            tx = session.beginTransaction();
            List employees = session.createQuery("FROM TestTable").list();
            for (Iterator iterator = employees.iterator(); iterator.hasNext();){
                TestTable testTable = (TestTable) iterator.next();
                htmlList.add("<tr> " +
                        "<td>" + testTable.getId() + "</td> " +
                        "<td>" + testTable.getKolumna1() + "</td> " +
                        "<td>" + testTable.getKolumna2() + "</td> " +
                        "<td>" + testTable.getKolumna3() + "</td> " +
                        "<td>" + testTable.getKolumna4() + "</td> " +
                        "</tr>");
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        htmlList.add("</tbody>");

        String records = htmlList.toString();

        model.addAttribute("code", records);
        return "tablewiththesame";
    }

}
