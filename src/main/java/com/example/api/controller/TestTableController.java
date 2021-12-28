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
            List values = session.createQuery("select t2.id, t2.kolumna1, t2.kolumna2, t2.kolumna3, t2.kolumna4 from TestTable t1\n" +
                    "join TestTable t2 on t2.kolumna1 not in (t1.kolumna1, t1.kolumna2, t1.kolumna3) \n" +
                    "and t2.kolumna2 not in (t1.kolumna1, t1.kolumna2, t1.kolumna3) \n" +
                    "and t2.kolumna3 not in (t1.kolumna1, t1.kolumna2, t1.kolumna3) \n" +
                    "where t1.id = 1").list();
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
            List values = session.createQuery("select t2.id, t2.kolumna1, t2.kolumna2, t2.kolumna3, t2.kolumna4 from TestTable t1\n" +
                    "join TestTable t2 on t2.kolumna1 in (t1.kolumna1, t1.kolumna2, t1.kolumna3) \n" +
                    "and t2.kolumna2 in (t1.kolumna1, t1.kolumna2, t1.kolumna3) \n" +
                    "and t2.kolumna3 in (t1.kolumna1, t1.kolumna2, t1.kolumna3) \n" +
                    "where t1.id = 1").list();
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
