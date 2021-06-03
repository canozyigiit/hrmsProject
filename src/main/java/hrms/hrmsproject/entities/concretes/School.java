package hrms.hrmsproject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "schools")
@NoArgsConstructor
@AllArgsConstructor
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(targetEntity = Resume.class)
    @JoinColumn(name="resume_id")
    private Resume resume;

    @Column(name="school_name")
    @NotBlank
    @NotNull
    private String schoolName;

    @ManyToOne(targetEntity = Graduate.class)
    @JoinColumn(name = "graduate_id", referencedColumnName =  "id" ,nullable = false)
    private Graduate graduate;

    @Column(name="school_department")
    @NotBlank
    @NotNull
    private String schoolDepartment;

    @Column(name="started_date")
    @NotBlank
    @NotNull
    private LocalDate startedDate;

    @Column(name="ended_date")
    private LocalDate endedDate;

    @Column(name="created_date")
    @JsonIgnore
    private LocalDate createdDate = LocalDate.now();
}
