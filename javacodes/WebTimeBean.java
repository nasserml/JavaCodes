package webtime;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.text.DateFormat;
import java.util.Date;


@ManagedBean (name = "webTimeBean")
@RequestScoped
public class WebTimeBean {

    // return the time on the server at which the request was received
    public String getTime(){
        return DateFormat.getTimeInstance(DateFormat.LONG).format(new Date());
    }
    public WebTimeBean() {
    }
    
}
