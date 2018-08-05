package com.crud.tasks.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TaskDtoTestSuite {
    @Test
    public void testGettersWhenNoArgsConstructor() {
        //Given
        TaskDto taskDto = new TaskDto();

        //When@Then
        assertNull(taskDto.getId());
        assertNull(taskDto.getTitle());
        assertNull(taskDto.getContent());
    }

    @Test
    public void testGettersWhenAllArgsConstructor() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "No. 1", "Desc. no 1");

        //When@Then
        assertEquals(Long.valueOf(1), taskDto.getId());
        assertEquals("No. 1", taskDto.getTitle());
        assertEquals("Desc. no 1", taskDto.getContent());
    }
}
