/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examsapp;

import Dao.DaoChapitres;
import Dao.DaoExamens;
import Dao.DaoQuestion;
import Model.Chapitres;
import Model.Examens;
import Model.Qcm;
import Model.Qroq;
import Model.Question;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author hajer
 */
public class ExportFiles {

    DaoChapitres daoChap = new DaoChapitres();
    DaoExamens daoExamens = new DaoExamens();
    DaoQuestion daoQst = new DaoQuestion();

    public void exporterQst() {
        List<Question> listQst = daoQst.getMyList();
        
        try {
            try (FileOutputStream fout = new FileOutputStream("/home/hajer/Documents/exportQst.txt")) {

                PrintWriter out = new PrintWriter(fout);
                for (Question qst : listQst) {
                    String line = "";
                    line = line + qst.getId() + ", " + qst.getEnonce() + "," + qst.getChap().getId();
                    if (qst.getQcm() != null) {
                        line = line + ", QCM, " + String.join(";", qst.getQcm().getPropositions());
                         
                        Boolean[] listProp = qst.getQcm().getProCorrect();
                        List<String> propC = new ArrayList();
                        if (listProp[0] == true) {
                            propC.add(qst.getQcm().getPropositions()[0]);
                        }
                        if (listProp[1] == true) {
                            propC.add(qst.getQcm().getPropositions()[1]);
                        }
                        if (listProp[2] == true) {
                            propC.add(qst.getQcm().getPropositions()[2]);
                        }
                        
                        line = line + ", " + String.join(";", propC);
                        
                    } else {

                        line = line + ", QROC, " + String.join(";", qst.getQroc().getMotcles());

                    }
                   
                    out.println(line);
                    out.flush();
                }
            }
            System.out.println("success...");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void exporterExam() {

        List<Examens> listExams = daoExamens.getMyList();

        try {
            FileOutputStream foutExams = new FileOutputStream("/home/hajer/Documents/exportExams.txt");
            PrintWriter out = new PrintWriter(foutExams);

            for (Examens exam : listExams) {
                String line = "";
                line = line + exam.getId() + ", " + exam.getDuree() + "," + exam.getNbQst();

                out.println(line);
                out.flush();
            }

            System.out.println("success...");

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void alimenter() {
        try {

            FileInputStream fin = new FileInputStream("/home/hajer/Documents/alimentation.txt");
           
            BufferedReader bf = new BufferedReader(new InputStreamReader(fin));
            while (bf.ready()) {
                String[] line = bf.readLine().trim().split(",");
                System.out.println(Arrays.toString(line));
                if (line.length >= 5) {
                    try {
                        Question qst = new Question(line[1].trim());
                        //qst.setChap(new Chapitres(Integer.parseInt(line[0].trim()), null));
                        qst.setChap(daoChap.find(Integer.parseInt(line[0])));
                        if (line[2].trim().equalsIgnoreCase("QCM")) {
                            String[] props = line[3].trim().split(";");
                            if (props.length == 3) {
                                Boolean[] proCorrect = {false, false, false};
                                String correct = line[4]; //String[] x = line[4].trim().split(";");
                                //if (x.length >= 1 && x.length <= 3)

                                int pos = Arrays.asList(props).indexOf(correct);
                                if (pos != -1) {
                                    proCorrect[pos] = true;
                                }

                                if (!Arrays.stream(proCorrect).allMatch((t) -> t == false)) {
                                    Qcm qcm = new Qcm(props, proCorrect);
                                    qst.setQcm(qcm);
                                }

                            }
                        }

                        if (line[2].trim().equalsIgnoreCase("QROC")) {

                            String[] motsCle = line[3].trim().split(";");
                            Qroq qroc = new Qroq(motsCle);
                            System.out.println(qroc);
                            qst.setQroc(qroc);
                        }
                        if (!line[5].trim().isEmpty()) {

                            System.out.println(Integer.parseInt(line[5].trim()));
                            qst.setIdExamen(Integer.parseInt(line[5].trim()));

                        }
                        

                        daoQst.add(qst);

                    } catch (NumberFormatException e) {
                    }
                }
            }
            bf.close();
            fin.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
