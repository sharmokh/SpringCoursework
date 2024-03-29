package com.sharmokh.recipeapp.services;

import com.sharmokh.recipeapp.model.Recipe;
import com.sharmokh.recipeapp.repositories.RecipeRepository;
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
    public void saveImageFile(Long recipeId, MultipartFile file) {
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
