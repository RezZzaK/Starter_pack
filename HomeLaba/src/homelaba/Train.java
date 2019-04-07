package homelaba;
import java.time.LocalTime;


public class Train{
    private String Train_name;
    private String Start_point;
    private String Finish_point;
    private LocalTime Train_time_arr;
    private LocalTime Train_time_dep;
    private Double Ticket_cost;
    
    public Train(String Train_name, String Start_point, String Finish_point, LocalTime Train_time_arr, LocalTime Train_time_dep, Double Ticket_cost){
        this.Train_name = Train_name;
        this.Train_time_arr = Train_time_arr;
        this.Train_time_dep = Train_time_dep;
        this.Start_point = Start_point;
        this.Finish_point = Finish_point;   
        this.Ticket_cost = Ticket_cost;
    }
    
    public String What_the_train_str(){
        return Train_name;
    }
    
    public int What_the_train_int(){
        return Integer.parseInt(Train_name);
    }
    
    public String What_the(){
        return Start_point;
    }
    
    public String Where_I_come(){
        return Finish_point;
    }
    public LocalTime Start(){
        return Train_time_dep;
    }
    public LocalTime Finish(){
        return Train_time_arr;
    }
    
    public double Costly(){
        return Ticket_cost;
    }
    
    
    
    public int Time_end()throws IndexOutOfBoundsException{
        String[] tm = new String[1];
        int i = 0;
        for (String retval:Train_time_dep.toString().split(" ")){
            tm[i] = retval;
            i++;
        }
        int s = Integer.parseInt(tm[0])*100 + Integer.parseInt(tm[1]);
        return s;
    }
    
    public int Time_st()throws IndexOutOfBoundsException{
        String[] tm = new String[1]; 
        int i = 0;
        for (String retval:Train_time_arr.toString().split(" ")){
            tm[i] = retval;
            i++;
            
        }
        int s = Integer.parseInt(tm[0])*100 + Integer.parseInt(tm[1]);
        return s;
    }
    @Override
    public String toString(){
        return What_the_train_str()+" "+Start_point+" "+Finish_point+" "+Train_time_dep+" "+Train_time_arr+" "+Ticket_cost+"\r\n";
    }
    
}