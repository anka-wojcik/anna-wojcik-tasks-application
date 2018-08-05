package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DbServiceTestSuite {
    @InjectMocks
    private DbService dbService;

    @Mock
    TaskRepository repository;

    @Test
    public void testGetAllTasks() {
        //Given
        List<Task> tasks = Arrays.asList(new Task(1L, "Task no. 1", "content no. 1"));
        when(repository.findAll()).thenReturn(tasks);
        //When
        List<Task> taskList = dbService.getAllTasks();
        //Then
        assertEquals(tasks, taskList);
    }

    @Test
    public void testSaveTask() {
        //Given
        Task task = new Task(1L,"Task no. 1", "content no. 1");
        when(repository.save(task)).thenReturn(task);
        //When
        Task task1 = dbService.saveTask(task);
        //Then
        assertEquals(task, task1);
    }

    @Test
    public void testGetTask() {
        //Given
        Task task = new Task(1L,"Task no. 1", "content no. 1");
        when(repository.findById(1L)).thenReturn(Optional.of(task));
        when(repository.findById(2L)).thenReturn(Optional.empty());
        //When
        Optional<Task> task1 = dbService.getTask(1L);
        Optional<Task> task2 = dbService.getTask(2L);
        //Then
        assertTrue(task1.isPresent());
        assertFalse(task2.isPresent());
        assertEquals(task, task1.get());
    }

    @Test
    public void testDeleteTask() {
        //Given&When
        dbService.deleteTask(1L);
        //Then
        verify(repository, times(1)).deleteById(1L);
    }
}
