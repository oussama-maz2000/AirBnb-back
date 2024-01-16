package com.seloger.propertyPart.property;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seloger.propertyPart.property.Handler.ImagesHandler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(value = "/api/annonce")
@AllArgsConstructor
@Slf4j
public class PropertyResource {
    private final ObjectMapper objectMapper;
    private final PropertyService propertyService;
    private final ImagesHandler imagesHandler;


    @PostMapping(value = "add", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> handlePropertyData(
            @RequestParam("property") String property,
            @RequestPart(value = "images") List<MultipartFile> images) {

        try {
            PropertyAnnonce propertyAnnonce =  PropertyAnnonce.builder().
                    propertyRequest(objectMapper.readValue(property, PropertyRequest.class)).
                    imagesPhysique(images).build();
            System.out.println(propertyAnnonce);
           propertyService.process(propertyAnnonce);
            return ResponseEntity.status(HttpStatus.OK).body("data received");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }




    @GetMapping(value = "get-properties" , produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<PropertyResponse>> getPropertiesByAgence(){
       List<PropertyResponse> propertyResourceList= propertyService.getPropertiesByAgenceId();
        return ResponseEntity.status(HttpStatus.OK).body(propertyResourceList);
    }



    @GetMapping(value = "get-all-annonces",produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<PropertyResponse> getAllAnnonce(){
return propertyService.getAllProperties();
    }


    @PutMapping(value = "modifie-propertie", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> updateProperty(
            @RequestParam("property") String property,
            @RequestPart(value = "images",required = false) List<MultipartFile> images,
            @RequestParam(value = "pathsDeleted",required = false) List<String> pathsDeleted
            ) {
        try {
            PropertyAnnonce propertyAnnonce =  PropertyAnnonce.builder().
                    propertyRequest(objectMapper.readValue(property, PropertyRequest.class)).
                    linksDeleted(pathsDeleted).
                    imagesPhysique(images).build();
            System.out.println(propertyAnnonce.getPropertyRequest());
            System.out.println(propertyAnnonce);
           /* propertyService.process2(propertyAnnonce);*/


            return ResponseEntity.status(HttpStatus.OK).body("data received");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
