package com.seloger.propertyPart.property;

import com.seloger.propertyPart.patterns.BucketHandlerInterface;
import com.seloger.propertyPart.patterns.chain.IChain;
import com.seloger.propertyPart.property.Handler.PropertyHandler;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class PropertyService {
private final IChain<PropertyAnnonce> propertyAnnonceIChain;
private final PropertyHandlerInterface propertyHandler;
private final BucketHandlerInterface bucketHandler;

@Transactional
   public void process(PropertyAnnonce propertyAnnonce){
      log.info("PROPERTY SERVICE");
       System.out.println(propertyAnnonce);
       propertyAnnonceIChain.handle(propertyAnnonce);
   }
    public void process2(PropertyAnnonce propertyAnnonce){
        propertyAnnonceIChain.handleTwo(propertyAnnonce);
    }

   public List<PropertyResponse> getPropertiesByAgenceId(){
      return propertyHandler.getPropertiesByAgenceId();
   }


public List<PropertyResponse> getAllProperties(){
       return propertyHandler.getAllProperties();
}


}
