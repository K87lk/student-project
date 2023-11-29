package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "enroll_date")
    private LocalDateTime enrollDate;
    @Column(name = "student_name")
    private String studentName;
    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group studentGroup;
}
