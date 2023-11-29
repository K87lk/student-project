package service;


import dto.GroupDto;
import entity.Group;

import java.util.List;
import java.util.Optional;

public interface GroupService {

    List<Group> getAllGroups();

    Group getGroupById(Long id);

    Group createGroup(Group group);

    Group updateGroup(Long id, Group group);

    void deleteGroup(Long id);

}
