
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hi")
public class HelloWorldRestService {

    @GET //直接執行get方法
    @Produces(MediaType.TEXT_HTML + ";charset=UTF-8") //可以改成TEXT_HTML
    public String getHelloMessage(){
        return "<h1>Hi 您好!</h1>";
    }
}
