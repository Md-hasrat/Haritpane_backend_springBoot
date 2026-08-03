package com.Haritpane.springBoot_haritpane_backend.services.servicesImp;

import com.Haritpane.springBoot_haritpane_backend.config.AwsProperties;
import com.Haritpane.springBoot_haritpane_backend.exception.FileUploadException;
import com.Haritpane.springBoot_haritpane_backend.services.FileUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.util.UUID;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    private final S3Client s3Client;
    private final AwsProperties awsProperties;

    public FileUploadServiceImpl(S3Client s3Client, AwsProperties awsProperties) {
        this.s3Client = s3Client;
        this.awsProperties = awsProperties;
    }

    @Override
    public String uploadFile(MultipartFile file) {

        if (file == null || file.isEmpty()) {
            throw new FileUploadException("File is required");
        }

        try {

            String originalFileName = file.getOriginalFilename();

            String extension = "";

            if (originalFileName != null && originalFileName.contains(".")) {
                extension = originalFileName.substring(originalFileName.lastIndexOf("."));
            }

            String fileName = UUID.randomUUID() + extension;

            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(awsProperties.getBucketName())
                    .key(fileName)
                    .contentType(file.getContentType())
                    .build();

            s3Client.putObject(
                    putObjectRequest,
                    RequestBody.fromBytes(file.getBytes())
            );

            return String.format(
                    "https://%s.s3.%s.amazonaws.com/%s",
                    awsProperties.getBucketName(),
                    awsProperties.getRegion(),
                    fileName
            );

        } catch (IOException e) {
            throw new FileUploadException("Unable to upload file", e);
        }
    }

    @Override
    public void deleteFile(String fileKey) {

    }
}