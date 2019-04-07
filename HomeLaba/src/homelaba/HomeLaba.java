
package homelaba;

import java.util.Comparator;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
import java.text.ParseException;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileWriter;
import java.util.regex.Pattern;
import java.util.Iterator;
import java.time.LocalTime;
import java.util.InputMismatchException;
public class HomeLaba {
    
    public static void and_5_func(ArrayList<Train> t1,ArrayList<Train> t2,String Incoooming) {

            Collections.copy(t1, t2);
            Iterator<Train> TU_TU = t2.iterator();
            while (TU_TU.hasNext()) {                    
                if (!Incoooming.equals(TU_TU.next().Where_I_come())){
                    TU_TU.remove();
                }
            }
    }
    public static void Check_connection(ArrayList<Train> t,String from,String To, boolean f){
        int crack_1;
        int crack_2;
        for (crack_1 = 0; crack_1<t.size()-1;crack_1++){
            for (crack_2 = 0; crack_2<t.size()-1;crack_2++){
                if (t.get(crack_1).Finish().isBefore(t.get(crack_2).Start()) && crack_2 != crack_1 && t.get(crack_1).What_the().equals(from) && t.get(crack_2).Where_I_come().equals(To) && t.get(crack_2).What_the().equals(t.get(crack_1).Where_I_come())){
                    System.out.println("You can use " + t.get(crack_1).What_the_train_str() + " then move on " + t.get(crack_2).What_the_train_str() + "\r\n");
                    f = true;
                }
            }
        }
    }
    
    public static void create(ArrayList<Train> z,String s1, String s2, String s3, String s4, String s5, String s6, int m){
        if (s4.matches("[0-2][0-9]:[0-6][0-9]") && s5.matches("[0-2][0-9]:[0-6][0-9]"))
        {   
            String[] res1 = new String[2];
            String[] res2 = new String[2];
            int a = 0;
            int b = 0;
            for (String regex:s4.split(":")){
                res1[a] = regex;
                a++;
            }
            
            for (String regex:s5.split(":")){
                res2[b] = regex;
                b++;
            }
            LocalTime t1 = LocalTime.of(Integer.parseInt(res1[0]), Integer.parseInt(res1[1]));
            LocalTime t2 = LocalTime.of(Integer.parseInt(res2[0]), Integer.parseInt(res2[1]));
            Train t = new Train(s1, s2, s3, t1, t2, Double.parseDouble(s6));
            m++;
            z.add(m-1,t);
        } else {
            System.out.println("Wrong time format");//Найти исключение и запхать его в main
        }
    }
    
    
    
