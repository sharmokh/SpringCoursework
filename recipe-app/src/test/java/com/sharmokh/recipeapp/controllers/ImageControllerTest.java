package com.sharmokh.recipeapp.controllers;

import com.sharmokh.recipeapp.commands.RecipeCommand;
import com.sharmokh.recipeapp.services.ImageService;
import com.sharmokh.recipeapp.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ImageControllerTest {

    @Mock
    RecipeService recipeService;
    @Mock
    ImageService imageService;

    ImageController imageController;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        imageController = new ImageController(imageService, recipeService);
        mockMvc = MockMvcBuilders.standaloneSetup(imageController).build();
    }

    @Test
    public void testUploadNewImagePage() throws Exception {
        RecipeCommand recipeCommand = RecipeCommand.builder().id(1L).build();
        when(recipeService.findCommandById(anyLong())).thenReturn(recipeCommand);

        mockMvc.perform(get("/recipe/1/images"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/image_form"))
                .andExpect(model().attributeExists("recipe"));
        verify(recipeService, times(1)).findCommandById(anyLong());
    }

    @Test
    public void testPostImage() throws Exception {
        MockMultipartFile mockMultipartFile = new MockMultipartFile("imagefile", "testing.txt", "text/plain",
                "images".getBytes());

        mockMvc.perform(multipart("/recipe/1/images").file(mockMultipartFile))
                .andExpect(status().is3xxRedirection())
                .andExpect(header().string("Location", "/recipe/1/show"));

        verify(imageService, times(1)).saveImageFile(anyLong(), any());
    }
}