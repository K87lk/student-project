package service;

import dto.GroupDto;
import entity.Group;
import org.springframework.stereotype.Service;
import repository.GroupRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }


    @Override
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    @Override
    public Group getGroupById(Long id) {
        Optional<Group> result = groupRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public Group createGroup(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Group updateGroup(Long id, Group groupRequest) {
        Group group = groupRepository.findById(id).orElse(null);

        group.setId(groupRequest.getId());
        group.setNumber(groupRequest.getNumber());
        group.setStudents(groupRequest.getStudents());

        return groupRepository.save(group);
    }

    @Override
    public void deleteGroup(Long id) {
        Group group = groupRepository.findById(id).orElse(null);
        groupRepository.delete(group);
    }
}
