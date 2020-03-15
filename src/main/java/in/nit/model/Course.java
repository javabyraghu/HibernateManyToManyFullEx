package in.nit.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="crstab")
public class Course {
	@Id
	@Column(name="crsid")
	@NonNull
	private Integer courseId;
	
	@Column(name="crsname")
	@NonNull
	private String courseName;
	
	@Column(name="crsfee")
	@NonNull
	private Double courseFee;
	
	@ManyToMany(mappedBy = "cobs",fetch = FetchType.EAGER)
	private List<Student> stdObs;
}
