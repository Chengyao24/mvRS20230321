
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("api")
  public class SecondRestApp extends Application {
     //未覆寫 Set<Class<?>> getClasses() 會掃描所也套件程式並匯入服務
  }
