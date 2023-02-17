package sessiontracking;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean( name="SelectionsBean")
@SessionScoped
public class SelectionsBean implements Serializable {
    // map of topics book titles
    private static final HashMap< String, String> booksMap =
            new HashMap< String, String>();
    
    // initialize booksMap
    static {
        booksMap.put("java", "Java How to Program" );
        booksMap.put("cpp", "C++ How to Program");
        booksMap.put("iphone",
                "iPhone for Programmers: An App-Driven Approach");
        booksMap.put("andriod",
                "Andriod for Programers: An App-Driven Approach"); 
    }
    // stores individual user's selections
    private Set< String > selections = new TreeSet< String >();
    private String selection; // stores the current selection
    
    // return number of selections
    public int getNumberOfSelections() {
        return selections.size();
    }
    
    // return the current selection
    public String getSelection() {
    return selection;
    }
    
    // store user's selection
    public void setSelection( String topic ){
        selection = booksMap.get( topic );
        selections.add( selection );
    } 
    
    // return the Set of selections
    public String[] getSelections() {
        return selections.toArray( new String [ selections.size() ]);
    }
   
    
}
