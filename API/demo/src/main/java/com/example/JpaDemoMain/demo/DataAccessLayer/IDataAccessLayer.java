package com.example.JpaDemoMain.demo.DataAccessLayer;

import com.example.JpaDemoMain.demo.Model.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDataAccessLayer extends JpaRepository<People, Long> {


}
