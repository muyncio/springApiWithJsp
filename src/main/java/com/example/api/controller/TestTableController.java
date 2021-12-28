package com.example.api.controller;

import com.example.api.database.utils.HibernateFactory;
import com.example.api.model.TestTable;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
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
    public String listTestTables( @RequestParam(value = "code", defaultValue = "brak")String code, Model model){
        Session session = HibernateFactory.getInstance().getSessionFactory().getCurrentSession();
        Transaction tx = null;
        List<String> htmlList = new ArrayList<>();

        try {
            tx = session.beginTransaction();
            List values = session.createQuery("FROM TestTable").list();
            for (Iterator iterator = values.iterator(); iterator.hasNext();){
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
    public String listTestTablesWitchTheSameVariables( @RequestParam(value = "code", defaultValue = "brak")String code, Model model){
        Session session = HibernateFactory.getInstance().getSessionFactory().getCurrentSession();
        Transaction tx = null;
        List<String> htmlList = new ArrayList<>();

        try {
            tx = session.beginTransaction();

            List values = session.createQuery("from TestTable where \n" +
                    "kolumna1 not in (select kolumna1 from TestTable where id = 1) \n" +
                    "and kolumna2 not in (select kolumna2 from TestTable where id = 1) \n" +
                    "and kolumna3 not in (select kolumna3 from TestTable where id = 1) \n" +
                    "and kolumna4 not in (select kolumna4 from TestTable where id = 1)").list();
            for (Iterator iterator = values.iterator(); iterator.hasNext();){
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
    public String listTestTablesWithTheSameVariables( @RequestParam(value = "code", defaultValue = "brak")String code, Model model){
        Session session = HibernateFactory.getInstance().getSessionFactory().getCurrentSession();
        Transaction tx = null;
        List<String> htmlList = new ArrayList<>();

        try {
            tx = session.beginTransaction();
            List values = session.createQuery("from TestTable where \n" +
                    "kolumna1 in (select kolumna1 from TestTable where id = 1) \n" +
                    "or kolumna2 in (select kolumna2 from TestTable where id = 1) \n" +
                    "or kolumna3 in (select kolumna3 from TestTable where id = 1) \n" +
                    "or kolumna4 in (select kolumna4 from TestTable where id = 1)").list();
            for (Iterator iterator = values.iterator(); iterator.hasNext();){
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