    @SuppressWarnings({"SuspiciousIndentAfterControlStatement", "SleepWhileInLoop", "ConvertToTryWithResources"})
    public static void main(String[] args) throws ParseException, FileNotFoundException, IOException
    {   
        Comparator<Train> Compar1 = Comparator.comparing(Train -> Train.What_the());
        Comparator<Train> Compar2 = Comparator.comparing(Train -> Train.What_the());
        Comparator<Train> ABC = Comparator.comparing(Train->Train.toString());
        Compar1 = Compar1.thenComparing(Train -> Train.Time_end());
        Compar2 = Compar2.thenComparing(Train -> Train.Where_I_come());
        System.out.print("Initializing");
        for (int time_break = 0; time_break<3; time_break++) {
            System.out.print(".");
            try {
                Thread.sleep(1000);
            } 
            catch (InterruptedException e) {
                System.err.println(e.getMessage()); 
            }
        }
        
        System.out.println(" ");
        System.out.println("Test system launched. Welcome!");
        String s = "";
        String path = "Trains"; //путь до файла
        File sourse = new File(path);
        String Work_to;
        ArrayList<Train> TrrT = new ArrayList<Train>();
        String[] Going_to = new String[6];
        int m = 0;
        if (sourse.exists() && sourse.isFile()) {
            Scanner in = new Scanner(new File(path));
            while (in.hasNext())
            {   
                Work_to = in.nextLine();
                s += Work_to + "\r\n";
                int index_split = 0;
                for (String retval : Work_to.split(" ")) {
                    Going_to[index_split] = retval;
                    index_split++;
                }
                create(TrrT, Going_to[0], Going_to[1], Going_to[2], Going_to[3], Going_to[4], Going_to[5], m);
                }
            
        in.close();
        }
        else 
        {
            System.out.print("File didn't found!!!");
        }
        System.out.println("Info you have on the File:");
        System.out.print(s);
        int infi = 10;
        Scanner sc = new Scanner(System.in);
        while (infi == 10){
        System.out.println("What you whant to do?" + "\r\n" + "1 - add a train" + "\r\n" + "2 - delete a train" + "\r\n" + "3 - go for  trip" + "\r\n" + "4 - look, how to get out of a city and when" + "\r\n" + "5 - A-B all trains" + "\r\n" + "6-exit");
        try{
        int change = sc.nextInt();
        String v = sc.nextLine();
        switch (change){
            case 1:
                System.out.print("Type information in next order with Space:'№ of train \r\n departure point \r\n arrival point \r\n departure time \r\n arrival time \r\n ticket cost \r\n");
                String Work = sc.nextLine();
                int index_sp = 0;
                for (String retval : Work.split(" ")) {
                    Going_to[index_sp] = retval;
                    index_sp++;
                }
                create(TrrT, Going_to[0], Going_to[1], Going_to[2], Going_to[3], Going_to[4], Going_to[5], m);
                break;
            case 2:
                System.out.println("Type № of train you want to delete?");
                String paths = sc.nextLine();
                for (int abz =0; abz < m ; abz++){
                    String WTT_S = TrrT.get(abz).What_the_train_str();
                    if(Pattern.matches(WTT_S, paths)){
                        TrrT.remove(abz);
                    }
                }
                break;
            case 3:
                System.out.println("Where you want to go?");
                String To_come = sc.nextLine();
                System.out.println("Where you now?");
                String Start_here = sc.nextLine();
                boolean f = false;
                for (int index_1 = 0; index_1<TrrT.size()-1; index_1++){
                    if (TrrT.get(index_1).What_the().equals(Start_here) && TrrT.get(index_1).Where_I_come().equals(To_come))
                    {
                        System.out.println("You should try " + TrrT.get(index_1).What_the_train_int() + "\r\n");
                        f = true;
                    }
                }
                if (f = false){
                    Check_connection(TrrT, Start_here, To_come, f);
                }
                if (f = false){
                    System.out.println("Sorry, you cant reach this sity");
                }
                
                break;
            case 4: 
                System.out.println("Where are you now?");
                String Incoooming = sc.nextLine();
                ArrayList<Train> TrrT2 = new ArrayList<Train>();
                and_5_func(TrrT, TrrT2, Incoooming);
                Collections.sort(TrrT2, Compar1);
                break;
            case 5:
                System.out.println("Where are you now?");
                String Incoooming1 = sc.nextLine();
                ArrayList<Train> TrrT3 = new ArrayList<Train>();
                and_5_func(TrrT, TrrT3, Incoooming1);
                Collections.sort(TrrT3, Compar2);
                break;
            case 6:
                File newf = new File("Trains2");
                try(FileWriter FL = new FileWriter("Trains2", false)){
                for (int aa = 0; aa<TrrT.size()-1; aa++){
                    String text = TrrT.get(aa).toString();
                    FL.write(text);
                }
                FL.close();
                sourse.delete();
                newf.renameTo(sourse);
                } catch(IOException e){
                    System.out.println(e.getMessage());
                }
                System.exit(0);
                sc.close();
                break;
            }
        
    }
         catch(InputMismatchException ess){
                System.out.println("Error! Wrong number");
                }
        }
        
    }
}
