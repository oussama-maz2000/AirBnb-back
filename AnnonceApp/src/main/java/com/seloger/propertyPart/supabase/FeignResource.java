package com.seloger.propertyPart.supabase;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@FeignClient(name = "property-file", url = "https://yarlrybrsqapllwioing.supabase.co/storage/v1")
public interface FeignResource {

    @PostMapping(value = "/object/{bucketName}/{path}",
            consumes = { MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    Map<String, String> uploadImages(
            @RequestHeader(value = "Authorization") String bearerToken,
            @PathVariable("bucketName") String bucketName,
            @PathVariable("path") String path,
            @RequestPart(value = "file") MultipartFile file);


    @GetMapping(value = "/bucket/{bucketId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    Map<String, String> getBucketInfoResource(
            @RequestHeader(value = "Authorization") String bearerToken,
            @PathVariable("bucketId") String bucketId);


    @PostMapping(value = "/bucket/",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    Map<String, String> createNewBucketResource(
            @RequestHeader(value = "Authorization") String bearerToken,
            @RequestBody Map<String, ?> bucket);


    @PostMapping (value = "/bucket/{bucketId}/empty",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    Map<String,String> dischargeBucketResource(
            @RequestHeader(value = "Authorization") String bearerToken,
            @PathVariable("bucketId") String bucketId);


    @GetMapping(value = "/bucket/{bucketId}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    Map<String,?> getBucketDetailsResource(
            @RequestHeader(value = "Authorization") String bearerToken,
            @PathVariable("bucketId") String bucketName);


    @DeleteMapping(value = "/object/{bucketId}")
    Map<String, String> deleteBucketResource(
            @RequestHeader(value = "Authorization") String bearerToken,
            @PathVariable("bucketId") String bucketId);


    @DeleteMapping(value = "/object/{bucketName}/{wildcard}")
    Map<String, String> deleteFolderFromBucketResource(
            @RequestHeader(value = "Authorization") String bearerToken,
            @PathVariable("bucketName") String bucketName,
            @PathVariable("wildcard") String wildcard

            );



    // --------- Retrieve an object from public bucket------------//

    @GetMapping(value = "/object/public/{bucketName}/{wildcard}")
    MultipartFile retrieveObject(
            @RequestHeader(value = "Authorization") String bearerToken,
            @PathVariable("bucketName") String bucketName,
            @PathVariable("wildcard") String wildcard
    );



    @PutMapping(value = "/object/{bucketName}/{wildcard}")
    public Map<String,String> updateImages(@RequestHeader(value = "Authorization") String bearerToken,
                                           @PathVariable("bucketName") String bucketName,
                                           @PathVariable("wildcard") String wildcard);





}

