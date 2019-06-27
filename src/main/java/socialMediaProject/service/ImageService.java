package socialMediaProject.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ImageService {

//    @Value("${image.destination}")
    private String imageDestination = "/Users/canberkcebeci/Desktop/project-images/";

    public List<String> saveImages(MultipartFile[] multipartFiles) {

        List<String> imageUrls = new ArrayList<>();
        for (MultipartFile file : multipartFiles) {
            UUID uuid = UUID.randomUUID();
            Path path = Paths.get(imageDestination + uuid.toString() + ".jpg");
            try {
                file.transferTo(path);
                imageUrls.add(uuid.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return imageUrls;
    }
}
