package com.example.studentproject.controller;

import com.example.studentproject.dto.GroupDto;
import com.example.studentproject.entity.Group;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import com.example.studentproject.service.GroupServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class GroupController {

    private final ModelMapper modelMapper;

    private final GroupServiceImpl groupService;

    public GroupController(ModelMapper modelMapper, GroupServiceImpl groupService) {
        this.modelMapper = modelMapper;
        this.groupService = groupService;
    }

    @GetMapping("/groups")
    public List<GroupDto> getAllGroups() {
        return groupService.getAllGroups().stream()
                .map(group -> modelMapper.map(group, GroupDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/groups/{id}")
    public GroupDto getGroupById(@PathVariable Long id) {
        Group group = groupService.getGroupById(id);
        return modelMapper.map(group, GroupDto.class);
    }

    @PostMapping("/groups")
    public GroupDto createGroup(@RequestBody GroupDto groupDto) {
        Group groupRequest = modelMapper.map(groupDto, Group.class);
        Group group = groupService.createGroup(groupRequest);
        return modelMapper.map(group, GroupDto.class);
    }

    @PutMapping("/groups/{id}")
    public GroupDto updateGroup(@PathVariable Long id, @RequestBody GroupDto groupDto) {
        Group groupRequest = modelMapper.map(groupDto, Group.class);
        Group group = groupService.updateGroup(id, groupRequest);
        return modelMapper.map(group, GroupDto.class);
    }

    @DeleteMapping("/groups/{id}")
    public void deleteGroup(@PathVariable Long id) {
        groupService.deleteGroup(id);
    }
}
