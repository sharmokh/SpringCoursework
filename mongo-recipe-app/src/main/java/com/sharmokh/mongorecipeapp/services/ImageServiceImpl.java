package com.sharmokh.mongorecipeapp.services;

import com.sharmokh.mongorecipeapp.model.Recipe;
import com.sharmokh.mongorecipeapp.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

    private final RecipeRepository recipeRepository;

    public ImageServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    @Transactional
    public void saveImageFile(String recipeId, MultipartFile file) {
        try {

            Recipe recipe = recipeRepository.findById(recipeId).get();
            Byte[] bytesObject = new Byte[file.getBytes().length];

            int i = 0;
            for (byte primByte : file.getBytes()) {
                bytesObject[i++] = primByte;
            }

            recipe.setImage(bytesObject);
            recipeRepository.save(recipe);
            log.debug("Uploaded a photo!");

        } catch (IOException e) {

            log.debug("Error occurred: " + e);
            e.printStackTrace();

        }
    }
}
