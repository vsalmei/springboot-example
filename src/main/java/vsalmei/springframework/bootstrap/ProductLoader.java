package vsalmei.springframework.bootstrap;

import vsalmei.springframework.domain.Product;
import vsalmei.springframework.repositories.ProductRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ProductRepository productRepository;

    private Logger log = LogManager.getLogger(ProductLoader.class);

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Product course = new Product();
        course.setDescription("Jira Course");
        course.setPrice(new BigDecimal("200"));
        course.setImageUrl("https://www.e-core.com/wp-content/uploads/2018/11/pagina_treinamento-05-300x300.png");
        course.setProductId("235268845711068308");
        productRepository.save(course);

        log.info("Saved Course - id: " + course.getId());

        Product consulting = new Product();
        consulting.setDescription("Consulting Jira");
        consulting.setImageUrl("https://www.e-core.com/wp-content/uploads/2018/05/Platinum-Solution-Partner-Enterprise-01.png");
        consulting.setProductId("168639393495335947");
        consulting.setPrice(new BigDecimal("1000"));
        productRepository.save(consulting);

        log.info("Saved Consulting - id:" + consulting.getId());
    }
}
