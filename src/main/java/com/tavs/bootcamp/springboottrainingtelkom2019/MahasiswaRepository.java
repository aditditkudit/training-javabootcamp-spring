package com.tavs.bootcamp.springboottrainingtelkom2019;

import com.tavs.bootcamp.springboottrainingtelkom2019.model.Mahasiswa;
import org.springframework.data.repository.CrudRepository;

public interface MahasiswaRepository extends CrudRepository<Mahasiswa, Integer> {
}
