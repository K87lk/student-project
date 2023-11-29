package mapper;

import com.example.studentproject.dto.StudentDto;
import com.example.studentproject.entity.Group;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.studentproject.dto.GroupDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ObjectConversionTest {

   private GroupDto groupDto;

    @Test
    public void testConversion() throws JsonProcessingException {
//
//
//        groupDto = GroupDto.builder()
//                .id(1L)
//                .number("IT404")
//                .students(533).build();
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String json = objectMapper.writeValueAsString(groupDto);
//        System.out.println(json);


        ObjectMapper objectMapper = new ObjectMapper();
        StudentDto studentDto =
                new StudentDto(1L, null, "Ivan Igorev",
                new Group());

        String jsonString = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(studentDto);
        System.out.println(jsonString);
    }
}
