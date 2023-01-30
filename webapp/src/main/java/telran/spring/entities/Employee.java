package telran.spring.entities;

import java.io.Serializable;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.Data;

@Validated
@Data
@Entity
@Table(name = "employees")
public class Employee implements Serializable {

	static final long serialVersionUID = 598507905611091731L;

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	Long id;

	@Column(name = "firstname")
	@NotBlank
    @Pattern(regexp = "^[A-Z][a-z]+")
	String firstName;

	@Column(name = "lastname")
	@NotBlank
    @Pattern(regexp = "^[A-Z][a-z]+")
	String lastName;

	@Column(name = "birthdate")
	@JsonFormat(pattern = "yyyy-MM-dd")
	String birthDate;

	@Column(name = "salary")
	@Min(5000)
	@Max(40000)
	Long salary;

}
