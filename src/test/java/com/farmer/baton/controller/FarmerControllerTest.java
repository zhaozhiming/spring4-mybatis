package com.farmer.baton.controller;

import com.farmer.baton.model.Farmer;
import com.farmer.baton.repo.FarmerRepository;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FarmerControllerTest {

    @InjectMocks
    private FarmerController farmerController;

    @Mock
    private FarmerRepository farmerRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_create_farmers_correct() throws Exception {
        when(farmerRepository.save(any(Farmer.class))).thenReturn(null);
        when(farmerRepository.findByAge(anyInt())).thenReturn(null);

        farmerController.create();

        verify(farmerRepository, times(2)).save(any(Farmer.class));
        verify(farmerRepository).findByAge(anyInt());
    }

    @Test
    public void should_find_all_farmers_correct() throws Exception {
        when(farmerRepository.findAll()).thenReturn(Lists.newArrayList(new Farmer("test", 30)));

        String farmers = farmerController.search("test");

        assertThat(farmers, containsString("\"name\":\"test\",\"age\":30"));
        verify(farmerRepository).findAll();
    }
}