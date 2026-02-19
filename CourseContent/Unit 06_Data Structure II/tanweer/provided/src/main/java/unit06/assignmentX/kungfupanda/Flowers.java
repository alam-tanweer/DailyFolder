//Kung Fu Panda Exercise -- 5.1
package unit06.assignmentX.kungfupanda;

public class Flowers{
    public final String name;
    public Flowers(){ this("Tulips and Dahlias"); }
    public Flowers(String s){
        name = s;
    }
   @Override
    public String toString(){
        
        return name+"\n\n"+"No damage done, all nearby violence pacified..";
    }
}
