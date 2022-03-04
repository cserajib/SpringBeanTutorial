package com.check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BeanCreationApplication {

@Autowired
AdditionService a;
	
@Bean
public ArithematicServiceProvider serviceProvider() {
 
    return new ArithematicServiceProvider() ;
}

@Bean
public RootOrSquare rootOrSquare() {
 
    return new RootOrSquare() ;
}



 public static void main(String[] args) {
  SpringApplication.run(BeanCreationApplication.class, args);
 }
 
 @GetMapping("/add")
 public int add() {
	 
	 System.out.println("here addition is..."+a.makeAddition(10,15));
	 return a.makeAddition(10,15);
 }
 
 @GetMapping("/service")
 public ServiceEntity operation() {
	 
	 ServiceEntity entity = new ServiceEntity();
	 System.out.println("here addition value..."+serviceProvider().makeAddition(10,17));
	 System.out.println("here multiplication value..."+serviceProvider().makeMultiplication(10,17));
	 entity.setAddValue(serviceProvider().makeAddition(10,17));
	 entity.setDivValue(serviceProvider().makeDivision(10,2));
	 
	 return entity;
 }
 
 @GetMapping(path = "/service/{param1}/{param2}")
 public ServiceEntity operation1(@PathVariable("param1") Integer value1,@PathVariable("param2") Integer value2) {
	 
	 
	 ServiceEntity entity = new ServiceEntity();
	 System.out.println("here addition value ...>>>"+serviceProvider().makeAddition(value1,value2));
	 System.out.println("here multiplication value...>>>"+serviceProvider().makeMultiplication(value1,value2));
	 entity.setAddValue(serviceProvider().makeAddition(value1,value2));
	 entity.setMulValue(serviceProvider().makeMultiplication(value1,value2));
	 entity.setDivValue(serviceProvider().makeDivision(value1,value2));
	 
	 return entity;
 }
 
 @GetMapping(path = "/service/{param1}")
 public int getSquare(@PathVariable("param1") Integer value1
		 ,@RequestParam(name="opType", required =false , defaultValue = "root") String opType) {
	 
	 
	 ServiceEntity entity = new ServiceEntity();
	 System.out.println("here addition value ...>>>"+rootOrSquare().getRoot(value1));
	 System.out.println("here multiplication value...>>>"+rootOrSquare().getSquare(value1));
	 
	 if(opType.equals("root"))
	     return rootOrSquare().getRoot(value1);
	 else
		 return rootOrSquare().getSquare(value1);
 }

}