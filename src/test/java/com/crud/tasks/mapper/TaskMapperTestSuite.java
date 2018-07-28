package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TaskMapperTestSuite {
    @InjectMocks
    private TaskMapper taskMapper;

    @Test
    public void testTaskMapperMapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "Task no. 1", "content1");
        //When
        Task task = taskMapper.mapToTask(taskDto);
        //Then
        Assert.assertEquals((Long)1L, task.getId());
        Assert.assertEquals("Task no. 1", task.getTitle());
        Assert.assertEquals("content1", task.getContent());
    }

    @Test
    public void testTaskMapperMapToTaskDto() {
        //Given
        Task task = new Task(1L, "Task no. 1", "content1");
        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);
        //Then
        Assert.assertEquals((Long)1L, taskDto.getId());
        Assert.assertEquals("Task no. 1", taskDto.getTitle());
        Assert.assertEquals("content1", taskDto.getContent());
    }

    @Test
    public void testTaskMapperMapToTaskDtoList() {
        //Given
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(1L, "Task no. 1", "content1"));
        taskList.add(new Task(2L, "Task no. 2", "content2"));
        taskList.add(new Task(3L, "Task no. 3", "content3"));
        //When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(taskList);
        //Then
        Assert.assertEquals((Long)3L, taskDtoList.get(2).getId());
        Assert.assertEquals("Task no. 3", taskDtoList.get(2).getTitle());
        Assert.assertEquals("content3", taskDtoList.get(2).getContent());
    }
}
