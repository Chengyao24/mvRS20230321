import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
public class MyTest {

    @GET
    @Produces(MediaType.TEXT_HTML + ";charset=UTF-8")
    public String getHelloMessage(){
        return "<h1>Test 您好!</h1>";
    }
}
