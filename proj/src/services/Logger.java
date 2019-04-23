package services;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Logger {
    static private Logger logger;
    private DataOutputStream dataOutputStream;
    private Logger(){
        try{
        dataOutputStream=new DataOutputStream(new FileOutputStream("./log.txt",true));
    }catch(FileNotFoundException e){
            try {
                File file = new File("./log.txt");
                boolean scapa_de_eroare=file.createNewFile();
                dataOutputStream = new DataOutputStream(new FileOutputStream("./log.txt", true));
            }
            catch (Exception exc){
                System.out.println("CEVA A MERS FOARTE PROST\n");
            }
        }

    }
    public static Logger getInstance(){
        if(logger==null){
            logger=new Logger();
        }
        return logger;
    }
    public void add(String mesaj){
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
        try{
        dataOutputStream.writeBytes(timeStamp+" "+mesaj);
    }
    catch (IOException io){
        System.out.println("CEVA A MERS PROST");
    }
    }

}
