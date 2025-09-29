package ComplexHashMap;

import java.util.HashMap;

public class Options {
    
    String text;
    int index;
    int nextIndex;
    
    public Options(String text, int index, int nextIndex){
        this.text = text;
        this.index = index;
        this.nextIndex = nextIndex;
       
    }

    public String getText(){
        return text;
    }

    public int getIndex(){
        
        return index;
    }
    
    public int getNextIndex(){
        return nextIndex;
    }
    
}
