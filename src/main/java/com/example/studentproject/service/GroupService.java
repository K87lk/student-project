package com.example.studentproject.service;


import com.example.studentproject.entity.Group;

import java.util.List;

public interface GroupService {

    List<Group> getAllGroups();

    Group getGroupById(Long id);

    Group createGroup(Group group);

    Group updateGroup(Long id, Group group);

    void deleteGroup(Long id);

}
