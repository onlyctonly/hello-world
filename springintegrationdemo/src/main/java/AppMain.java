import com.bashfan.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    }
}
