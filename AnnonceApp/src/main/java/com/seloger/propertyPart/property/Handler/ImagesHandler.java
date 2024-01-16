package com.seloger.propertyPart.property.Handler;

import com.seloger.propertyPart.exception.GlobalException;
import com.seloger.propertyPart.patterns.BucketHandlerInterface;
import com.seloger.propertyPart.patterns.chain.Handler;
import com.seloger.propertyPart.property.PropertyAnnonce;
import com.seloger.propertyPart.supabase.FeignResource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Component
@Slf4j
@RequiredArgsConstructor
@Order(1)
public class ImagesHandler implements Handler<PropertyAnnonce>, BucketHandlerInterface {

    private final FeignResource feignResource;

    @Value("${SUPABASE_BEARER_TOKEN}")
    String bearerToken;

    @Value("${SUPABASE_BASE_PATH}")
    String storagePath;


    public PropertyAnnonce saveImagesOnStorage(PropertyAnnonce propertyAnnonce) {
        List<String> imagesPath = new ArrayList<String>();
        Random rnd = new Random();
        try {
            for (MultipartFile file : propertyAnnonce.getImagesPhysique()) {
                if (
                        !file.getOriginalFilename().contains(".webp") &&
                                !file.getOriginalFilename().contains(".jpeg") &&
                                !file.getOriginalFilename().contains(".png")
                ) {
                    throw new GlobalException("vous avez une malle extension dans l'images");
                }
                int random = rnd.nextInt(9999999);
                String path = String.valueOf("AGENCE_ID" + "_" + (System.nanoTime()) + "_" + random);
                Map<String, String> returnedData = feignResource.uploadImages(("Bearer " + bearerToken), "ANNOUNCE_IMAGES", path, file);
                imagesPath.add(storagePath + returnedData.get("Key"));
            }

            propertyAnnonce.getPropertyRequest().setImagesLink(imagesPath);
            return propertyAnnonce;
        } catch (Exception e) {
            throw new GlobalException(e.getMessage());
        }

    }


    public void deleteImagesFromBucket(List<String> imagesPath) {
        for (String element : imagesPath) {
            try {
                String currentPath = element.replace("https://yarlrybrsqapllwioing.supabase.co/storage/v1/object/public/ANNOUNCE_IMAGES/", "");
                Map<String, String> backResult = feignResource.deleteFolderFromBucketResource(("Bearer " + bearerToken), "ANNOUNCE_IMAGES", currentPath);
            } catch (Exception e) {
                throw new GlobalException(e.getMessage());
            }
        }
    }


    @Override
    public boolean handle(PropertyAnnonce request) {
        System.out.println("image handler class");
        saveImagesOnStorage(request);
        return false;
    }

    @Override
    public boolean handleTwo(PropertyAnnonce request) {
        /*if(!request.getLinksDeleted().isEmpty()){
            deleteImagesFromBucket(request.getLinksDeleted());
        }
        if(!request.getImagesPhysique().isEmpty()){
            saveImagesOnStorage(request);
        }*/
        return false;
    }
}
