package com.seloger.propertyPart.property;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PropertyAnnonce {
    PropertyRequest propertyRequest;
    List<MultipartFile> imagesPhysique;
    List<String>imagesLink;
    List<String>linksDeleted=new ArrayList<>();

}
